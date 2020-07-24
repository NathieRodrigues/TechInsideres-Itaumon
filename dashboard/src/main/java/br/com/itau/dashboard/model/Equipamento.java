package br.com.itau.dashboard.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="itmn_equipamento")
public class Equipamento {
	
	@Column(name="id_equip")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="hostname", length=50, nullable=false)
	private String hostname;
	
	@Column(name="ipaddr", length=15, nullable=false)
	private String ipaddr;

	
	@JsonIgnoreProperties("equipamento")
	@OneToMany(mappedBy="equipamento", cascade = CascadeType.ALL)
	private List<Evento> eventoEquipamento;
	


	public int getId() {
		return id;
	}




	public List<Evento> getEventoEquipamento() {
		return eventoEquipamento;
	}




	public void setEventoEquipamento(List<Evento> eventoEquipamento) {
		this.eventoEquipamento = eventoEquipamento;
	}




	public Equipamento(int id, String hostname, String ipaddr, List<Evento> eventoEquipamento) {
		super();
		this.id = id;
		this.hostname = hostname;
		this.ipaddr = ipaddr;
		this.eventoEquipamento = eventoEquipamento;
	}




	public Equipamento() {
		super();
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	
	
}
