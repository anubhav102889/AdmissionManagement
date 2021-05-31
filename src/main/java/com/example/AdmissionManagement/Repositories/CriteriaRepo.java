package com.example.AdmissionManagement.Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.AdmissionManagement.Entites.Department;
import com.example.AdmissionManagement.Entites.Student;
import com.example.AdmissionManagement.Pojos.DepartStuCountInfo;

@Repository
public class CriteriaRepo {
	
	@Autowired
	private EntityManager entityManager;

	
	public List<DepartStuCountInfo> studCountInfo(Integer deptId) {
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<DepartStuCountInfo> cq=cb.createQuery(DepartStuCountInfo.class);
		Root<Department> deptRoot=cq.from(Department.class);
		Join<Department, Student> empDeptJoin= deptRoot.join("stuList",JoinType.INNER);
		cq.select(cb.construct(DepartStuCountInfo.class, deptRoot
				.get("id"),deptRoot.get("name"),
				cb.count(empDeptJoin.get("studentId"))
				,cb.selectCase().when(cb.gt(cb.count(empDeptJoin.get("studentId")),4), "top")
				.when(cb.and(cb.le(cb.count(empDeptJoin.get("studentId")),4),
						cb.gt(cb.count(empDeptJoin.get("studentId")), 2)), "medium")
				.otherwise("bottom")));
		List<Predicate> predicates=new ArrayList<>();
		if(Objects.nonNull(deptId) && deptId >0) {
			Predicate departmentId=cb.equal(deptRoot.get("id"),deptId);
			predicates.add(departmentId);
		}
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		cq.groupBy(deptRoot
				.get("id"),deptRoot.get("name"));
		
		TypedQuery<DepartStuCountInfo> query=entityManager.createQuery(cq);
		List<DepartStuCountInfo> list=query.getResultList();
		return list;
	}
	

}
