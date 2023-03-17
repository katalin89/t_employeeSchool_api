package ro.mycode.employeeapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.employeeapi.repository.RepoEmployee;

@SpringBootApplication
public class EmployeeApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeApiApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(RepoEmployee repoEmployee){
		return  args->{
//			Employee employee1=new Employee("Adi",45,"Libertatii nr 3");
//			Employee employee2=new Employee("Maria",27,"Pacii nr 1");
//
//			repoEmployee.save(employee1);
//			repoEmployee.save(employee2);

		};

	}

}

