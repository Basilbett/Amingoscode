package Basil.example.student.student100;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {
	
	private final StudentService StudentService;
	@Autowired
	public StudentController(StudentService StudentService) {
		this.StudentService=StudentService;
	}
	
	
	
	@GetMapping("")
	 public List<Student> getStudents(){
		return StudentService.getStudents();
		 
	 }
	@PostMapping
	public void addNewStudent(@RequestBody Student student) {
		StudentService.addNewStudent(student);
	}

	@DeleteMapping(path= "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		StudentService.deleteStudent(studentId);
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudent(
			@PathVariable("student") Long studentId,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String email )
	{
		StudentService.updateStudent(studentId,name,email);
	}
     
}
