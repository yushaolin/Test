/**
 * 
 */
package com.ysl.bean;

/**
 * @author 余少林
 *
 */
public class Criticism {
	private int criticismID;
	private String criticismContent;
	private int employeeID;
	private int messageID;
	public int getCriticismID() {
		return criticismID;
	}
	public void setCriticismID(int criticismID) {
		this.criticismID = criticismID;
	}
	public String getCriticismContent() {
		return criticismContent;
	}
	public void setCriticismContent(String criticismContent) {
		this.criticismContent = criticismContent;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	
}
