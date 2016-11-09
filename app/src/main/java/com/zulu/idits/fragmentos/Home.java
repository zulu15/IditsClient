package com.zulu.idits.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.zulu.idits.R;

import java.util.HashMap;


public class Home extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    private static final String SLIDER_ID = "SLIDER_ID";
    private SliderLayout mDemoSlider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layoutView = inflater.inflate(R.layout.home, container, false);
        //Inicializamos las vistas
        mDemoSlider = (SliderLayout) layoutView.findViewById(R.id.slider);


        return layoutView;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Definimos los elementos a mostrar: imagen y descripcion

        HashMap<String, Integer> slideFilesMap = new HashMap<>();
        slideFilesMap.put("Capacitate gratis en software y tecnología", R.drawable.slide1);
        slideFilesMap.put("Programador en aplicaciones web HTML, CSS2, Flash, browsers, Javascript", R.drawable.slide2);
        slideFilesMap.put("Informática básica Alfabetización digital", R.drawable.slide3);
        slideFilesMap.put("Inscribite y empeza a participar de los cursos", R.drawable.slide4);

        //Creamos cada pestaña que tendra el "slider" y la agregamos a este
        for (int i = 0; i < slideFilesMap.size(); i++) {

            //Creamos una pestaña que contendra una imagen con una descripcion
            TextSliderView textSliderView = new TextSliderView(getActivity());
            //Creamos la pestaña con sus datos y un evento onclick
            String sliderName = (String) slideFilesMap.keySet().toArray()[i];
            textSliderView
                    .description(sliderName)
                    .image(slideFilesMap.get(sliderName))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //Le enviamos a la pestaña parametro extras para luego identificarla
            //en su metodo onclick
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()

                    .putInt(SLIDER_ID, i);


            //Finalmente agregamos la pestaña al "slider"
            mDemoSlider.addSlider(textSliderView);
        }
        //Definimos el efecto que tendra el slider al cambiar de pagina
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
        //Definimos en que posicion queremos que aparezcan los indicadores de
        //posicion de la pestaña actual (los puntitos de posicion .*.)
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Top);
        //Definimos la animacion que tendra el campo de descripcion
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        //Definimos la duracion de cambio de pestaña en ms
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Se cambio a la pestaña: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        switch (slider.getBundle().getInt(SLIDER_ID)) {
            case 0:
                viewPager.setCurrentItem(2);
                break;
            default:
                viewPager.setCurrentItem(1);
                break;
        }

    }


    @Override
    public void onStop() {
        super.onStop();
        pararEmpezarCarrousel();
    }

    @Override
    public void onResume() {
        super.onResume();
        pararEmpezarCarrousel();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        pararEmpezarCarrousel();

    }

    //Fix al pasar de un fragment al otro seguian cambiando las pestañas de este fragment
    // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
    private void pararEmpezarCarrousel() {
        if (mDemoSlider != null && getUserVisibleHint()) {
            mDemoSlider.startAutoCycle();
        } else if (mDemoSlider != null) {
            mDemoSlider.stopAutoCycle();
        }
    }

}
