package com.example.AdmissionManagement.ExceptionResolver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.AdmissionManagement.Pojos.ExceptionResponseClass;

@ControllerAdvice
@PropertySource(value = "classpath:exception.properties")
public class MyExceptionResolver extends ResponseEntityExceptionHandler{
	
	@Value("${exception.check}")
	private String check;
	
	@Override
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request){
		ExceptionResponseClass response=new ExceptionResponseClass();
		StringBuilder message =new StringBuilder("Http Method "+ex.getMethod()+" not supported. Supported Methods Are: ");
		
		ex.getSupportedHttpMethods().forEach(httpMethod->{
			message.append(httpMethod.name()+",");
		});
		
		System.out.println(check);
		response.setMessage(message.substring(0, message.length()-1));
		response.setStatusCode(status.value());
		return new ResponseEntity<Object>(response,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String,String> fieldErrorMap=new HashMap<>();
		
		ex.getFieldErrors().stream().forEach(fe->{
			fieldErrorMap.put(fe.getField(), fe.getDefaultMessage());
		});
		return new ResponseEntity<>(fieldErrorMap, HttpStatus.BAD_REQUEST);
	}

}
