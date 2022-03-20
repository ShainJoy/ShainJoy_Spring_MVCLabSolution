package com.cfrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cfrm.entity.Student;

@Service
public interface RegistrationServices {

	public void save(Student participant);
	
	public Student searchById(int studentId);
	
	public void deleteById(int studentId);

	public List<Student> findAll();
	
	public List<Student> searchBy(String name, String dept, String country);
	
}
