package com.tka.MappingProjectSpringboot.Dao;



import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.MappingProjectSpringboot.entity.Country;
//import com.tka.MappingProjectSpringboot.entity.Employee;
import com.tka.MappingProjectSpringboot.entity.Employee;



@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
      //insert country
	public String addCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(c);
			tx.commit();
			msg = "Data Addedd Succefully..";

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}
               //update country
	public String updateCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, c.getCid());

			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg = "Data Updated Succefully..";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}
     // delete data
	public String deleteCountry(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country c = session.get(Country.class, id); // get() is used for get old record into c and store into "c"
			session.remove(c);

			tx.commit();
			msg = "Data Deleted Succefully..";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	// GET PARTICULAR DATA
	public Country getData(int id) {
		Session session = null;
		Transaction tx = null;
		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			country = session.get(Country.class, id);

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

	// GET ALL RECORD

	public List<Country> getAll() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			String hqlQry = "from Country";
			Query<Country> qry = session.createQuery(hqlQry, Country.class);
			list = qry.list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	// ADD DATA INTO EMPLOYEE
	public String addEmployee(Employee e) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(e);
			tx.commit();
			msg = "Record is Addedd Successfully";

		} catch (Exception e1) {
			if (tx != null) {
				tx.rollback();
			}

			e1.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;

	}
       //update employee
	public String updateEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee employee = session.get(Employee.class, emp.getId());

			employee.setName(emp.getName());
			employee.setPhoneno(emp.getPhoneno());
			employee.setDepartment(emp.getDepartment());
			employee.setStatus(emp.getStatus());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setCreatedby(emp.getCreatedby());
			employee.setUpdateddtm(emp.getUpdateddtm());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setCountry(emp.getCountry());

			session.merge(employee);
			tx.commit();
			msg = "Data Updated Succefully..";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	// DAO FOR DELETE EMPLOYEE
	public String deleteEmployee(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee e = session.get(Employee.class, id);
			session.remove(e);

			tx.commit();
			msg = "Data Deleted Succefully..";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}
	
//get emp perticular data
	public Employee getEmp(int id) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			String hqlQuery = "from Employee where id=:myid";
			Query<Employee> qry = session.createQuery(hqlQuery, Employee.class);
			qry.setParameter("myid", id);

			employee = qry.uniqueResult();
			

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}
//get all emp
	public List<Employee> getAllEmp() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			String hqlQry = "from Employee";
			Query<Employee> qry = session.createQuery(hqlQry, Employee.class);
			list = qry.list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	//* GET RECORD BY STATUS *//
	public List<Employee> getEmployeesByStatus(String status) {
		 Session session = null;
	        Transaction tx = null;
	        List<Employee> employees = null;
	        try {
	            session = factory.openSession();
	            tx = session.beginTransaction();

	            String hqlQuery = "from Employee where status=:myStatus";
	            Query<Employee> qry = session.createQuery(hqlQuery, Employee.class);
	            qry.setParameter("myStatus", status);
	            employees = qry.list();

	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
	        return employees;
	}
	//login user
	public Employee checkUser(Employee e) {
		Session session = null;
		Transaction tx = null;
		Employee emp =null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			String hqlQry = "from Employee where name=:myname and phoneno=:phoneno";
			Query<Employee> qry = session.createQuery(hqlQry,Employee.class);
			qry.setParameter("myname", e.getName());
			qry.setParameter("phoneno", e.getPhoneno());
			emp= qry.uniqueResult();
			tx.commit();
		} catch (Exception e1) {
            if (tx != null) {
                tx.rollback();
            }
            e1.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
		return emp;
       
	}

}