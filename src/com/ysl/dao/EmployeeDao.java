/**
 * 
 */
package com.ysl.dao;

import java.util.List;

import com.ysl.bean.Employee;

/**
 * @author 余少林
 *
 */
public interface EmployeeDao {
	public String addEmployee(Employee employee);
	public String deleteEmployeeById(int employeeID);
	public String updateEmployee(Employee employee);
	public Employee findEmployeeById(int employeeID);
	public List<Employee> findAllEmployee();
}
