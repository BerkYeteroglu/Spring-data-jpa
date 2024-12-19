package com.eyeteroglu.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyeteroglu.dto.DtoStudent;
import com.eyeteroglu.dto.DtoStudentIU;
import com.eyeteroglu.entites.Student;
import com.eyeteroglu.repository.StudentRepository;
import com.eyeteroglu.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent responseDtoStudent = new DtoStudent();
		Student newStudent = new Student();
		BeanUtils.copyProperties(dtoStudentIU, newStudent);
		
		Student dbStudent = studentRepository.save(newStudent);
		BeanUtils.copyProperties(dbStudent, responseDtoStudent);
		return responseDtoStudent;
	}

	@Override
	public List<DtoStudent> listAll() {
		List<DtoStudent> dtoStudents = new ArrayList<>();
		List<Student> studentList = studentRepository.findAll();
		for (Student student : studentList) {
			DtoStudent dto = new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtoStudents.add(dto);
		}
		return dtoStudents;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dto = new DtoStudent(); 
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			Student dbStudent = optional.get();
			
			BeanUtils.copyProperties(dbStudent, dto);
			return dto;
		}
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			Student dbStudent = optional.get();
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthofDate(dtoStudentIU.getBirthofDate());
			
			Student updatedStudent = studentRepository.save(dbStudent);
			
			BeanUtils.copyProperties(updatedStudent, dtoStudent);
			return dtoStudent;
		}
		return null;
	}

}
