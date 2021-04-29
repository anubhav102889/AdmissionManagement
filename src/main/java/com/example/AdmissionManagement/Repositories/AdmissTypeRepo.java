package com.example.AdmissionManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AdmissionManagement.Entites.AdmissionType;

@Repository
public interface AdmissTypeRepo extends JpaRepository<AdmissionType,Integer>{

}
