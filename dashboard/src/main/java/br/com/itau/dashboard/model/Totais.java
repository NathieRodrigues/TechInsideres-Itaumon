package br.com.itau.dashboard.model;

public class Totais {
	private int alarmeid;
	private String nomeAlarme;
	private int soma;
	
	public Totais() {
		super();
	}

	public Totais(int alarmeid, String nomeAlarme, int soma) {
		super();
		this.alarmeid = alarmeid;
		this.nomeAlarme = nomeAlarme;
		this.soma = soma;
	}

	public int getAlarmeid() {
		return alarmeid;
	}

	public void setAlarmeid(int alarmeid) {
		this.alarmeid = alarmeid;
	}

	public String getNomeAlarme() {
		return nomeAlarme;
	}

	public void setNomeAlarme(String nomeAlarme) {
		this.nomeAlarme = nomeAlarme;
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}
	
	
}
