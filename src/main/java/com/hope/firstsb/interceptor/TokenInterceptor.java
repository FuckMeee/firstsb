package com.hope.firstsb.interceptor;

import com.hope.firstsb.annotation.IgnoreToken;
import com.hope.firstsb.annotation.Token;
import com.hope.firstsb.exception.BizException;
import com.hope.firstsb.support.ResponseCode;
import com.hope.firstsb.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author zwh
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {


    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("开始拦截.........");

        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 转成HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取“方法”
        Method method = handlerMethod.getMethod();
        // 判断该方法上是否有注解
        if (method.isAnnotationPresent(IgnoreToken.class)) {
            IgnoreToken ignoreToken = method.getAnnotation(IgnoreToken.class);
            if (ignoreToken.required()) {
                return true;
            }
        }
        // 没有注解或者注解返回不为true，则开始验证token
        // 从header中取出token
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new BizException(ResponseCode.UNAUTHORIZED.getCode(), ResponseCode.UNAUTHORIZED.getMsg());
        }

        if (!JwtUtil.verifyToken(token)) {
            throw new BizException(ResponseCode.UNAUTHORIZED.getCode(), ResponseCode.UNAUTHORIZED.getMsg());
        }

        return true;
    }

    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO

    }
    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO

    }
}
