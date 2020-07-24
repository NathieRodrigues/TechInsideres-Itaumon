package br.com.itau.dashboard.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.itau.dashboard.model.Evento;

public interface EventoDAO extends CrudRepository<Evento,Integer>{
	
	//@Query(value="SELECT itmn_evento.data_evt, itmn_alarme.nome,itmn_equipamento.hostname from itmn_evento,itmn_alarme,itmn_equipamento where itmn_evento.alarme_id_alarme=itmn_alarme.id_alarme and itmn_evento.equipamento_id_equip=itmn_equipamento.id_equip and itmn_evento.data_evt >= :inicio and itmn_evento.data_evt <= :fim",nativeQuery=true)
	@Query(value="SELECT * from itmn_evento where itmn_evento.data_evt >= :inicio and itmn_evento.data_evt <= :fim",nativeQuery=true)
	ArrayList<Evento> getByData(@Param("inicio") Date inicio, @Param("fim") Date fim);

	@Query(value="SELECT COUNT(alarme_id_alarme) AS TOTAL FROM itmn_evento WHERE alarme_id_alarme LIKE :alarmeid and itmn_evento.data_evt >= :inicio and itmn_evento.data_evt <= :fim",nativeQuery=true)
	int findByAlarmeAndData(@Param("alarmeid") int alarmeid,@Param("inicio") Date inicio, @Param("fim") Date fim);
	
}
