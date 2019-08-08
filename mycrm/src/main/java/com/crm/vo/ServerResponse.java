package com.crm.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 返回前端数据封装
 * 
 * @author admin
 * @JsonSerialize 当序列化Json对象时，如果是null的对象，key也会消失
 * @param <T>
 */
@SuppressWarnings("serial")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

	private int status;
	private String msg;
	private T data;

	public ServerResponse(int status) {
		super();
		this.status = status;
	}

	public ServerResponse(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public ServerResponse(int status, String msg, T data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public ServerResponse(int status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

	@JsonIgnore
	public boolean isSuccess() {
		return this.status == ResponseCode.SUCCESS.getCode();
	}

	public int getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	public static <T> ServerResponse<T> createBySuccess() {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}

	public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
	}

	public static <T> ServerResponse<T> createBySuccess(T data) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
	}

	public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	public static <T> ServerResponse<T> createByError() {
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
	}

	public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
	}

	public static <T> ServerResponse<T> createByIllegalArgument(String errorMessage) {
		return new ServerResponse<T>(ResponseCode.ILLEGAL_ARGUMENT.getCode(), errorMessage);
	}

	public static <T> ServerResponse<T> createByException(String errorMessage) {
		return new ServerResponse<T>(ResponseCode.Exception.getCode(), errorMessage);
	}

	// 需要登录的构造器
	public static <T> ServerResponse<T> createByNeedLogin() {
		return new ServerResponse<T>(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
	}

	// 需要登录的构造器SELLER_NEED_LOGIN
	public static <T> ServerResponse<T> createBySellerNeedLogin() {
		return new ServerResponse<T>(ResponseCode.SELLER_NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
	}

	public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
		return new ServerResponse<T>(errorCode, errorMessage);
	}

	@Override
	public String toString() {
		return "ServerResponse [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	

}
