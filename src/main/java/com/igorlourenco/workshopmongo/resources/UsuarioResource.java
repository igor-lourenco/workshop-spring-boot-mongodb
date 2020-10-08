package com.igorlourenco.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igorlourenco.workshopmongo.domain.Usuario;
import com.igorlourenco.workshopmongo.dto.UsuarioDTO;
import com.igorlourenco.workshopmongo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService servico;
	
	/*Método para buscar todos da coleção do banco de dados pela Web*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> buscarTodos(){
		
		List<Usuario> lista = servico.buscarTodos();
		List<UsuarioDTO> listaDto = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
	
	/*Método para buscar todos da coleção do banco de dados pela Web*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable String id){
		Usuario obj = servico.buscarPorId(id);			
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST)	
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO objDto){
		Usuario obj = servico.fromDTO(objDto);	
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)	
	public ResponseEntity<UsuarioDTO> deletar(@PathVariable String id){
		servico.deletar(id);			
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<Void> atualizar(@RequestBody UsuarioDTO objDto, @PathVariable String id){
		Usuario obj = servico.fromDTO(objDto);	
		obj.setId(id);
		obj = servico.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
}
