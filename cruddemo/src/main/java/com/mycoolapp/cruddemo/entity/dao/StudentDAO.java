package com.mycoolapp.cruddemo.entity.dao;

import java.util.List;

import com.mycoolapp.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(long id);

    List<Student> findAll();

    List<Student> findByLastName(String thelastName);

    void Update(Student student);

    void delete(Integer id);

    int deleteAll();

}
