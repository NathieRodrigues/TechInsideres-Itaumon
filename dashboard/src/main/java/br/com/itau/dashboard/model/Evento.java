package br.com.itau.dashboard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn_evento")
public class Evento {

	@Column(name="num_seq")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="data_evt")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
	private Date data;
	
	
	@JsonIgnoreProperties("eventoEquipamento")
	@ManyToOne
	private Equipamento equipamento;
	
	
	@JsonIgnoreProperties("eventoAlarme")
	@ManyToOne
	private Alarme alarme;


	public Evento() {
		super();
	}

	
	



	public Evento(int id, Date data, Equipamento equipamento, Alarme alarme) {
		super();
		this.id = id;
		this.data = data;
		this.equipamento = equipamento;
		this.alarme = alarme;
	}

	
	



	public Alarme getAlarme() {
		return alarme;
	}






	public void setAlarme(Alarme alarme) {
		this.alarme = alarme;
	}






	public Equipamento getEquipamento() {
		return equipamento;
	}


	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
