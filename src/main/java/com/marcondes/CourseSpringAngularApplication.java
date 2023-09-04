package com.marcondes;

import com.marcondes.domains.Chamado;
import com.marcondes.domains.Cliente;
import com.marcondes.domains.Tecnico;
import com.marcondes.domains.enuns.Perfil;
import com.marcondes.domains.enuns.Prioridade;
import com.marcondes.domains.enuns.Status;
import com.marcondes.repositories.ChamadoRepository;
import com.marcondes.repositories.ClienteRepository;
import com.marcondes.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class CourseSpringAngularApplication{


	public static void main(String[] args) {
		SpringApplication.run(CourseSpringAngularApplication.class, args);
	}

}
