package br.com.koitim.gastos.despesa;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import br.com.koitim.gastos.R;
import br.com.koitim.gastos.dao.CategoriaDAO;
import br.com.koitim.gastos.dao.CredorDAO;
import br.com.koitim.gastos.dao.FavorecidoDAO;
import br.com.koitim.gastos.dao.FonteDAO;
import br.com.koitim.gastos.interfaces.OnDespesaInteractionListener;
import br.com.koitim.gastos.model.Categoria;
import br.com.koitim.gastos.model.Credor;
import br.com.koitim.gastos.model.Favorecido;
import br.com.koitim.gastos.model.Fonte;

public class Principal extends AppCompatActivity implements OnDespesaInteractionListener  {

    private FonteDAO fonteDAO;
    private CategoriaDAO categoriaDAO;
    private CredorDAO credorDAO;
    private FavorecidoDAO favorecidoDAO;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.despesa_principal_layout);

    fonteDAO = new FonteDAO(this);
    categoriaDAO = new CategoriaDAO(this);
    credorDAO = new CredorDAO(this);
    favorecidoDAO = new FavorecidoDAO(this);

    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    Cadastro cadastro = new Cadastro();
    ft.add(R.id.despesa_principal_layout, cadastro);
    ft.commit();
  }

    @Override
    public List<Fonte> getFontes() {
      return fonteDAO.findAll();
    }

    @Override
    public List<Categoria> getCategorias() {
      return categoriaDAO.findAll();
    }

    @Override
    public List<Credor> getCredores() {
      return credorDAO.findAll();
    }

    @Override
    public List<Favorecido> getFavorecidos() {
      return favorecidoDAO.findAll();
    }
}
