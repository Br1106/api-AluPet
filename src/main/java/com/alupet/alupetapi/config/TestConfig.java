package com.alupet.alupetapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alupet.alupetapi.entities.Abrigo;
import com.alupet.alupetapi.entities.Pet;
import com.alupet.alupetapi.entities.Tutor;
import com.alupet.alupetapi.repository.AbrigoRepository;
import com.alupet.alupetapi.repository.PetRepository;
import com.alupet.alupetapi.repository.TutorRepository;

@Configuration
@Profile("test")
//Classe de configuração necessária para Popular o DB H2
public class TestConfig implements CommandLineRunner {

	@Autowired
	TutorRepository tutorRepository;
	
	@Autowired
	AbrigoRepository abrigoRepository;
	
	@Autowired
	PetRepository petRepository;
	@Override
	public void run(String... args) throws Exception {
		//Instancia manual dos Objetos e Tbm seus relacionamentos para teste
		
		Tutor t1 = new Tutor(null,"Cleber Danilo", "clbdanilo@gmail.com","123456789",null,null,null);
		Tutor t2 = new Tutor(null,"Melina da Silva", "mlnDaSilva@gmail.com","123456789",null,null,null);
		Tutor t3 = new Tutor(null,"Ruanzito Oliveira", "ruandograu@gmail.com","123456789",null,null,null);

		Abrigo a1 = new Abrigo("Recanto Lírio dos Vales", "14151216", "Jabaquara");
		Abrigo a2 = new Abrigo("Cachorro feliz", "14151216", "Jabaquara");
		Abrigo a3 = new Abrigo("Lar doce Lar", "14151216", "Jabaquara");
		
		Pet p1 = new Pet("Bebe", 5, "Dócil e amigavel", a1);
		Pet p2 = new Pet("Gertrudes", 2, "Amigavel", a2);
		Pet p3 = new Pet("Romário", 5, "Raivoso", a1);
		Pet p4 = new Pet("BOB", 7, "Bobão", a3);
		Pet p5 = new Pet("Jake", 12, "Dócil e amigavel", a3);

		a1.getPets().add(p1);
		a1.getPets().add(p3);
		a2.getPets().add(p2);
		a3.getPets().add(p4);
		a3.getPets().add(p5);
		
		tutorRepository.saveAll(Arrays.asList(t1,t2,t3));
		abrigoRepository.saveAll(Arrays.asList(a1,a2,a3));
		petRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

	}

}
