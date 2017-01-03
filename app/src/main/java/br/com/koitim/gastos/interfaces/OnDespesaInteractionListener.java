package br.com.koitim.gastos.interfaces;

import java.util.List;

import br.com.koitim.gastos.model.Categoria;
import br.com.koitim.gastos.model.Credor;
import br.com.koitim.gastos.model.Favorecido;
import br.com.koitim.gastos.model.Fonte;

/**
 * Created by koitim on 25/12/16.
 */

public interface OnDespesaInteractionListener {

  List<Fonte> getFontes();
  List<Categoria> getCategorias();
  List<Credor> getCredores();
  List<Favorecido> getFavorecidos();
}
