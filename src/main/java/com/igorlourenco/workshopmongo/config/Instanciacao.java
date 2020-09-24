package com.igorlourenco.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.igorlourenco.workshopmongo.domain.Usuario;
import com.igorlourenco.workshopmongo.repository.UsuarioRepository;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {

		usuarioRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

		usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
