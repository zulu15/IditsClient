package com.zulu.idits.fragmentos;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.zulu.idits.R;
import com.zulu.idits.db.UsuarioDAO;
import com.zulu.idits.modelo.Usuario;
import com.zulu.idits.utils.ConexionUtil;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Formulario extends Fragment implements DatePickerDialog.OnDataSetListener {


    private static final String TAG = Formulario.class.getSimpleName();
    private EditText editFechaNacimiento, editNombre, editApellido, editDni, editCuil, editTelefono, editEmail, editCodigoPostal;
    private Spinner comboProvincia;
    private RadioGroup grupoDeRadios;
    private FloatingActionButton fab;
    private boolean isFirstSetup = true;
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioApp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Vamos a crear la interfaz grafica
        View interfazDelFragmento = inflater.inflate(R.layout.formulario, container, false);
        //Obtenemos los elementos visuales
        editFechaNacimiento = (EditText) interfazDelFragmento.findViewById(R.id.edit_date);
        editNombre = (EditText) interfazDelFragmento.findViewById(R.id.nombre_per);
        editApellido = (EditText) interfazDelFragmento.findViewById(R.id.apellido_per);
        editDni = (EditText) interfazDelFragmento.findViewById(R.id.dni_per);
        editCuil = (EditText) interfazDelFragmento.findViewById(R.id.cuil_per);
        editTelefono = (EditText) interfazDelFragmento.findViewById(R.id.telefono_per);
        editEmail = (EditText) interfazDelFragmento.findViewById(R.id.email_per);
        editCodigoPostal = (EditText) interfazDelFragmento.findViewById(R.id.codpostal_per);

        comboProvincia = (Spinner) interfazDelFragmento.findViewById(R.id.prov_spinner_per);
        grupoDeRadios = (RadioGroup) interfazDelFragmento.findViewById(R.id.radio_group);


        editFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog();
                //Cuando nuestro dialogo sea abierto y se seleccione la fecha esta
                //fragmento va a recibir lo escogido por el usuarioApp
                datePickerDialog.setOnDataSetListener(Formulario.this);
                datePickerDialog.show(getActivity().getSupportFragmentManager(), "TAG");
            }
        });

        //Cambiamos el icono del boton para que refleje la accion del formulario
        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_action_save));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFormularioCompleto()) {
                    //Obtenemos el radiobutton seleccionado
                    RadioButton radioSelected = (RadioButton) grupoDeRadios.findViewById(grupoDeRadios.getCheckedRadioButtonId());
                    //Creamos el usuarioApp con los datos del formulario
                    Usuario usuario = new Usuario(Integer.parseInt(editDni.getText().toString()), editNombre.getText().toString(), editApellido.getText().toString(), editCuil.getText().toString(), editEmail.getText().toString(), comboProvincia.getSelectedItem().toString(), editFechaNacimiento.getText().toString(), Integer.parseInt(editTelefono.getText().toString().trim()), editCodigoPostal.getText().toString().isEmpty() ? 0 : Integer.parseInt(editCodigoPostal.getText().toString()), radioSelected.getText().equals("Si"));
                    guardarActualizarUsuario(usuario);

                }
            }
        });


        return interfazDelFragmento;
    }


    private void guardarActualizarUsuario(Usuario usuario) {
        //Si el usuario registra sus datos por primera vez
        if (isFirstSetup) {
            //Y tiene conexion a internet guardamos sus datos en la nube
            //Y guardamos una copia en la base de datos local
            //para tener un cache en caso de no tener conexion
            if (ConexionUtil.isNetworkAvailable(getActivity())) {
                usuarioDAO.guardarUsuario(usuario);
                new AltaUsuarioWebServiceTask().execute(usuario);
            } else {
                //De lo contrario guardamos sus datos localmente
                Toast.makeText(getActivity(), usuarioDAO.guardarUsuario(usuario) != -1 ? "Sus datos se guardaron localmente por favor habilite su conexión a internet " : " Hubo un error al procesar los datos ", Toast.LENGTH_SHORT).show();
            }

        } else {
            //Si ya ha dado de alta sus datos y hay cambios los actualizamos
            if (!usuarioApp.equals(usuario)) {
                //Actualizamos la referencia
                usuarioApp = usuario;
                if (ConexionUtil.isNetworkAvailable(getActivity())) {
                    //Y tiene conexion a internet guardamos sus datos en la nube
                    //TODO: Deberia existir algun metodo del backend que actualice los datos del usuario
                    usuarioDAO.actualizarUsuario(usuario);
                    new AltaUsuarioWebServiceTask().execute(usuario);
                } else {
                    //De lo contrario actualizamos sus datos localmente
                    Toast.makeText(getActivity(), usuarioDAO.actualizarUsuario(usuario) != -1 ? "Sus datos se actualizaron correctamente " : " Hubo un error al actualizar los datos ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "No se detectaron cambios para guardar", Toast.LENGTH_SHORT).show();

            }

        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Objeto que se encarga de acceder a la capa de datos
        usuarioDAO = new UsuarioDAO(getActivity());
        //Obtenemos el usuario que ha dado de alta sus datos
        usuarioApp = usuarioDAO.buscarUsuario();

        if (usuarioApp != null) {
            rellenarFormulario(usuarioApp);
            //Desabilitamos la modificacion del dni para evitar creacion de nuevos registros
            editDni.setFocusable(false);
            //Bandera que indica si ya existe un usuarioApp registrado
            isFirstSetup = false;
            TextView txtTitulo = (TextView) getActivity().findViewById(R.id.title_text);
            txtTitulo.setText("Edite sus datos personales");
        }


        //Se ha recreado el fragmento
        if (savedInstanceState != null) {
            //Entonces volvemos a setear el listener que se removio del dialogo
            DatePickerDialog datePickerDialog = (DatePickerDialog) getActivity().getSupportFragmentManager().findFragmentByTag("TAG");
            if (datePickerDialog != null) {
                datePickerDialog.setOnDataSetListener(Formulario.this);
            }
        }

    }

    //Rellena los campos del formulario con los datos del usuarioApp
    public void rellenarFormulario(Usuario usuario) {
        editNombre.setText(usuario.getNombre());
        editApellido.setText(usuario.getApellido());
        editDni.setText(usuario.getDni() + "");
        editCuil.setText(usuario.getCuil());
        editTelefono.setText(usuario.getTelefono() + "");
        editEmail.setText(usuario.getEmail());
        //Obtenemos el array de provincias de los recursos y lo convertimos a list
        List provinciasList = Arrays.asList(getResources().getStringArray(R.array.provincias));
        //Dentro del combo de provincias le indicamos que el elemento a mostrar es el que tiene de indice y buscamos la posicion de esa provincia dentro del array
        comboProvincia.setSelection(provinciasList.indexOf(usuario.getProvincia()));
        editCodigoPostal.setText(usuario.getCodigoPostal() + "");
        editFechaNacimiento.setText(usuario.getFechaDeNacimiento());
        if (usuario.realizaAportes()) {
            RadioButton radioSi = (RadioButton) grupoDeRadios.findViewById(R.id.radioSi);
            radioSi.setChecked(true);
        } else {
            RadioButton radioNo = (RadioButton) grupoDeRadios.findViewById(R.id.radioNo);
            radioNo.setChecked(true);
        }
    }

    //Valida el formulario
    private boolean isFormularioCompleto() {
        boolean isRegistroCompleto = true;

        if (editNombre.getText().toString().trim().isEmpty()) {
            Snackbar.make(fab, "El campo nombre no puede estar vacio", Snackbar.LENGTH_LONG).show();
            editNombre.requestFocus();
            isRegistroCompleto = false;
        } else if (editApellido.getText().toString().trim().isEmpty()) {
            Snackbar.make(fab, "El campo apellido no puede estar vacio", Snackbar.LENGTH_LONG).show();
            editApellido.requestFocus();
            isRegistroCompleto = false;
        } else if (editDni.getText().toString().trim().isEmpty() || editDni.getText().toString().length() < 8) {
            Snackbar.make(fab, editDni.getText().toString().trim().isEmpty() ? "Complete su dni por favor" : "Su dni es inválido", Snackbar.LENGTH_LONG).show();
            editDni.requestFocus();
            isRegistroCompleto = false;
        } else if (editTelefono.getText().toString().trim().isEmpty()) {
            Snackbar.make(fab, "Complete su numero de teléfono", Snackbar.LENGTH_LONG).show();
            editTelefono.requestFocus();
            isRegistroCompleto = false;
        } else if (!isValidEmail(editEmail.getText())) {
            Snackbar.make(fab, editEmail.getText().toString().trim().isEmpty() ? "Por favor complete su email" : "Su email no es válido", Snackbar.LENGTH_LONG).show();
            editEmail.requestFocus();
            isRegistroCompleto = false;
        } else if (comboProvincia.getSelectedItem().toString().isEmpty()) {
            Snackbar.make(fab, "Seleccione una provincia", Snackbar.LENGTH_LONG).show();
            comboProvincia.requestFocus();
            isRegistroCompleto = false;
        } else if (!editCodigoPostal.getText().toString().isEmpty() && editCodigoPostal.getText().toString().length() < 4) {
            Snackbar.make(fab, "Código postal inválido", Snackbar.LENGTH_LONG).show();
            editCodigoPostal.requestFocus();
            isRegistroCompleto = false;
        } else if (editFechaNacimiento.getText().toString().isEmpty()) {
            Snackbar.make(fab, "Indique su fecha de nacimiento", Snackbar.LENGTH_LONG).show();
            editFechaNacimiento.requestFocus();
            isRegistroCompleto = false;
        }


        return isRegistroCompleto;
    }

    @Override
    public void onDataSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        //Este metodo recibe el año mes y dia de nacimiento para setearlo en la vista
        editFechaNacimiento.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
    }


    //Verifica que el formato de email sea correcto
    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


    private class AltaUsuarioWebServiceTask extends AsyncTask<Usuario, Void, Integer> {

        private ProgressDialog mDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mDialog = new ProgressDialog(getActivity());
            mDialog.setMessage("Registrando sus datos en el servidor...");
            mDialog.show();
        }

        @Override
        protected Integer doInBackground(Usuario... params) {
            int statusCode = -1;
            if (ConexionUtil.isNetworkAvailable(getActivity())) {
                try {
                    URL urlConnection = new URL("http://iditswebservice.esy.es/alta_usuario.php");

                    HttpURLConnection conn = (HttpURLConnection) urlConnection.openConnection();
                    conn.setDoOutput(true);


                    conn.setReadTimeout(10000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    Uri.Builder builder = new Uri.Builder()


                            .appendQueryParameter("dni", params[0].getDni() + "")
                            .appendQueryParameter("cuil", params[0].getCuil())
                            .appendQueryParameter("nombre", params[0].getNombre())
                            .appendQueryParameter("apellido", params[0].getApellido())

                            .appendQueryParameter("fechaDeNacimiento", params[0].getFechaDeNacimiento())
                            .appendQueryParameter("telefono", params[0].getTelefono() + "")
                            .appendQueryParameter("email", params[0].getEmail())
                            .appendQueryParameter("provincia", params[0].getProvincia())
                            .appendQueryParameter("codigoPostal", params[0].getCodigoPostal() + "")
                            .appendQueryParameter("realizaAportes", params[0].realizaAportes() + "");


                    String query = builder.build().getEncodedQuery();

                    OutputStream os = conn.getOutputStream();

                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                    os.close();

                    conn.connect();
                    statusCode = conn.getResponseCode();
                    Log.i("Conexion", "Los parametros enviados son " + query + " El codigo de respuesta es " + statusCode);
                    //Toast.makeText(getActivity(),conn.getResponseCode() == 200 ? "Su inscripcion fue exitosa!": "Hubo un problema al conectarse al servidor",Toast.LENGTH_SHORT).show();

                } catch (SocketTimeoutException e) {
                    statusCode= HttpURLConnection.HTTP_CLIENT_TIMEOUT;
                    e.printStackTrace();
                } catch (Exception e) {
                    statusCode = HttpURLConnection.HTTP_CONFLICT;
                    e.printStackTrace();
                }
                return statusCode;


            }
            return statusCode;
        }


        @Override
        protected void onPostExecute(Integer responseCode) {
            super.onPostExecute(responseCode);
            mDialog.dismiss();
            Toast.makeText(getActivity(), responseCode == HttpURLConnection.HTTP_OK ? "Sus datos se guardaron correctamente" : responseCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT ? "El servidor tardo demasiado en responder. Intentelo nuevamente" : "Se produjo un error al comunicarse con el servidor", Toast.LENGTH_LONG).show();

        }
    }

}
