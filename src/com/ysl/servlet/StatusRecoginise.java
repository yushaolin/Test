package com.ysl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysl.bean.Employee;
import com.ysl.dao.EmployeeDao;
import com.ysl.factory.EmployeeDaoFactory;

/**
 * Servlet implementation class StatusRecoginise
 */
@WebServlet("/StatusRecoginise")
public class StatusRecoginise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusRecoginise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeID=request.getParameter("employeeID");
		String password=request.getParameter("password");
		if (employeeID==null||"".equals(employeeID)) {
			request.setAttribute("error", "请输入员工编号！");
			request.getRequestDispatcher("statusRecoginise.jsp").forward(request, response);
		}else{
			if (password==null||"".equals(password)) {
				request.setAttribute("error", "请输入系统口令！");
				request.getRequestDispatcher("statusRecoginise.jsp").forward(request, response);
			}else {
				EmployeeDao employeeDao=EmployeeDaoFactory.getEmployeeDaoInstance();
				Employee employee=employeeDao.findEmployeeById(Integer.parseInt(employeeID));
				if (employee==null) {
					request.setAttribute("error", "该员工不存在！");
					request.getRequestDispatcher("statusRecoginise.jsp").forward(request, response);
				}else {
					if (password.equals(employee.getPassword())) {
						request.getSession().setAttribute("employee", employee);
						request.getRequestDispatcher("GetMessageList").forward(request, response);
						/*response.sendRedirect("GetMessageList");*/
						
					}else {
						request.setAttribute("error", "系统口令不正确！");
						request.getRequestDispatcher("statusRecoginise.jsp").forward(request, response);
					}
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
