package br.com.itau.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.dashboard.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{

	Usuario findByEmailAndSenha(String email, String senha);
	Usuario findByRacfAndSenha(String racf, String senha);
}
