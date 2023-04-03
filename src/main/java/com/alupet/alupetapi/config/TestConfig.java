package com.alupet.alupetapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alupet.alupetapi.entities.Pet;
import com.alupet.alupetapi.entities.Tutor;
import com.alupet.alupetapi.enums.Porte;
import com.alupet.alupetapi.repository.PetRepository;
import com.alupet.alupetapi.repository.TutorRepository;

@Configuration
@Profile("test")
//Classe de configuração necessária para Popular o DB H2
public class TestConfig implements CommandLineRunner {

	@Autowired
	TutorRepository tutorRepository;
	
	@Autowired
	PetRepository petRepository;
	@Override
	public void run(String... args) throws Exception {
		//Instancia manual dos Objetos e Tbm seus relacionamentos para teste
		
		Tutor t1 = new Tutor("Julio cesar", "14151216", "Jabaquara");
		Tutor t2 = new Tutor("Romário", "14151216", "Jabaquara");
		Tutor t3 = new Tutor("Cleber", "14151216", "Jabaquara");
		
		Pet p1 = new Pet("Bebe", 5, "Dócil e amigavel",Porte.PEQUENO, t1);
		Pet p2 = new Pet("Gertrudes", 2, "Amigavel",Porte.MEDIO, t2);
		Pet p3 = new Pet("Romário", 5, "Raivoso",Porte.GRANDE, t1);
		Pet p4 = new Pet("BOB", 7, "Bobão",Porte.PEQUENO, t3);
		Pet p5 = new Pet("Jake", 12, "Dócil e amigavel",Porte.MEDIO, t3);

		t1.getPets().add(p1);
		t1.getPets().add(p3);
		t2.getPets().add(p2);
		t3.getPets().add(p4);
		t3.getPets().add(p5);
		
		tutorRepository.saveAll(Arrays.asList(t1,t2,t3));
		petRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

	}

}
