package backend.project;

import backend.project.entities.*;
import backend.project.repositories.*;
import backend.project.services.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Id;
import javax.print.attribute.DateTimeSyntax;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(

			AuthorityRepository authorityRepository,
			UserRepository userRepository,
			AlumnoRepository alumnoRepository,
			AsesorRepository asesorRepository,
			CursoRepository cursoRepository,
			CanalContactoRepository canalContactoRepository,
			HorarioRepository horarioRepository,
			AsesoriaRepository asesoriaRepository,
			OpinionRepository opinionRepository,
			AlumnoCursoService alumnoCursoService,
			AsesorCursoService asesorCursoService
	) {
		return args -> {
            //CRUD

			authorityRepository.save(new Authority(AuthorityName.ROLE_ADMIN));
			authorityRepository.save(new Authority(AuthorityName.ROLE_STUDENT));
			authorityRepository.save(new Authority(AuthorityName.ROLE_PRINCIPAL));
			authorityRepository.save(new Authority(AuthorityName.ROLE_TEACHER));

			authorityRepository.saveAll(
					List.of(
							new Authority(AuthorityName.READ),
							new Authority(AuthorityName.WRITE)
					)
			);


			userRepository.save(
					new User("gmorip", new BCryptPasswordEncoder().encode("UPC2023!"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PRINCIPAL),
									authorityRepository.findByName(AuthorityName.ROLE_ADMIN),
									authorityRepository.findByName(AuthorityName.WRITE)
								)
							)
			);

			userRepository.save(
					new User("crevilla", new BCryptPasswordEncoder().encode("DISEÑOPERU18!"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_STUDENT),
									authorityRepository.findByName(AuthorityName.READ),
									authorityRepository.findByName(AuthorityName.WRITE)

							)
					)
			);

			userRepository.save(
					new User("uriel123", new BCryptPasswordEncoder().encode("lerma123"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_STUDENT),
									authorityRepository.findByName(AuthorityName.ROLE_TEACHER),
									authorityRepository.findByName(AuthorityName.READ),
									authorityRepository.findByName(AuthorityName.WRITE)
							)
					)
			);

			userRepository.save(
					new User("rycon", new BCryptPasswordEncoder().encode("armando200"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_STUDENT),
									authorityRepository.findByName(AuthorityName.ROLE_TEACHER),
									authorityRepository.findByName(AuthorityName.READ),
									authorityRepository.findByName(AuthorityName.WRITE)
							)
					)
			);



			alumnoRepository.save( new Alumno(Long.valueOf(0),5,"Ricardo","Pando", userRepository.findByUserName("rycon"),null,null));
			alumnoRepository.save( new Alumno(Long.valueOf(0),8,"Uriel","Parra", userRepository.findByUserName("uriel123"),null,null));
			alumnoRepository.save( new Alumno(Long.valueOf(0),3,"Jhon","Salchi", userRepository.findByUserName("crevilla"),null,null));

			asesorRepository.save(new Asesor(Long.valueOf(0),"Ricardo","Pando",40,"Mucha",userRepository.findByUserName("rycon"),null,null,null,null));
			asesorRepository.save(new Asesor(Long.valueOf(0),"Uriel","Parra",13,"Poca",userRepository.findByUserName("uriel123"),null,null,null,null));
			asesorRepository.save(new Asesor(Long.valueOf(0),"Jhon","Salchi",20,"Algo",userRepository.findByUserName("crevilla"),null,null,null,null));

			cursoRepository.save(new Curso(Long.valueOf(0),"matematica",5,null,null,null));
			cursoRepository.save(new Curso(Long.valueOf(0),"lengua",3,null,null,null));
			cursoRepository.save(new Curso(Long.valueOf(0),"fisica",1,null,null,null));
			cursoRepository.save(new Curso(Long.valueOf(0),"progra",2,null,null,null));

			canalContactoRepository.save(new CanalContacto(Long.valueOf(0),"999784561","prefomasna@upc.edu.pe","https://pe.linkedin.com/in/urielito","www.kick.com",asesorRepository.findByNombreContaining("Uriel").get(0)));
			canalContactoRepository.save(new CanalContacto(Long.valueOf(0),"915961599","masnaprof@upc.edu.pe","https://pe.linkedin.com/in/fqwfqwfqqq","www.patada.com",asesorRepository.findByNombreContaining("Jhon").get(0)));
			canalContactoRepository.save(new CanalContacto(Long.valueOf(0),"989595489","mostro@upc.edu.pe","https://pe.linkedin.com/in/paginaxd","www.patadacoladora.com",asesorRepository.findByNombreContaining("Ricardo").get(0)));

			List<LocalTime> horasInicio = Arrays.asList(LocalTime.parse("09:00:00"));
			List<LocalTime> horasFin = Arrays.asList(LocalTime.parse("10:00:00"));
			//horarioRepository.save(new Horario(Long.valueOf(0),"Lunes",horasInicio,horasFin,asesorRepository.findByNombreContaining("Ricardo").get(0)));
			//horarioRepository.save(new Horario(Long.valueOf(0),"Martes",horasInicio,horasFin,asesorRepository.findByNombreContaining("Uriel").get(0)));
			//horarioRepository.save(new Horario(Long.valueOf(0),"Miercoles",horasInicio,horasFin,asesorRepository.findByNombreContaining("Jhon").get(0)));
			//horarioRepository.save(new Horario(Long.valueOf(0),"Jueves",horasInicio,horasFin,asesorRepository.findByNombreContaining("Uriel").get(0)));

			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			//asesoriaRepository.save(new Asesoria(Long.valueOf(0),dateFormat.parse("2024-10-24"),12.50,dateFormat.parse("2024-10-26"),3,3,AsesoriaEstado.REALIZADA,horasInicio,horasFin,1,12.50,alumnoRepository.findByNombreContaining("Uriel").get(0),asesorRepository.findByNombreContaining("Ricardo").get(0),cursoRepository.findByNombreContaining("matematica").get(0)));
			//asesoriaRepository.save(new Asesoria(Long.valueOf(0),dateFormat.parse("2024-10-23"),12.50,dateFormat.parse("2024-10-25"),4,2,AsesoriaEstado.CANCELADA,horasInicio,horasFin,1,12.50,alumnoRepository.findByNombreContaining("Jhon").get(0),asesorRepository.findByNombreContaining("Uriel").get(0),cursoRepository.findByNombreContaining("lengua").get(0)));
			//asesoriaRepository.save(new Asesoria(Long.valueOf(0),dateFormat.parse("2024-10-22"),12.50,dateFormat.parse("2024-10-28"),5,3,AsesoriaEstado.RESERVADA,horasInicio,horasFin,1,12.50,alumnoRepository.findByNombreContaining("Uriel").get(0),asesorRepository.findByNombreContaining("Ricardo").get(0),cursoRepository.findByNombreContaining("progra").get(0)));

			opinionRepository.save(new Opinion(Long.valueOf(0),dateFormat.parse("2024-10-22"),"a bueno",userRepository.findByUserName("Ricardo")));
			opinionRepository.save(new Opinion(Long.valueOf(0),dateFormat.parse("2024-10-20"),"a malo",userRepository.findByUserName("Uriel")));
			opinionRepository.save(new Opinion(Long.valueOf(0),dateFormat.parse("2024-10-19"),"mas o menos",userRepository.findByUserName("Jhon")));



		};
	}

}
