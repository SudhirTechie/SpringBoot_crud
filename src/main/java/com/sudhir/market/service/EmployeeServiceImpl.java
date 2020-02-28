package com.sudhir.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.market.core.IdGenerator;
import com.sudhir.market.exception.RecordNotFoundException;
import com.sudhir.market.model.Employee;
import com.sudhir.market.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		Optional<Employee> employees = Optional.ofNullable(employee);
		if (employees.isPresent()) {
			Employee employeeData = new Employee();
			employeeData.setEmployeeName(employee.getEmployeeName());
			//employeeData.setEmployeeId(IdGenerator.getId(employee.getEmployeeName(), employee.getPassword()));
			employeeData.setPassword(employee.getPassword());
			employeeData.setDesignation(employee.getDesignation());
			employeeData.setSalary(employee.getSalary());
			employeeData.setEmail(employee.getEmail());
			employeeData.setAddress(employee.getAddress());
			employeeData.setDate(employee.getDate());
			employee = employeeRepository.save(employeeData);

		} else {
			throw new RuntimeException("user not found");
		}
		// @formatter:on
		return employee;

	}

	@Override
	public List<Employee> retrieveEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		return optEmp.get();
		// return employeeRepository.findById(employeeId);
	}

	@Override
	public void deleteEmployeeById(int employeeId) throws RecordNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isPresent()) {
			employeeRepository.deleteById(employeeId);
		} else {
			throw new RecordNotFoundException("No record exist in DB");
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) throws RecordNotFoundException {
		Optional<Employee> employees = employeeRepository.findById(employee.getEmployeeId());
		if (employees.isPresent()) {
			Employee employeeData = employees.get();
			employeeData.setEmployeeName(employee.getEmployeeName());
			//employeeData.setEmployeeId(IdGenerator.getId(employee.getEmployeeName(), employee.getPassword()));
			employeeData.setPassword(employee.getPassword());
			employeeData.setDesignation(employee.getDesignation());
			employeeData.setSalary(employee.getSalary());
			employeeData.setEmail(employee.getEmail());
			employeeData.setAddress(employee.getAddress());
			employeeData.setDate(employee.getDate());
			employee = employeeRepository.save(employeeData);

		}
		return employee;
	}

	/*
	 * @Bean public PasswordEncoder passwordEncoder(){ PasswordEncoder encoder = new
	 * BCryptPasswordEncoder(); return encoder; }
	 */

}
