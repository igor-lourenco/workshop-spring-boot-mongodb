package com.igorlourenco.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorlourenco.workshopmongo.domain.Post;
import com.igorlourenco.workshopmongo.repository.PostRepository;
import com.igorlourenco.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	

	
	public Post buscarPorId(String id) {
		Post usuario = repo.findOne();
		if(usuario == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return usuario;
	}
	
	public List<Post> buscarPorTitulo(String texto){
		return repo.procurarTitulo(texto);
	}
	
	public List<Post> buscaCompleta(String texto, Date minData, Date maxData){
		maxData = new Date(maxData.getTime() + 24 * 60 * 60 * 1000);
		return repo.buscaCompleta(texto, minData, maxData);
	}
 
}
