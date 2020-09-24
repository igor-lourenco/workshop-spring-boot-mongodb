package com.igorlourenco.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorlourenco.workshopmongo.domain.Usuario;
import com.igorlourenco.workshopmongo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> buscarTodos(){
		return repo.findAll();
	}
}
