package com.cxfx.car.common.exception;


import com.cxfx.car.common.result.Result;
import com.cxfx.car.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 处理所有不可知的异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result handleException(Exception e){
		LOGGER.error(e.getMessage(), e);
		return ResultUtil.error();
	}

	/**
	 * 处理所有业务异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public Result handleBusinessException(BusinessException e){
		LOGGER.error(e.getMessage(), e);
		return ResultUtil.error(e.getCode(), e.getMsg());
	}

}
