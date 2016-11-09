package com.zulu.idits.fragmentos;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zulu.idits.R;
import com.zulu.idits.adaptador.ViewPagerAdapter;
import com.zulu.idits.db.UsuarioDAO;
import com.zulu.idits.modelo.Usuario;
import com.zulu.idits.utils.ConexionUtil;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class CursoDetalle extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View interfazFragmentoCursoDetalle = inflater.inflate(R.layout.curso_detalle, container, false);
        TextView tvNombre = (TextView) interfazFragmentoCursoDetalle.findViewById(R.id.nombre_curso);
        TextView tvContenido = (TextView) interfazFragmentoCursoDetalle.findViewById(R.id.contenido_curso);
        Button btnInscribite = (Button) interfazFragmentoCursoDetalle.findViewById(R.id.btn_inscribite);

        final UsuarioDAO usuarioDAO = new UsuarioDAO(this.getContext());
        final Usuario usuario = usuarioDAO.buscarUsuario();

        final int idCurso = getArguments().getInt("idcurso");
        String nombre = getArguments().getString("nombre");
        String contenido = getArguments().getString("contenido");
        tvNombre.setText(Html.fromHtml(nombre));
        tvContenido.setText(Html.fromHtml(contenido));

        btnInscribite.setOnClickListener(new View.OnClickListener() {
            class ExecuteTask extends AsyncTask<String, Void, Integer> {
                ProgressDialog mDialog;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    mDialog = new ProgressDialog(getActivity());
                    mDialog.setMessage("Aguarde un momento por favor...");
                    mDialog.show();
                }

                @Override
                protected Integer doInBackground(String... params) {


                    return PostData(params);
                }

                private int PostData(String[] params) {
                    int responseCode = -1;
                    try {
                        URL urlConnection = new URL("http://iditswebservice.esy.es/inscripcion.php");

                        HttpURLConnection conn = (HttpURLConnection) urlConnection.openConnection();
                        conn.setDoOutput(true);


                        conn.setReadTimeout(10000);
                        conn.setConnectTimeout(15000);
                        conn.setRequestMethod("POST");
                        conn.setDoInput(true);
                        conn.setDoOutput(true);


                        Uri.Builder builder = new Uri.Builder()

                                .appendQueryParameter("curso_id", params[0])

                                .appendQueryParameter("dni", params[1]);

                        String query = builder.build().getEncodedQuery();

                        OutputStream os = conn.getOutputStream();

                        BufferedWriter writer = new BufferedWriter(
                                new OutputStreamWriter(os, "UTF-8"));
                        writer.write(query);
                        writer.flush();
                        writer.close();
                        os.close();

                        conn.connect();
                        responseCode = conn.getResponseCode();
                        Log.i("Conexion", "Los parametros enviados son " + query + " El codigo de respuesta es " + responseCode);

                    }
                    catch (SocketTimeoutException e){
                        responseCode = HttpURLConnection.HTTP_CLIENT_TIMEOUT;
                        e.printStackTrace();
                    }
                    catch (Exception e) {
                        responseCode = HttpURLConnection.HTTP_CONFLICT;
                        e.printStackTrace();
                    }
                    return responseCode;
                }

                @Override
                protected void onPostExecute(Integer responseCode) {
                    super.onPostExecute(responseCode);
                    mDialog.cancel();
                    Toast.makeText(getActivity(), responseCode == HttpURLConnection.HTTP_OK ? "Su inscripcion fue realizada con exito" : responseCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT ? "El servidor tardo demasiado en responder. Intentelo nuevamente" : "Se produjo un error al comunicarse con el servidor", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onClick(View v) {

                if (usuario != null && idCurso != -1) { // si tenemos idCurso e idUsuario enviamos a servidor, esto es si el usuario esta registrado y se selecciono curso
                    if (ConexionUtil.isNetworkAvailable(getActivity())) {
                        new ExecuteTask().execute(idCurso + "", usuario.getDni() + "");
                    } else {
                        Toast.makeText(getActivity(), "Habilite su conexion a internet antes de inscribirse a un curso", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //Enviamos al usuario a la pantalla de registro
                    Toast.makeText(getActivity(), "Complete sus datos antes de inscribirse a un curso", Toast.LENGTH_SHORT).show();
                    ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
                    viewPager.setCurrentItem(2, true);
                }
            }
        });


        return interfazFragmentoCursoDetalle;

    }


}
