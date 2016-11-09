package com.zulu.idits.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

//Clase creada para proveer informacion del estado de la red del dispositivo
public final class ConexionUtil {

    //Constructor privada para evitar instanciacion
    private ConexionUtil(){}


    //Metodo utilitario para saber si el usuario dispone de conexion a internet
    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
