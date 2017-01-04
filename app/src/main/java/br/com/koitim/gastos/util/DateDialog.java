package br.com.koitim.gastos.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by koitim on 21/12/16.
 */

public class DateDialog extends DialogFragment {

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    final Calendar c = Calendar.getInstance();
    int ano = c.get(Calendar.YEAR);
    int mes = c.get(Calendar.MONTH);
    int dia = c.get(Calendar.DAY_OF_MONTH);
    Bundle bundle = getArguments();
    DatePickerDialog.OnDateSetListener mListener = (DatePickerDialog.OnDateSetListener) bundle.getSerializable("listener");
    return new DatePickerDialog(getActivity(), mListener, ano, mes, dia);
  }
}
