package com.igorlourenco.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igorlourenco.workshopmongo.domain.Post;
import com.igorlourenco.workshopmongo.resources.util.URL;
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
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)	
	public ResponseEntity<List<Post>> buscarPorTitulo(@RequestParam(value = "text", defaultValue = "") String texto){
		texto = URL.decodeParam(texto);
		List<Post> lista = servico.buscarPorTitulo(texto);
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value = "/buscacompleta", method = RequestMethod.GET)	
	public ResponseEntity<List<Post>> buscaCompleta(
			@RequestParam(value = "texto", defaultValue = "") String texto,
			@RequestParam(value = "minData", defaultValue = "") String minData,
			@RequestParam(value = "maxData", defaultValue = "") String maxData){
		texto = URL.decodeParam(texto);
		Date min = URL.converterData(minData, new Date(0l));
		Date max = URL.converterData(maxData, new Date());
		List<Post> lista = servico.buscaCompleta(texto, min, max);
		return ResponseEntity.ok().body(lista);
	}
}
