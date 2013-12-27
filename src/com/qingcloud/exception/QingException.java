package com.qingcloud.exception;

public class QingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4251841288428053663L;
	
	/**
	 * 实例化一个基础运行时异常
	 * @param msg 异常消息
	 */
	public QingException(String msg) {
		super(msg);
	}
	/**
	 * 实例化一个基础运行时异常
	 * @param cause 异常
	 */
	public QingException(Throwable cause) {
		super(cause);
	}
	/**
	 * 实例化一个基础运行时异常
	 * @param msg 异常消息
	 * @param cause 异常
	 */
	public QingException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
