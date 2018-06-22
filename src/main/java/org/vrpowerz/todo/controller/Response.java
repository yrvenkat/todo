package org.vrpowerz.todo.controller;


public class Response {
	
	private Object Data;
	private boolean Result;

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}
	
	
	public boolean isResult() {
		return Result;
	}

	public void setResult(boolean result) {
		Result = result;
	}

	public Response (Object data){
		this.Data = data;
	}

	public Response (Object data, boolean result){
		this.Data = data;
		this.Result = result;
	}
	
	
	

}
