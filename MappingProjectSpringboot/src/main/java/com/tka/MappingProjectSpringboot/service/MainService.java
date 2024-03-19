package com.tka.MappingProjectSpringboot.service;



import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.MappingProjectSpringboot.Dao.MainDao;
import com.tka.MappingProjectSpringboot.entity.Country;
//import com.tka.MappingProjectSpringboot.entity.Employee;
import com.tka.MappingProjectSpringboot.entity.Employee;


@Service
public class MainService {

	@Autowired
	MainDao dao;
         //add con
	public String addCountry(Country c) {
		String msg = dao.addCountry(c);
		if (Objects.isNull(msg)) {
			msg = "Data is Not Added";
		}
		return msg;
	}

	  //update country
	public String updateCountry(Country c) {
		String msg = dao.updateCountry(c);
		 if(Objects.isNull(msg)) {
			msg = "Data is not updated";
		}
		return msg;
	}
         //delete country
	public String deleteCountry(int id) {
		String msg = dao.deleteCountry(id);
		if (Objects.isNull(msg)) {
			msg = "Data is not Deleted";
		}
		return msg;
	}
//get particular data
	public Country getData(int id) {
		Country con = dao.getData(id);
		if (Objects.isNull(con)) {
			con=null;
			return null;
		}
		return con;
	}
        //get all country
	public List<Country> getAll() {
		List<Country> list = dao.getAll();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	// * add FOR EMPLOYEE *//

	public String addEmployee(Employee e) {
		String msg = dao.addEmployee(e);

		if (Objects.isNull(msg)) {
			msg = "Record is not be Added...";
		}

		return msg;
	}
	
	//* UPDATE EMP *//
	public String updateEmployee(Employee e) {
		String msg = dao.updateEmployee(e);
		return msg;
	}
	
	//*  DELETE EMP  *//
	public String deleteEmployee(int id) {
		String msg = dao.deleteEmployee(id);
		if (Objects.isNull(msg)) {
			msg = "Data is not Deleted";
		}
		return msg;
	}

	//* GET RECORD BY ID OF EMP *//
	public Employee getEmp(int id) {
		Employee emp = dao.getEmp(id);
		if (Objects.isNull(emp)) {
			emp=null;
		}
		return emp;
	}

	//* GET ALL RECORD OF EMP *//
	public List<Employee> getAllEmp() {
		List<Employee> list = dao.getAllEmp();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}


	//* GET RECORD BY STATUS *//
	public List<Employee> getEmployeesByStatus(String status) {
	
		 List<Employee> employees =	dao.getEmployeesByStatus(status);
		return employees;
	}
	
	//* LOGIN API  *//
	public HashMap loginApi(Employee e) {
		Employee emp = dao.checkUser(e);
		HashMap map = new HashMap();
		if(Objects.isNull(emp)) {
			map.put("msg","Invalid User" );
			map.put("user", emp);
		}
		else {
			map.put("msg", "Valid User");
			map.put("user", emp);
		}
		return map;
	}

}