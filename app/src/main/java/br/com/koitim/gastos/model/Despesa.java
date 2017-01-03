package br.com.koitim.gastos.model;

import java.util.Date;

/**
 * Created by koitim on 21/12/16.
 */

public class Despesa implements IModel {

  public static final String TABELA = "despesa";
  public static final String ID = "id";
  public static final String DATA = "data";
  public static final String VALOR = "valor";
  public static final String FONTE = "id_fonte";
  public static final String CATEGORIA = "id_categoria";
  public static final String CREDOR = "id_credor";
  public static final String FAVORECIDO = "id_favorecido";

  private Long id;
  private Date data;
  private Double valor;
  private Fonte fonte;
  private Categoria categoria;
  private Credor credor;
  private Favorecido favorecido;

  public Despesa(Long id, Date data, Double valor, Fonte fonte, Categoria categoria, Credor credor, Favorecido favorecido) {
    this.id = id;
    this.data = data;
    this.valor = valor;
    this.fonte = fonte;
    this.categoria = categoria;
    this.credor = credor;
    this.favorecido = favorecido;
  }

  public Despesa(Long id, Date data, Double valor, Fonte fonte, Categoria categoria, Credor credor) {
    this(id, data, valor, fonte, categoria, credor, null);
  }

  public Despesa(Long id, Date data, Double valor, Fonte fonte, Categoria categoria, Favorecido favorecido) {
    this(id, data, valor, fonte, categoria, null, favorecido);
  }

  public Despesa(Long id, Date data, Double valor, Fonte fonte, Categoria categoria) {
    this(id, data, valor, fonte, categoria, null, null);
  }

  public Despesa(Date data, Double valor, Fonte fonte, Categoria categoria, Credor credor, Favorecido favorecido) {
    this(null, data, valor, fonte, categoria, credor, favorecido);
  }

  public Despesa(Date data, Double valor, Fonte fonte, Categoria categoria, Credor credor) {
    this(null, data, valor, fonte, categoria, credor);
  }

  public Despesa(Date data, Double valor, Fonte fonte, Categoria categoria, Favorecido favorecido) {
    this(null, data, valor, fonte, categoria, favorecido);
  }

  public Despesa(Date data, Double valor, Fonte fonte, Categoria categoria) {
    this(null, data, valor, fonte, categoria);
  }

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Fonte getFonte() {
    return fonte;
  }

  public void setFonte(Fonte fonte) {
    this.fonte = fonte;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Credor getCredor() {
    return credor;
  }

  public void setCredor(Credor credor) {
    this.credor = credor;
  }

  public Favorecido getFavorecido() {
    return favorecido;
  }

  public void setFavorecido(Favorecido favorecido) {
    this.favorecido = favorecido;
  }

  @Override
  public String getTabela() {
    return TABELA;
  }
}
