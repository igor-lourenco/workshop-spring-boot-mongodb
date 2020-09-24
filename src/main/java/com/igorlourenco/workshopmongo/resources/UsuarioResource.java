package com.igorlourenco.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igorlourenco.workshopmongo.domain.Usuario;
import com.igorlourenco.workshopmongo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService servico;
	
	/*Método para buscar todos da coleção do banco de dados pela Web*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> buscarTodos(){
		
		List<Usuario> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
}
