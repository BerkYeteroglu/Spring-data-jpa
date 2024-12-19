package com.eyeteroglu.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyeteroglu.controller.IStudentController;
import com.eyeteroglu.dto.DtoStudent;
import com.eyeteroglu.dto.DtoStudentIU;
import com.eyeteroglu.services.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentControllerImpl implements IStudentController{
	
	@Autowired
	private IStudentService studentService;

	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
		return studentService.saveStudent(dtoStudentIU);
	}

	@GetMapping(path = "/listAll")
	@Override
	public List<DtoStudent> listAll() {
		return studentService.listAll();
	}

	@GetMapping(path = "get-student/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(required = true) Integer id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(required = true) Integer id) {
		studentService.deleteStudent(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoStudent updateStudent(@PathVariable(required = true) Integer id, @RequestBody DtoStudentIU updateStudent) {
		return studentService.updateStudent(id, updateStudent);
	}

}
