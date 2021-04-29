package com.example.AdmissionManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AdmissionManagement.Entites.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer>{

}
