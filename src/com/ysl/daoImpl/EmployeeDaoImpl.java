/**
 * 
 */
package com.ysl.daoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.ysl.bean.Employee;
import com.ysl.dao.EmployeeDao;
import com.ysl.util.DBConnection;

/**
 * @author 余少林
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

	public String addEmployee(Employee employee) {
		// TODO 自动生成的方法存根
		Connection connection=DBConnection.getConnection();
		String sql="insert into tb_employee(employeeID,employeeName,employeeSex,employeeBirth,employeePhone,employeePlace,joinTime,password,isLead) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,employee.getEmployeeID());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setBoolean(3, employee.getEmployeeSex());
			preparedStatement.setDate(4, (Date) employee.getEmployeeBirth());
			preparedStatement.setString(5, employee.getEmployeePhone());
			preparedStatement.setString(6, employee.getEmployeePlace());
			preparedStatement.setDate(7, (Date) employee.getJoinTime());
			preparedStatement.setString(8, employee.getPassword());
			preparedStatement.setBoolean(9, employee.isLead());
			count=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
			if (count!=0) {
				return "新员工添加成功！";
			}else {
				return "您的操作有误！";
			}
		
	}
	public String deleteEmployeeById(int employeeID) {
		// TODO 自动生成的方法存根
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		String sql="delete from tb_employee where employeeID=?";
		int count=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeID);
			count=preparedStatement.executeUpdate();
		} catch (Exception e) {
		}finally {
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		if (count!=0) {
			return "删除成功！";
		}else {
			return "删除失败！";
		}
	}
	public String updateEmployee(Employee employee) {
		// TODO 自动生成的方法存根
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		String sql="update tb_employee set employeeName=?,employeeSex=?,employeeBirth=?,employeePhone=?,employeePlace=?,joinTime=?,password=?,isLead=? where employeeID=?";
		int count = 0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(9,employee.getEmployeeID());
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setBoolean(2, employee.getEmployeeSex());
			preparedStatement.setDate(3, (Date) employee.getEmployeeBirth());
			preparedStatement.setString(4, employee.getEmployeePhone());
			preparedStatement.setString(5, employee.getEmployeePlace());
			preparedStatement.setDate(6, (Date) employee.getJoinTime());
			preparedStatement.setString(7, employee.getPassword());
			preparedStatement.setBoolean(8, employee.isLead());
			count=preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		if (count!=0) {
			return "修改成功！";
		}else {
			return "修改失败！";
		}
	}
	@SuppressWarnings("null")
	public List<Employee> findAllEmployee() {
		Connection connection=DBConnection.getConnection();
		List<Employee> employees=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String sql="select employeeID,employeeName,employeeSex,employeeBirth,employeePhone,employeePlace,joinTime,password,isLead from tb_employee";
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Employee employee=new Employee();
				employee.setEmployeeID(resultSet.getInt(1));
				employee.setEmployeeName(resultSet.getString(2));
				employee.setEmployeeSex(resultSet.getBoolean(3));
				employee.setEmployeeBirth(resultSet.getDate(4));
				employee.setEmployeePhone(resultSet.getString(5));
				employee.setEmployeePlace(resultSet.getString(6));
				employee.setJoinTime(resultSet.getDate(7));
				employee.setPassword(resultSet.getString(8));
				employee.setLead(resultSet.getBoolean(9));
				employees.add(employee);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		return employees;
	}
	public Employee findEmployeeById(int employeeID) {
		// TODO 自动生成的方法存根
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		String sql="select employeeID,employeeName,employeeSex,employeeBirth,employeePhone,employeePlace,joinTime,password,isLead from tb_employee where employeeID=?";
		ResultSet resultSet=null;
		Employee employee=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeID);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				employee=new Employee();
				employee.setEmployeeID(resultSet.getInt(1));
				employee.setEmployeeName(resultSet.getString(2));
				employee.setEmployeeSex(resultSet.getBoolean(3));
				employee.setEmployeeBirth(resultSet.getDate(4));
				employee.setEmployeePhone(resultSet.getString(5));
				employee.setEmployeePlace(resultSet.getString(6));
				employee.setJoinTime(resultSet.getDate(7));
				employee.setPassword(resultSet.getString(8));
				employee.setLead(resultSet.getBoolean(9));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		return employee;
	}

}
