package com.eyeteroglu.services;

import java.util.List;

import com.eyeteroglu.dto.DtoStudent;
import com.eyeteroglu.dto.DtoStudentIU;

public interface IStudentService {
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public List<DtoStudent> listAll();
	public DtoStudent getStudentById(Integer id);
	public void deleteStudent(Integer id);
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
