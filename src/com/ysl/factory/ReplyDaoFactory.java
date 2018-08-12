/**
 * 
 */
package com.ysl.factory;

import com.ysl.dao.ReplyDao;
import com.ysl.daoImpl.ReplyDaoImpl;

/**
 * @author 余少林
 *
 */
public class ReplyDaoFactory {
	public static ReplyDao getReplyDaoInstance(){
		return new ReplyDaoImpl();
	}
}
