package com.zulu.idits.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.zulu.idits.modelo.Usuario;




public class UsuarioDAO extends SQLiteHelper  {


    private static final String TAG = UsuarioDAO.class.getSimpleName();

    public UsuarioDAO(Context context) {
        super(context);
    }



    public long guardarUsuario(Usuario usuario) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(C_DNI, usuario.getDni());
        valores.put(C_NOMBRE, usuario.getNombre());
        valores.put(C_APELLIDO, usuario.getApellido());
        valores.put(C_FECHA_NACIMIENTO, usuario.getFechaDeNacimiento());
        valores.put(C_CUIL, usuario.getCuil());
        valores.put(C_EMAIL, usuario.getEmail());
        valores.put(C_TELEFONO, usuario.getTelefono());
        valores.put(C_PROVINCIA, usuario.getProvincia());
        valores.put(C_CODIGO_POSTAL, usuario.getCodigoPostal());
        valores.put(C_APORTES, usuario.realizaAportes() ? 1 : 0);

        long newRowId = database.insert(TABLE_NAME, null, valores);
        database.close();

        Log.i(TAG, "Se agrego un registro a la base de datos con id " + newRowId);

        return newRowId;
    }


    //Como localmente va a existir un solo usuario por la logica de la aplicacion
    //Este metodo devuelve el usuario encontrado o de lo contrario null
    //si el usuario aun no ha completado sus datos
    public Usuario buscarUsuario() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " LIMIT 1", null);
        if (c.moveToFirst()) {
            Usuario usuarioEncontrado = new Usuario(c.getInt(C_DNI_INDEX), c.getString(C_ID_NOMBRE_INDEX), c.getString(C_APELLIDO_INDEX), c.getString(C_CUIL_INDEX), c.getString(C_EMAIL_INDEX), c.getString(C_PROVINCIA_INDEX), c.getString(C_FECHA_INDEX), c.getInt(C_TELEFONO_INDEX), c.getInt(C_CODIGO_POSTAL_INDEX), c.getInt(C_APORTES_INDEX) == 1);
            c.close();
            db.close();
            return usuarioEncontrado;
        }
        c.close();
        db.close();
        return null;
    }



    public long actualizarUsuario(Usuario usuario) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(C_DNI, usuario.getDni());
        valores.put(C_NOMBRE, usuario.getNombre());
        valores.put(C_APELLIDO, usuario.getApellido());
        valores.put(C_FECHA_NACIMIENTO, usuario.getFechaDeNacimiento());
        valores.put(C_CUIL, usuario.getCuil());
        valores.put(C_EMAIL, usuario.getEmail());
        valores.put(C_TELEFONO, usuario.getTelefono());
        valores.put(C_PROVINCIA, usuario.getProvincia());
        valores.put(C_CODIGO_POSTAL, usuario.getCodigoPostal());
        valores.put(C_APORTES, usuario.realizaAportes() ? 1 : 0);

        long newRowId = database.update(TABLE_NAME, valores,C_DNI+" = ?", new String[]{String.valueOf(usuario.getDni())} );
        database.close();

        Log.i(TAG, "Se actualizo un registro con id " + newRowId);

        return newRowId;
    }




}
