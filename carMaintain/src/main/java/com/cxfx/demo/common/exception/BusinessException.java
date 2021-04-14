package com.cxfx.demo.common.exception;


import com.cxfx.demo.common.result.ResultEnum;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

	private Integer code;

	private String msg;

	public BusinessException(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public BusinessException(String msg) {
		this.code = ResultEnum.ERROR.getCode();
		this.msg = msg;
	}
}
