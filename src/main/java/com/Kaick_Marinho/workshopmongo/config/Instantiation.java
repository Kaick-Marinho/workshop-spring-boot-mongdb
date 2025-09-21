package com.Kaick_Marinho.workshopmongo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Kaick_Marinho.workshopmongo.domain.Post;
import com.Kaick_Marinho.workshopmongo.domain.User;
import com.Kaick_Marinho.workshopmongo.dto.AuthorDTO;
import com.Kaick_Marinho.workshopmongo.repository.PostRepository;
import com.Kaick_Marinho.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, LocalDate.parse("21/03/2018", fmt), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDate.parse("23/03/2018", fmt), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
