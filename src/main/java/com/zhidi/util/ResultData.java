package com.zhidi.util;

import java.io.Serializable;

/**
 * 用于封装执行结果
 * @author Lu Jianliang
 *
 */
public class ResultData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8967147927300560419L;

	/**
	 * 用于封装执行结果是否成功
	 */
	private boolean success = true;
	
	/**
	 * 用于封装执行结果的描述信息
	 */
	private String message = "";
	
	/**
	 * 用于封装执行结果数据
	 */
	private Object data;
	
	public ResultData(){}
	
	/**
	 * 创建JSONResult对象
	 * @param success -执行结果是否成功
	 * @param message -对结果的描述
	 */
	public ResultData(boolean success, String message){
		this(success, message ,null);
	}
	
	/**
	 * 创建JSONResult对象
	 * @param success -执行结果是否成功
	 * @param message -对结果的描述
	 * @param data -结果数据
	 */
	public ResultData(boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	/**
	 * 构建用于表示执行成功的JSONResult对象，不含结果信息和执行结果数据
	 * @return
	 */
	public static ResultData buildSuccessResult(){
		return buildSuccessResult("");
	}
	
	/**
	 * 构建表示执行成功的JSONResult对象，不含执行结果数据
	 * @param message -执行成功描述信息
	 * @return
	 */
	public static ResultData buildSuccessResult(String message){
		return buildSuccessResult(message, null);
	}
	
	/**
	 * 构建表示执行成功的JSONResult对象
	 * @param message -执行成功的描述信息
	 * @param data -执行成功的结果数据
	 * @return
	 */
	public static ResultData buildSuccessResult(String message, Object data){
		return new ResultData(true, message, data);
	}
	
	/**
	 * 构建执行失败的JSONResult对象，不包含失败信息结果数据
	 * @return
	 */
	public static ResultData buildFailureResult(){
		return buildFailureResult("");
	}
	
	/**
	 * 构建执行失败的JSONResult对象，不包含失败信息结果数据
	 * @param message -执行失败描述信息
	 * @return
	 */
	public static ResultData buildFailureResult(String message){
		return buildFailureResult(message, null);
	}
	
	/**
	 * 构建执行失败的JSONResult对象
	 * @param message -执行失败描述信息
	 * @param data -结果数据
	 * @return
	 */
	public static ResultData buildFailureResult(String message, Object data){
		return new ResultData(false, message, data);
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
