/**
 * 
 */
package com.ysl.dao;

import java.util.List;

import com.ysl.bean.Message;
import com.ysl.util.Page;

/**
 * @author 余少林
 *
 */
public interface MessageDao {
	public void addMessage(Message message);
	public void deleteMessage(int messageID);
	public void updateMessage(Message message);
	public List<Message> findAllMessage(Page page);
	public Message findMessageById(int messageID);
	public int findAllCount();
}
