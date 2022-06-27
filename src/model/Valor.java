package model;

import java.util.Date;

public class Valor {
	private long id_valor;
	private double valor_primeira_hora=6;
	private double valor_demais_horas=4;
	private Date data_fim;
	
	public Valor() {}
	
	public Valor(long id_valor, Date data_fim) {
		this.id_valor = id_valor;
		this.data_fim = data_fim;
	}

	public double getValor_primeira_hora() {
		return valor_primeira_hora;
	}

	public void setValor_primeira_hora(double valor_primeira_hora) {
		this.valor_primeira_hora = valor_primeira_hora;
	}

	public double getValor_demais_horas() {
		return valor_demais_horas;
	}

	public void setValor_demais_horas(double valor_demais_horas) {
		this.valor_demais_horas = valor_demais_horas;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public long getId_valor() {
		return id_valor;
	}

	public void setId_valor(long id_valor) {
		this.id_valor = id_valor;
	}
	
	
}
