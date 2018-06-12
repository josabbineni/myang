package com.studentdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.studentdemo.model.Student;
import com.studentdemo.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	Student mockStudent = new Student(1000L, "TstStudent", "tst@yahoo.com");

	@Test
	public void findOneStudent() throws Exception {

		Mockito.when(studentService.findById(Mockito.anyLong())).thenReturn(Optional.of(mockStudent));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/student/1000")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"id\":1000,\"name\":\"TstStudent\",\"email\":\"tst@yahoo.com\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void findAll() throws Exception {
			
			List mockList = new ArrayList<Student>();
			mockList.add(mockStudent);

		Mockito.when(studentService.findAll()).thenReturn(mockList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/student")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{\"id\":1000,\"name\":\"TstStudent\",\"email\":\"tst@yahoo.com\"}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
