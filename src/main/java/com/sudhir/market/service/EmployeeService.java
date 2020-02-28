package com.sudhir.market.service;

import java.util.List;
import java.util.Optional;

import com.sudhir.market.exception.RecordNotFoundException;
import com.sudhir.market.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public List<Employee> retrieveEmployees();
	public Employee getEmployeeById(int employeeId);
	public void deleteEmployeeById(int employeeId) throws RecordNotFoundException;
	public Employee updateEmployee(Employee employee) throws RecordNotFoundException;
}
