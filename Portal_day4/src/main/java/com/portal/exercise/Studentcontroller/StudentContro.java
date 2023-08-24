package com.portal.exercise.Studentcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.Studentmodel.Student;
import com.portal.exercise.Studentserv.StudentServ;

@RestController
public class StudentContro {
   @Autowired
	public StudentServ sserv;
    
    //post mapping
    @PostMapping("/postdetail")
    public String postStudent(@RequestBody Student s)
    {
    	sserv.saveStudent(s);
    	return "data saved";
    }
    
    //get mapping
    @GetMapping("/getdetail")
    	public List<Student>getStudentInfo()
    	{
    	return sserv.getStudent();
    	}
    
    //getUserByID
    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId){
    	Optional<Student>detail=sserv.getUserId(userId);
    	
    	if(detail!=null)
    	{
    		return ResponseEntity.ok(detail); //Return the user's data if available
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not available with ID");
    }
    
    //put mapping
    @PutMapping("/updatedetail")
    public Student updateStudentInfo(@RequestBody Student sa)
    {
    	return sserv.updateStudent(sa);
    }
    @PutMapping("/updatedetailif/{id}")
    public ResponseEntity<String> updateStudentInfor(@PathVariable int id,@RequestBody Student sa){
    	   boolean updated=sserv.updateStudentif(id,sa);
 			   if(updated)
 			   {
 				  return ResponseEntity.ok("Student with ID "+id+" updated successfully"); //.ok means sucess
 			   }
 			   else
 			   {
 				  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID "+id+" not found and not updated");
 			   }
 	   }
    
   
    //Delete Mapping
    @DeleteMapping("/deletedetail/{id}")
    public String removeHotel(@PathVariable("id") int sid)
    {
    	sserv.deleteStudent(sid);
    	return "Student with Id "+sid+" is deleted";
    }
    
    //delete mapping using request param
    @DeleteMapping("/byReqParm")
    public String removeByRequestPam(@RequestParam("id") int id)
    {
    	sserv.deleteStudent(id);
    	return "Student with Id "+id+" is deleted";
    }
    
   @DeleteMapping("/deletedetailif/{id}")
   public ResponseEntity<String> deleteStudentInfo(@PathVariable int id){
	   boolean deleted=sserv.deleteStudentif(id);
	    if(deleted) {
	    	return ResponseEntity.ok("Student with ID "+id+"deleted successfully");
	    }
	    else 
	    {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID "+id+" not found");
	    }
	    
	
   }
}
