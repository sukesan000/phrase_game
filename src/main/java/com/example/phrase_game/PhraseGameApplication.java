package com.example.phrase_game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.phrase_game.model")
public class PhraseGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhraseGameApplication.class, args);
	}

}
