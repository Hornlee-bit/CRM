package com.zhidi.base.exception;

/**
 * 基础异常类，是当前项目中所有自定义异常类最顶层父类
 * @author Lu Jianliang
 *
 */
public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5716893733866938810L;

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}
	
	

}
