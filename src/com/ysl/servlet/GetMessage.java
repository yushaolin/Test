package com.ysl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysl.bean.Message;
import com.ysl.bean.Reply;
import com.ysl.dao.ReplyDao;
import com.ysl.factory.MessageDaoFactory;
import com.ysl.factory.ReplyDaoFactory;
import com.ysl.util.Page;
import com.ysl.util.PageUtil;

/**
 * Servlet implementation class GetMessage
 */
@WebServlet("/GetMessage")
public class GetMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageID=Integer.parseInt(request.getParameter("messageID"));
		Message message=MessageDaoFactory.getMessageDaoInstance().findMessageById(messageID);
		request.setAttribute("message", message);
		int currentPage=0;
		String currentPageStr=request.getParameter("currentPage");
		if (currentPageStr==null||currentPageStr.equals("")) {
			currentPage=1;
		}else{
			currentPage=Integer.parseInt(currentPageStr);
		}
		ReplyDao replyDao=ReplyDaoFactory.getReplyDaoInstance();
		Page page=PageUtil.createPage(5, replyDao.findCountByMsgID(messageID), currentPage);
		List<Reply> replies=replyDao.findReplyByMsgID(messageID, page);
		request.setAttribute("replies", replies);
		request.setAttribute("page", page);
		request.getRequestDispatcher("showMsg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
