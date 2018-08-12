package com.ysl.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ysl.bean.Message;
import com.ysl.daoImpl.MessageDaoImpl;
import com.ysl.factory.MessageDaoFactory;
import com.ysl.util.Page;
import com.ysl.util.PageUtil;

/**
 * Servlet implementation class GetMessageList
 */
@WebServlet("/GetMessageList")
public class GetMessageList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMessageList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage=0;
		String currentPageStr=request.getParameter("currentPage");
		if (currentPageStr==null||currentPageStr.equals("")) {
			currentPage=1;
		}else{
			currentPage=Integer.parseInt(currentPageStr);
		}
		MessageDaoImpl messageDao=(MessageDaoImpl) MessageDaoFactory.getMessageDaoInstance();
		Page page=PageUtil.createPage(5, messageDao.findAllCount(), currentPage);
		List<Message> messages=messageDao.findAllMessage(page);
		request.setAttribute("messages", messages);
		request.setAttribute("page", page);
		request.getRequestDispatcher("msgList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
