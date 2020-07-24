package br.com.itau.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.dashboard.model.Alarme;

public interface AlarmeDAO extends CrudRepository<Alarme,Integer>{

}
