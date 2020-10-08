package com.igorlourenco.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorlourenco.workshopmongo.domain.Post;
import com.igorlourenco.workshopmongo.domain.Usuario;
import com.igorlourenco.workshopmongo.repository.PostRepository;
import com.igorlourenco.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	

	
	public Post buscarPorId(String id) {
		Post usuario = repo.find();
		if(usuario == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return usuario;
	}

}
