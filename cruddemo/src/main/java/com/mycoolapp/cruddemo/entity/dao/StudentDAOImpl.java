package com.mycoolapp.cruddemo.entity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycoolapp.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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

    @Override
    public List<Student> findAll() {
        // Quries
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by firstName desc", Student.class);

        // Return query Results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // quries
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:atia ", Student.class);

        // Set parameter
        // Because when Hibernate sends this query to the database, it needs actual
        // values, not placeholders.
        theQuery.setParameter("atia", theLastName);

        // Return
        return theQuery.getResultList();
    }

    @Override
    @Transactional // perform update into the table , not just queries
    public void Update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional // this is a must to run smoothly
    public void delete(Integer id) {
        // performing the delete
        // Retrieve student by id
        Student muyStudent = entityManager.find(Student.class, id);

        // delete
        entityManager.remove(muyStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        // delete all by getting quries on all table .
        int numofRowsDeleted = entityManager.createQuery("DELETE From Student").executeUpdate();

        return numofRowsDeleted;
    }

}
