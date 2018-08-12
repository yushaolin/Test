/**
 * 
 */
package com.ysl.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ysl.bean.Message;
import com.ysl.dao.MessageDao;
import com.ysl.util.DBConnection;
import com.ysl.util.Page;

/**
 * @author 余少林
 *
 */
public class MessageDaoImpl implements MessageDao {
	@Override
	public void addMessage(Message message) {
		Connection connection=DBConnection.getConnection();
		String sql="insert into tb_message(messageTitle,messageContent,employeeID,publishTime) values(?,?,?,?)";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, message.getMessageTitle());//设置消息标题
			preparedStatement.setString(2, message.getMessageContent());//设置消息内容
			preparedStatement.setInt(3, message.getEmployeeID());//设置员工编号
			preparedStatement.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));//设置发布时间
			preparedStatement.executeUpdate();		//执行插入
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
	}
	@Override
	public void deleteMessage(int messageID) {
		
	}
	@Override
	public void updateMessage(Message message) {
		
	}
	@Override
	public List<Message> findAllMessage(Page page) {
		Connection connection=DBConnection.getConnection();
		String sql="select messageID,messageTitle,messageContent,employeeID,publishTime from tb_message order by publishTime desc limit ?,?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Message> messages=new ArrayList<Message>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, page.getBeginIndex());
			preparedStatement.setInt(2, page.getEveryPage());
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				Message message=new Message();
				message.setMessageID(resultSet.getInt(1));
				message.setMessageTitle(resultSet.getString(2));
				message.setMessageContent(resultSet.getString(3));
				message.setEmployeeID(resultSet.getInt(4));
				message.setPublishTime(resultSet.getTimestamp(5));
				messages.add(message);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		return messages;
	}
	@Override
	public Message findMessageById(int messageID) {
		Connection connection=DBConnection.getConnection();
		String sql="select messageID,messageTitle,messageContent,employeeID,publishTime from tb_message where messageID=?";
		PreparedStatement preparedStatement=null;
		Message message=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, messageID);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				message=new Message();
				message.setMessageID(resultSet.getInt(1));
				message.setMessageTitle(resultSet.getString(2));
				message.setMessageContent(resultSet.getString(3));
				message.setEmployeeID(resultSet.getInt(4));
				message.setPublishTime(resultSet.getTimestamp(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		return message;
	}
	@Override
	public int findAllCount() {
		Connection connection=DBConnection.getConnection();
		String sql="select count(*) from tb_message";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int count=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				count=resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		return count;
	}

}
