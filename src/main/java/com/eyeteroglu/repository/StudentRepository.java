package com.eyeteroglu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eyeteroglu.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	//Buraya JpaRepository'de olmayan, veritabanına özel sorgular yazmamız gerektiğinde yazacağız 
	
	
	//Bu sorgu JPA'nın içerisinde findAll() olarak var fakat biz örnek olsun diye tekrar yazıyoruz.
	//	HQL : sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır. Default'tur.
	//	SQL : veritabanında ki tablo isim ve içerisindeki isimlere kullanılarak sorgular yazılır. naviteQuery = true yapılarak kullanılır.
	
	@Query(value = "SELECT * FROM student.student", nativeQuery = true)
	List<Student> findAllStudents();
	
	@Query(value = "from Student s WHERE s.id= :studentId")
	Optional<Student> findStudentById(Integer studentId);
}
