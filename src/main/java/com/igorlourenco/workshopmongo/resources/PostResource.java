package com.igorlourenco.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igorlourenco.workshopmongo.domain.Post;
import com.igorlourenco.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService servico;

	/*Método para buscar todos da coleção do banco de dados pela Web*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	public ResponseEntity<Post> buscarPorId(@PathVariable String id){
		Post obj = servico.buscarPorId(id);			
		return ResponseEntity.ok().body(obj);
	}	
}
