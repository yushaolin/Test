/**
 * 
 */
package com.ysl.factory;

import com.ysl.dao.EmployeeDao;
import com.ysl.daoImpl.EmployeeDaoImpl;

/**
 * @author 余少林
 *
 */
public class EmployeeDaoFactory {
	public static EmployeeDao getEmployeeDaoInstance(){//工厂方法
		return new EmployeeDaoImpl();
	}
}
