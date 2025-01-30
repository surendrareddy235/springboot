package com.projects.springbootproject6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  @Autowired
  public StudentRepo studentRepo;
  
  public void saveStudent(Student student) {
	  studentRepo.save(student);
  }
  public List<Student> getAllStudents() {
	  List<Student> students = studentRepo.findAll();
	  return students;  
  }
  public void deleteStudent(Long id) {
	  studentRepo.deleteById(id);
  }
  public Student editstudent(Long id) {
	  return studentRepo.findById(id).orElse(null);
}
}
