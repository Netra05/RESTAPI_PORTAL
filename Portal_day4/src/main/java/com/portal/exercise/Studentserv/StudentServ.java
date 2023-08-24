package com.portal.exercise.Studentserv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.exercise.StudentRepo.Studentrepo;
import com.portal.exercise.Studentmodel.Student;

@Service
public class StudentServ {

  @Autowired
  public Studentrepo srepo;
  
  //post the data
  public String saveStudent(Student st)
  {
	  srepo.save(st);
	  return "Data is saved to the database";
  }
  
  //get the data
  
  public List<Student>getStudent()
  {
	  return srepo.findAll();
  }
  
  //getUserByID
  public Optional<Student>getUserId(int userId)
  {
	  Optional<Student>detail=srepo.findById(userId);
	  if(detail.isPresent())
	  {
		  return detail;
	  }
	  return null;
  }
  
  
  
  //update the data(put)
  public Student updateStudent(Student sm)
  {
	  return srepo.saveAndFlush(sm);
  }
  
  //update the data if id present
  public boolean updateStudentif(int hotelId,Student sm) {
	  if(srepo.existsById(hotelId)) {
		  srepo.save(sm);
		  return true;
	  }
	  return false;
  }
  
  //delete the data
  
  public void deleteStudent(int student_id)
  {
	  System.out.println("Deleted");
	  srepo.deleteById(student_id);
  }
  // delete if id is present
  public boolean deleteStudentif(int id) {
	  if(srepo.existsById(id)) {
		  srepo.deleteById(id);
		  return true;
	  }
	  return false;
  }
  
}
