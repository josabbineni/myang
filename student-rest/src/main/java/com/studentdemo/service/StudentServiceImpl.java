package com.studentdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdemo.model.Student;
import com.studentdemo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Student create(Student student) {
		return repository.save(student);
	}

	@Override
	public Student delete(Long id) {
		Optional<Student> student = findById(id);
		if (student.isPresent()) {
			repository.delete(student.get());
		}
		return student.get();
	}

	@Override
	public List findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Student update(Student student) {
		return repository.save(student);
	}
}
