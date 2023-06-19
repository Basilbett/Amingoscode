package Basil.example.student.student100;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class StudentConfig {
	
	private String name;
	private int age;
	private String email;

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
	return args->	{
				Student Basil= new Student(
						 
						 name="Basil",
						 LocalDate.of(2000,12,10),
						 age=21,
						 email="Basil@kabarak.ac.ke"
					
			     );
				
				Student Alex= new Student(
						 
						 name="Basil",
						 LocalDate.of(2000,12,10),
						 age=21,
						 email="Basil@kabarak.ac.ke"
					
			     );
				
				repository.saveAll(
						List.of(Basil,Alex)
						);
				
	 
	};

	}

}
