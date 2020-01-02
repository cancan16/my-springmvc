package com.enjoy.james.argumentResolver;

import com.enjoy.james.annotation.EnjoyService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Date 17:13 2020/1/2
 * @Description 解析HttpServletResponse类型参数
 * @Return
 * @Param
 */
@EnjoyService("httpServletResponseArgumentResolver")
public class HttpServletResponseArgumentResolver implements ArgumentResolver {
    // 判断传进来的参数是否为response
    public boolean support(Class<?> type, int paramIndex, Method method) {
        /**
         * isAssignableFrom方法：
         * 判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口
         */
        return ServletResponse.class.isAssignableFrom(type);
    }

    // 如果返回的参数是response,则直接返回
    public Object argumentResolver(HttpServletRequest request,
                                   HttpServletResponse response, Class<?> type, int paramIndex,
                                   Method method) {
        return response;
    }

}
