package com.letsstartcoding.angularjsrestapidemo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.angularjsrestapidemo.model.Employee;
import com.letsstartcoding.angularjsrestapidemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee save(Employee employee) {
		
		if(employee.getId() != null && employeeRepository.existsById(employee.getId())) {
			throw new EntityExistsException("There is already Existing Data Set");
		}
		return employeeRepository.save(employee);
	}
	
	public Employee update(Employee employee) {
		
		if(employee.getId() != null && employeeRepository.existsById(employee.getId())) {
			throw new EntityExistsException("There is already Existing Data Set");
		}
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> findOne(Integer id) {
		return employeeRepository.findById(id);
	}
	
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}
}
