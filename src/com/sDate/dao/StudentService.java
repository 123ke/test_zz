package com.sDate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sDate.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepsotory sRepsotory;
	
	
	@Transactional
	public void saveStudent(List<Student> student){
		sRepsotory.save(student);
	}
}
