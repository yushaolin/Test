/**
 * 
 */
package com.ysl.dao;

import java.util.List;

import com.ysl.bean.Reply;
import com.ysl.util.Page;

/**
 * @author 余少林
 *
 */
public interface ReplyDao {
	public void addReply(Reply reply);
	public List<Reply> findReplyByMsgID(int messageID,Page page);
	public int findCountByMsgID(int messageID);
}
