package com.example.AdmissionManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AdmissionManagement.Entites.Student;
import com.example.AdmissionManagement.Pojos.SeatAvailablePojo;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{
	
	@Query(nativeQuery = true)
	public SeatAvailablePojo admissionSeatsAvailable(@Param(value = "deptId")Integer deptId,
			@Param(value = "typeId")Integer typeId);

}
