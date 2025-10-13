package com.mycoolapp.cruddemo;

import java.util.List;

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
			// CreateAndReadStudent(studentdao);

			// queryForStudents(studentdao);

			// queryStudentsByLastName(studentdao, "ismail");

			// updateStudent(studentdao);

			// deleteStudent(studentdao);

			deleteAllStudents(studentdao);

		};
	}

	private void deleteAllStudents(StudentDAO studentdao) {
		// delete all
		System.out.println("Deleting all Students :");
		int numsofrows = studentdao.deleteAll();

		System.out.println("Deleted Rows Count : " + numsofrows);
	}

	private void deleteStudent(StudentDAO studentdao) {
		// getting id of student
		int studentid = 1;
		System.out.println("Deleting student id : " + studentid);

		studentdao.delete(studentid);
	}

	private void updateStudent(StudentDAO studentdao) {
		// Retrieve student by specific id
		int studentId = 3;
		System.out.println("Getting Student with ID : " + studentId);
		Student mystudent = studentdao.findById(studentId);

		// change firstName to "John"
		System.out.println("updating the student !");
		mystudent.setFirstName("John");

		// update the student
		studentdao.Update(mystudent);

		// Display the student
		System.out.println("Updated Student " + mystudent);
	}

	private void queryStudentsByLastName(StudentDAO studentdao, String string) {
		List<Student> thestudents = studentdao.findByLastName(string);

		// Display quries
		for (Student tempstudent : thestudents) {
			System.out.println(tempstudent);
		}
	}

	private void queryForStudents(StudentDAO studentdao) {

		// Generate quries
		List<Student> thestudents = studentdao.findAll();

		// Display quries
		for (Student tempstudent : thestudents) {
			System.out.println(tempstudent);
		}
	}

	private void CreateAndReadStudent(StudentDAO studentdao) {

		// create the student object ( Module - Entity - Table Structure )
		System.out.println("Creating Student Object");
		Student student = new Student("mohamed", "ismail", "hola99@gmail.com");

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
