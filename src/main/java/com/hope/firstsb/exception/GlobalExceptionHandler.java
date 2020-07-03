package com.hope.firstsb.exception;

import com.hope.firstsb.support.Response;
import com.hope.firstsb.support.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zwh
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 捕获  BizException 异常
     *
     * @param request  HttpServletRequest
     * @param e        Exception
     * @param response HttpServletResponse
     * @return 响应结果
     */
    @ExceptionHandler(BizException.class)
    public Response customExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
        BizException exception = (BizException) e;
        logException(exception.getClass().getName(), exception.getCode(), exception.getMessage(), getStackTraceString(exception));
        return Response.exception(exception.getCode(), exception.getMessage());
    }

    /**
     * 捕获  RuntimeException 异常
     *
     * @param request  request
     * @param e        Exception
     * @param response HttpServletResponse
     * @return 响应结果
     */
    @ExceptionHandler(RuntimeException.class)
    public Response runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException exception = (RuntimeException) e;
        logException(exception.getClass().getName(), ResponseCode.FAIL.getCode(), exception.getMessage(), getStackTraceString(exception));
        return Response.fail().addMsg(exception.getMessage());
    }

    /**
     * 捕获  Exception 异常
     *
     * @param request  HttpServletRequest
     * @param e        Exception
     * @param response HttpServletResponse
     * @return 响应结果
     */
    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
        logException(e.getClass().getName(), ResponseCode.FAIL.getCode(), e.getMessage(), getStackTraceString(e));
        return Response.fail().addMsg(e.getMessage());
    }

    /**
     * 记录异常
     *
     * @param type String
     * @param code int
     * @param msg  String
     * @param st   String
     */
    private void logException(String type, int code, String msg, String st) {
        log.error("{} START ================================= ", type);
        log.error("CODE: {}", code);
        log.error("MSG: {}", msg);
        log.error("EXCEPTION STACKTRACE: {}", st);
    }

    /**
     * 获取异常堆栈信息
     *
     * @param e Exception
     * @return 异常堆栈字符串
     */
    private String getStackTraceString(Exception e) {
        StackTraceElement[] traceElements = e.getStackTrace();
        StringBuilder traceBuilder = new StringBuilder();
        if (traceElements != null && traceElements.length > 0) {
            for (StackTraceElement traceElement : traceElements) {
                String teString = traceElement.toString();
                if (teString.startsWith("com.hope")) { // 只打印应用包的堆栈信息
                    traceBuilder.append(traceElement.toString());
                    traceBuilder.append("\n");
                } else {
                    break;
                }
            }
        }
        return traceBuilder.toString();
    }
}
