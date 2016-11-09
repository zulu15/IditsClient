package com.zulu.idits.fragmentos;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerDialog extends DialogFragment implements android.app.DatePickerDialog.OnDateSetListener {

    private static final String TAG = DatePickerDialog.class.getSimpleName();
    private OnDataSetListener onDataSetListener;
    public interface OnDataSetListener{
        public void onDataSet(DatePicker view, int year, int monthOfYear, int dayOfMonth);
    }


    public void setOnDataSetListener(OnDataSetListener onDataSetListener) {
        this.onDataSetListener = onDataSetListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        // Create a new instance of DatePickerDialog and return it
        return new android.app.DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        onDataSetListener.onDataSet(view,year,monthOfYear,dayOfMonth);
    }
}
