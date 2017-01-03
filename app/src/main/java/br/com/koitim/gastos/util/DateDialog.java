package br.com.koitim.gastos.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by koitim on 21/12/16.
 */

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {


  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    final Calendar c = Calendar.getInstance();
    int ano = c.get(Calendar.YEAR);
    int mes = c.get(Calendar.MONTH);
    int dia = c.get(Calendar.DAY_OF_MONTH);
    return new DatePickerDialog(getActivity(), this, ano, mes, dia);
  }

  @Override
  public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

  }
}
