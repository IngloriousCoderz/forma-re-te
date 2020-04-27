package it.formarete.action;

import it.formarete.model.Employee;
import it.formarete.service.EmployeeDAO;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class NewEmployee extends ActionSupport {

	private static final long serialVersionUID = -4464670203762168320L;

	private String name;
	private float salary;
	private List<Employee> employees;
	/* injected for no particular reason */
	private EmployeeDAO dao;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String execute() throws Exception {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setSalary(salary);
		dao.save(employee);
		employees = dao.getAll();
		return SUCCESS;
	}
}
