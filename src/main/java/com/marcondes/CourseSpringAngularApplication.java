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
public class CourseSpringAngularApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;


	public static void main(String[] args) {
		SpringApplication.run(CourseSpringAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico tecnico1 = new Tecnico(null, "Kelvin Marcondes", "111.111.111-11", "kelvin@mail.com", "123");
		tecnico1.addPerfil(Perfil.TECNICO);

		Cliente cliente1 = new Cliente(null, "Paulo Reis", "222.222.222-22", "paulon@mail.com", "123");

		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tecnico1, cliente1);

		tecnicoRepository.saveAll(Arrays.asList(tecnico1));
		clienteRepository.saveAll(Arrays.asList(cliente1));
		chamadoRepository.saveAll(Arrays.asList(chamado1));

	}
}
