package com.sudhir.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.sudhir.market.exception.RecordNotFoundException;
import com.sudhir.market.model.Employee;
import com.sudhir.market.service.EmployeeServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@PostMapping("/employees")
		public Employee create(@RequestBody Employee employee) {
			return employeeServiceImpl.saveEmployee(employee);
		}
	

@GetMapping("/employees")
public ResponseEntity<List<Employee>> listEmployee(){
	
	List<Employee> empList=  employeeServiceImpl.retrieveEmployees();
	return new ResponseEntity<List<Employee>>(empList, new HttpHeaders(),HttpStatus.OK);
}

@GetMapping("/employees/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int employeeId) throws RecordNotFoundException{
	Employee employee = employeeServiceImpl.getEmployeeById(employeeId);
	return new ResponseEntity<Employee>(employee, new HttpHeaders(), HttpStatus.OK);
}

@DeleteMapping("/employees/{id}")
public HttpStatus deleteEmployeeById(@PathVariable("id") int id) 
                                                throws RecordNotFoundException {
	employeeServiceImpl.deleteEmployeeById(id);;
    return HttpStatus.FORBIDDEN;
}

@PutMapping("/employees/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee)throws RecordNotFoundException{
	Employee emp = employeeServiceImpl.updateEmployee(employee);
	return ResponseEntity.ok(emp);
}
}
	
