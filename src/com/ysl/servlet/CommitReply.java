package com.ysl.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysl.bean.Employee;
import com.ysl.bean.Reply;
import com.ysl.dao.ReplyDao;
import com.ysl.factory.ReplyDaoFactory;

/**
 * Servlet implementation class CommitReply
 */
@WebServlet("/CommitReply")
public class CommitReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommitReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyContent=request.getParameter("editorValue");
		int messageID=Integer.parseInt(request.getParameter("messageID"));
		Employee employee=(Employee) request.getSession().getAttribute("employee");
		if (employee==null) {
			request.setAttribute("error", "要进行回复必须首先进行身份识别！");
			request.getRequestDispatcher("GetMessage?messageID="+messageID).forward(request, response);
		}else{
			if (replyContent==null||"".equals(replyContent)) {
				request.setAttribute("error", "必须输入回复内容！");
				request.getRequestDispatcher("GetMessage?messageID="+messageID).forward(request, response);
			}else{
				Reply reply=new Reply();
				reply.setEmployeeID(employee.getEmployeeID());
				reply.setMessageID(messageID);
				reply.setReplyContent(replyContent);
				reply.setReplyTime(new Date());
				ReplyDao replyDao=ReplyDaoFactory.getReplyDaoInstance();
				replyDao.addReply(reply);
				request.getRequestDispatcher("GetMessage?messageID="+messageID).forward(request, response);
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
