package Basil.example.student.student100;

import java.time.LocalDate;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class StudentService {
	
	private final StudentRepository StudentRepository;
	
	@Autowired
	public StudentService(StudentRepository StudentRepository) {
		this.StudentRepository=StudentRepository;
	}
	
	public List<Student> getStudents(){
		return StudentRepository.findAll();
	 }

	public void addNewStudent(Student student) {
		// TODO Auto-generated method stub
		Optional <Student> studentOptional=StudentRepository.
				findStudentByEmail(student.getEmail());
		
		
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		
	 StudentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
	boolean exists=StudentRepository.existsById(studentId);
	
	if(!exists) {
		throw new IllegalStateException("Email id"+ studentId +"Does not exist");
	}
	
	StudentRepository.deleteById(studentId);
		
	}
@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student =StudentRepository.findById(studentId).orElseThrow(()
				->new IllegalStateException("Stusent with id"+ studentId +"does not exist"));
				
		if(email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)) 
				
				 {
					student.setName(name);
				}
		if(email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> StudentOptional=StudentRepository.findStudentByEmail(email);
			
			if(StudentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
	}

}
