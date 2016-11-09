package com.zulu.idits.adaptador;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zulu.idits.fragmentos.Cursos;
import com.zulu.idits.fragmentos.Formulario;
import com.zulu.idits.fragmentos.Home;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public static final int TABS_COUNT = 3;
    public static final String[] titulosTab = {"Home","Cursos","Inscribite"};
    private Fragment[] pestanias = {new Home(),new Cursos(),new Formulario()};

    //Necesita un servicio que maneje las pestañas fm maneja todo
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //Devuelve cada pestaña a la activity dependiendo del parametro position
    //Ej el user selecciona la pestaña 2 llega aca y sabe que debe crear
    //Una ventana/fragment del tipo CURSOS.
    @Override
    public Fragment getItem(int position) {
        return pestanias[position];
    }

    //Le indica al controlador de pestañas cuantas pestaña tiene en su interior
    @Override
    public int getCount() {
        return TABS_COUNT;
    }

    //Devuelve el nombre que tendra cada tab ej: HOME, CURSOS, INSCRIBITE
    @Override
    public CharSequence getPageTitle(int position) {
        return titulosTab[position] ;
    }
}
