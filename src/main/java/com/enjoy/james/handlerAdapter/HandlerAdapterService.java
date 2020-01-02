package com.enjoy.james.handlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 由JamesHandlerAdapter实现
 */
public interface HandlerAdapterService {

    /**
     * @Date 17:01 2020/1/2
     * @Description request：拿request请求里的参数
     * @Return
     * @Param
     */
    Object[] hand(HttpServletRequest request,
                  HttpServletResponse response,
                  Method method,
                  Map<String, Object> beans);
}
