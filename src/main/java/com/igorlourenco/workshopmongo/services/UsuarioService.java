package com.igorlourenco.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorlourenco.workshopmongo.domain.Usuario;
import com.igorlourenco.workshopmongo.dto.UsuarioDTO;
import com.igorlourenco.workshopmongo.repository.UsuarioRepository;
import com.igorlourenco.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> buscarTodos(){
		return repo.findAll();
	}
	
	public Usuario buscarPorId(String id) {
		Usuario usuario = (Usuario) repo.findAll();
		if(usuario == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return usuario;
	}
	
	public Usuario inserir(Usuario obj) {
		return repo.insert(obj);
	}
	
	
	public void deletar(String id) {
		buscarPorId(id);
		repo.deleteById(id);
	}
	
	public Usuario atualizar(Usuario obj) {
		Usuario newObj = repo.findOne(obj.getId());
		atualizarDados(newObj, obj);
		return repo.save(newObj);
	}
	
	private void atualizarDados(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}
