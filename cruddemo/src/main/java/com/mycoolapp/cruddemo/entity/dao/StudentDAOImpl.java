package com.mycoolapp.cruddemo.entity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycoolapp.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

// Specialized annotation for repository classes 
// Supports Components Scanning
// Translate JDBC Exceptions 
@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field Entity Manager
    private EntityManager entityManager;

    // define constructor
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

}
