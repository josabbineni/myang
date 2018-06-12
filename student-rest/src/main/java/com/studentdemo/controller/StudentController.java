package com.studentdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentdemo.model.Student;
import com.studentdemo.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/api/student" })
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public Student create(@RequestBody Student student) {
//		System.out.println("create student id" +student.getId() + "name" + student.getName());
		return studentService.create(student);
	}

	@GetMapping(path = { "/{id}" })
	public Student findOne(@PathVariable("id") Long id) {
		Optional<Student> student = studentService.findById(id);

		return student.get();
	}

	@PutMapping
	public Student update(@RequestBody Student student) {
		System.out.println("update student id" +student.getId() + "name" + student.getName());
		return studentService.update(student);
	}

	@DeleteMapping(path = { "/{id}" })
	public Student delete(@PathVariable("id") Long id) {
		return studentService.delete(id);
	}

	@GetMapping
	public List findAll() {
		return studentService.findAll();
	}
}
