package br.com.koitim.gastos.model;

/**
 * Created by koitim on 21/12/16.
 */

public class Fonte implements IModel {

  public static final String TABELA = "fonte";
  public static final String ID = "id";
  public static final String NOME = "nome";

  private Long id;
  private String nome;

  public Fonte(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Fonte(String nome) {
    this(null, nome);
  }

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Fonte)) {
      return false;
    }
    Fonte fonte = (Fonte) obj;
    return fonte.getNome().equals(nome);
  }

  @Override
  public String toString() {
    return nome;
  }

  @Override
  public int hashCode() {
    return nome.hashCode();
  }

  @Override
  public String getTabela() {
    return TABELA;
  }
}
