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

import com.ysl.bean.Reply;
import com.ysl.dao.ReplyDao;
import com.ysl.util.DBConnection;
import com.ysl.util.Page;

/**
 * @author 余少林
 *
 */
public class ReplyDaoImpl implements ReplyDao {
	@Override
	public void addReply(Reply reply) {
		Connection connection=DBConnection.getConnection();
		String sql="insert into tb_reply(replyContent,employeeID,replyTime,messageID) values(?,?,?,?)";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, reply.getReplyContent());
			preparedStatement.setInt(2, reply.getEmployeeID());
			preparedStatement.setTimestamp(3, new Timestamp(reply.getReplyTime().getTime()));//设置回复时间
			preparedStatement.setInt(4, reply.getMessageID());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
	}
	@Override
	public List<Reply> findReplyByMsgID(int messageID, Page page) {
		Connection connection=DBConnection.getConnection();
		String sql="select replyID,replyContent,employeeID,replyTime,messageID from tb_reply where messageID=? limit ?,?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Reply> replies=new ArrayList<>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, messageID);
			preparedStatement.setInt(2, page.getBeginIndex());
			preparedStatement.setInt(3, page.getEveryPage());
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				Reply reply=new Reply();
				reply.setReplyID(resultSet.getInt(1));
				reply.setReplyContent(resultSet.getString(2));
				reply.setEmployeeID(resultSet.getInt(3));
				reply.setReplyTime(resultSet.getTimestamp(4));
				reply.setMessageID(resultSet.getInt(5));
				replies.add(reply);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		return replies;
	}
	@Override
	public int findCountByMsgID(int messageID) {
		Connection connection=DBConnection.getConnection();
		String sql="select count(*) from tb_reply where messageID=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int count=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, messageID);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				count=resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.close(resultSet);
			DBConnection.close(preparedStatement);
			DBConnection.close(connection);
		}
		return count;
	}

}
