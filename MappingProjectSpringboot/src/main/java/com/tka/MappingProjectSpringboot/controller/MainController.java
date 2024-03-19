package com.tka.MappingProjectSpringboot.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.MappingProjectSpringboot.entity.Country;
import com.tka.MappingProjectSpringboot.entity.Employee;
import com.tka.MappingProjectSpringboot.service.MainService;


@RestController
@RequestMapping("/con")
public class MainController {
	
	@Autowired
	MainService service;
	
	//* API FOR ADD DATA INTO COUNTRY *//
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country c) {
		String msg = service.addCountry(c);
		return msg;
	}
	
	//* API FOR UPDATE COUNTRY *//
	@PutMapping("/updatecon")
	public String updateCountry(@RequestBody Country c) {
		String msg = service.updateCountry(c);
		return msg;
	}
	
	//* API FOR DELETE COUNTRY *//
	@DeleteMapping("/deletecon/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg = service.deleteCountry(id);
		return msg;
	}
	
	//* GET PARTICULAR RECORD *//
	@GetMapping("/getbyid/{id}")
	public Country getData(@PathVariable int id) {
		Country con = service.getData(id);
		return con;
	}
	
	//* GET ALL RECORD *//
	@GetMapping("/getall")
	public List<Country> getAll() {
		List<Country> list = service.getAll();
		return list;
	}
	
	//** CONTROLLER FOR EMPLOYEE **//
	//* ADD DATA INTO EMPLOYEE *//
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee e) {
		String msg= service.addEmployee(e);
		return msg;
	}

	//* UPDATE DATA OF EMPLOYEE *//
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee e) {
		String msg =  service.updateEmployee(e);
		return msg;
	}
	
	//* DELETE DATA FROM EMPLOYEE *//
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg = service.deleteEmployee(id);
		return msg;
	}
	
	//* GET RECORD BY ID OF EMP *//
	@GetMapping("/getEmpById/{id}")
	public Employee getEmp(@PathVariable int id) {
		Employee e = service.getEmp(id);
		return e;
	}
	
	//* GET ALL RECORD OF EMP *//
	@GetMapping("/allEmp")
	public List<Employee> getAllEmp() {
		List<Employee> list = service.getAllEmp();
		return list;
	}
	
	//* GET RECORD BY STATUS *//
	@GetMapping("/getbyStatus/{status}")
    public List<Employee> getByStatus(@PathVariable String status) {
        List<Employee> employees = service.getEmployeesByStatus(status);
        return employees;
    }
	
	//* LOGIN API  *//
	@PostMapping("loginapi")
	public HashMap checkUser(@RequestBody Employee e) {
		HashMap map  = service.loginApi(e);
		return map;
	}
}