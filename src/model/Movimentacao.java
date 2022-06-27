package model;

import java.sql.Time;
import java.util.Date;

public class Movimentacao {
	private long id_movimentacao;
	private String placa;
	private String modelo;
	private Date data_entrada;
	private Date data_saida;
	private Time tempo;
	private Double valor_pago;
	
	public Movimentacao() {
		
	}
	
	public Movimentacao(long id_movimentacao, String placa, String modelo, Date data_entrada, Date data_saida,
			Time tempo, double valor_pago) {
		this.id_movimentacao = id_movimentacao;
		this.placa = placa;
		this.modelo = modelo;
		this.data_entrada = data_entrada;
		this.data_saida = data_saida;
		this.tempo = tempo;
		this.valor_pago = valor_pago;
	}

	public Movimentacao(String placa, String modelo, Date data_entrada, Date data_saida,
			Time tempo, double valor_pago) {
		this.placa = placa;
		this.modelo = modelo;
		this.data_entrada = data_entrada;
		this.data_saida = data_saida;
		this.tempo = tempo;
		this.valor_pago = valor_pago;
	}
	
	public Movimentacao(String placa, String modelo) {
		super();
		this.placa = placa;
		this.modelo = modelo;
	}

	public Movimentacao(String placa, String modelo, Date data_entrada) {
		this.placa = placa;
		this.modelo = modelo;
		this.data_entrada = data_entrada;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public Time getTempo() {
		return tempo;
	}

	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}

	public double getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(double valor_pago) {
		this.valor_pago = valor_pago;
	}

	public long getId_movimentacao() {
		return id_movimentacao;
	}

	public void setId_movimentacao(long id_movimentacao) {
		this.id_movimentacao = id_movimentacao;
	}
	
	public void mostraVeiculo(){
		System.out.println("Placa: "+ this.getPlaca());
		System.out.println("Modelo: "+ this.getModelo());
	}
	
}
