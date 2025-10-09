package com.mycoolapp.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycoolapp.cruddemo.entity.Student;
import com.mycoolapp.cruddemo.entity.dao.StudentDAO;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentdao) {
		return runner -> {
			CreateAndReadStudent(studentdao);
		};
	}

	private void CreateAndReadStudent(StudentDAO studentdao) {

		// create the student object
		System.out.println("Creating Student Object");
		Student student = new Student("mohamed", "atia", "hola@gmail.com");

		// save the student object
		System.out.println("Saving Student Object");
		studentdao.save(student);

		// display id of the saved students
		System.out.println("Saved Student , Generated , Id : " + student.getId());

		// New work with reading Id Function
		long id = student.getId();
		Student studentid = studentdao.findById(id);

		System.out.println("Retrieving Student with id :" + studentid);
	}

}
