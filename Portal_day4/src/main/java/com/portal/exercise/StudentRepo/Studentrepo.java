package com.portal.exercise.StudentRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.Studentmodel.Student;

public interface Studentrepo extends JpaRepository<Student,Integer> {

}
