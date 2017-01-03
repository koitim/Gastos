package br.com.koitim.gastos.model;

/**
 * Created by koitim on 21/12/16.
 */

public class Favorecido implements IModel {

  public static final String TABELA = "favorecido";
  public static final String ID = "id";
  public static final String NOME = "nome";

  private Long id;
  private String nome;

  public Favorecido(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Favorecido(String nome) {
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
    if (!(obj instanceof Favorecido)) {
      return false;
    }
    Favorecido favorecido = (Favorecido) obj;
    return favorecido.getNome().equals(nome);
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
