/**
 * 
 */
package com.ysl.factory;

import com.ysl.dao.MessageDao;
import com.ysl.daoImpl.MessageDaoImpl;

/**
 * @author 余少林
 *
 */
public class MessageDaoFactory {
	public static MessageDao getMessageDaoInstance(){
		return new MessageDaoImpl();
	}
}
