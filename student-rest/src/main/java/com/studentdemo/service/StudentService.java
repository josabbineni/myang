package com.studentdemo.service;

import java.util.List;
import java.util.Optional;

import com.studentdemo.model.Student;

public interface StudentService {

	public List findAll();

	public Optional<Student> findById(Long id);

	public Student create(Student student);

	public Student update(Student student);

	public Student delete(Long id);

}
