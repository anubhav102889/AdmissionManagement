package com.example.AdmissionManagement.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdmissionManagement.Pojos.DepartStuCountInfo;
import com.example.AdmissionManagement.Repositories.CriteriaRepo;

@RestController
public class CriterialQueryController {
	
	@Autowired
	private CriteriaRepo repo;
	
	@Value("${mycustom.prop}")
	private String propertySourceCheck;
	
	@Value("${app.name}")
	private String exceptionResolverProjPropCheck;
	
	@GetMapping(value = {"/criteriaex","/criteriaex/{deptId}"})
	public ResponseEntity<List<DepartStuCountInfo>> studCountInfo(
			@PathVariable(value = "deptId",required = false)Integer deptId){
		System.out.println(propertySourceCheck);
		System.out.println(exceptionResolverProjPropCheck);
		List<DepartStuCountInfo> resultList=repo.studCountInfo(deptId);
		return Optional.ofNullable(resultList)
				.filter(list->!CollectionUtils.isEmpty(list))
				.map(list->{
					return new ResponseEntity<>(list,HttpStatus.OK);
				})
				.orElseGet(()->{
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				});
	}
	
	

}
