package com.zulu.idits.adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zulu.idits.R;
import com.zulu.idits.modelo.Curso;
import java.util.ArrayList;

/**
 * Created by matias on 25/10/16.
 */
public class CursosAdaptador extends RecyclerView.Adapter<CursosAdaptador.CursoViewHolder> {
    private static final String TAG = CursosAdaptador.class.getSimpleName();
    private final Context context;
    private ArrayList<Curso> items;
    private final OnCursoSelectedListener mOnCursosSelectedListener;

    //Esta interface nos permite avisarle al fragmento desde aca(El adaptador)
    //de que un curso fue seleccionado
    public interface OnCursoSelectedListener {
        //Cuando se seleccione un curso se le envia al fragmento
        //el "paquete de vistas" (cursoViewHolder) que le corresponde al item
        //y el objeto curso seleccionado correspondiente al item
        void onCursoSelected(CursosAdaptador.CursoViewHolder cursoViewHolder,Curso curso);
    }


    public class CursoViewHolder extends RecyclerView.ViewHolder  {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView localidad;
        public TextView cargaHoraria;

        public CursoViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.nombreCurso);
            localidad = (TextView) v.findViewById(R.id.LocalidadDictado);
            cargaHoraria = (TextView) v.findViewById(R.id.CargaHoraria);

        }

        //Se encarga de setear el listener a cada fila y de rellenar los elementos
        //visuales con los datos correspondientes
        public void bind(final Curso cursoRow) {
            nombre.setText(cursoRow.retornaNombre());
            localidad.setText("Localidad: "+cursoRow.retornaLocalidad()+".");
            cargaHoraria.setText("Carga Horaria: " + cursoRow.retornaCargaHoraria() + " hs.");
            //Definimos el escuchador sobre la fila
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnCursosSelectedListener.onCursoSelected(CursoViewHolder.this,cursoRow);
                }
            });
        }


    }

    public CursosAdaptador(ArrayList<Curso> items, Context context, OnCursoSelectedListener onCursoSelectedListener) {
        this.items = items;
        this.context = context;
        this.mOnCursosSelectedListener = onCursoSelectedListener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CursoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fila_curso, viewGroup, false);

        return new CursoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CursoViewHolder viewHolder, int i) {
        viewHolder.bind(items.get(i));
    }
}