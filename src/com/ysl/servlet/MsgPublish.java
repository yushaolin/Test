package com.ysl.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysl.bean.Employee;
import com.ysl.bean.Message;
import com.ysl.dao.MessageDao;
import com.ysl.factory.MessageDaoFactory;

/**
 * Servlet implementation class MsgPublish
 */
@WebServlet("/MsgPublish")
public class MsgPublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgPublish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String content=request.getParameter("editorValue");
		Employee employee=(Employee) request.getSession().getAttribute("employee");
		if (employee==null) {
			request.setAttribute("error", "必须先进行身份识别！");
			request.getRequestDispatcher("publishNewMsg.jsp").forward(request, response);
		}else {
			if (title==null||title.equals("")) {
				request.setAttribute("error", "必须输入消息标题！");
				request.getRequestDispatcher("publishNewMsg.jsp").forward(request, response);
			}else {
				Message message=new Message();
				message.setEmployeeID(employee.getEmployeeID());
				message.setMessageTitle(title);
				message.setMessageContent(content);
				message.setPublishTime(new Date());
				MessageDao messageDao=MessageDaoFactory.getMessageDaoInstance();
				messageDao.addMessage(message);
				response.sendRedirect("GetMessageList");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
