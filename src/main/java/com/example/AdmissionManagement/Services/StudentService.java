package com.example.AdmissionManagement.Services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.AdmissionManagement.Entites.Student;
import com.example.AdmissionManagement.Pojos.SeatAvailablePojo;
import com.example.AdmissionManagement.Repositories.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	public SeatAvailablePojo admissionSeatsAvailable(Integer deptId,
			Integer typeId){
		return Optional.ofNullable(deptId)
				.filter(id->id>0 && Objects.nonNull(typeId) && typeId>0)
				.map(id->{
					return studentRepo.admissionSeatsAvailable(id, typeId);
				})
				.orElse(null);
	}
	
	public Student student(Student student) {
		return Optional.ofNullable(student)
				/*.filter(stu->{
					return Objects.nonNull(stu.getDepartment().getId())
							&& stu.getDepartment().getId()>0
							&& Objects.nonNull(stu.getAdmissionType().getTypeId())
							&& stu.getAdmissionType().getTypeId()>0
							&& StringUtils.hasLength(stu.getStudentName());
				})*/
				.map(stu->{
					Student studentSaved=null;
					SeatAvailablePojo availableInfo=
							admissionSeatsAvailable(stu.getDepartment().getId(),
									stu.getAdmissionType().getTypeId());
					if(Objects.isNull(availableInfo) || availableInfo.getSeatsAvailable()>0)
					{
						studentSaved=studentRepo.save(stu);
					}
					return studentSaved;
				})
				.orElse(null);
	}

}
