package com.eyeteroglu.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto işlemlerinde insert, update işlemleri için bu dto'yu kullanacağız
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	
	@NotEmpty(message = "FirstName alanı boş bırakılamaz")
	@Min(value = 3, message = "İsim alanı 3 karakterden az olamaz")
	@Max(value = 15, message = "İsim alanı 15 karakterden fazla olamaz")
	private String firstName;
	
	@Size(min = 3, max = 20, message = "Soyisim 3-20 karakter aralığında olmalı")
	private String lastName;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date birthofDate;
}
