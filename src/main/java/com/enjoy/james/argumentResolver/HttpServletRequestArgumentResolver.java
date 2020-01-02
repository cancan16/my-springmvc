package com.enjoy.james.argumentResolver;

import com.enjoy.james.annotation.EnjoyService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Date 17:13 2020/1/2
 * @Description 解析httpServletReuqest类型参数
 * @Return
 * @Param
 */
@EnjoyService("httpServletRequestArgumentResolver") // 注入到容器中
public class HttpServletRequestArgumentResolver implements ArgumentResolver {
    //判断传进来的参数是否为request
    public boolean support(Class<?> type, int paramIndex, Method method) {
        // 判断type类型是否集成ServletRequest类
        return ServletRequest.class.isAssignableFrom(type);
    }

    ////如果返回的参数是request,则直接返回
    public Object argumentResolver(HttpServletRequest request,
                                   HttpServletResponse response, Class<?> type, int paramIndex,
                                   Method method) {
        return request;
    }

}
