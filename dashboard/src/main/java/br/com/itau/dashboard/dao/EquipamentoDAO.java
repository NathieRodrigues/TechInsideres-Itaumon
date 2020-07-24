package br.com.itau.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.dashboard.model.Equipamento;

public interface EquipamentoDAO extends CrudRepository<Equipamento,Integer>{

}
