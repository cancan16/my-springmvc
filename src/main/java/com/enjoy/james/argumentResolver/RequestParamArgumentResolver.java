package com.enjoy.james.argumentResolver;

import com.enjoy.james.annotation.EnjoyRequestParam;
import com.enjoy.james.annotation.EnjoyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 自定义的参数注解解析器
 * isAssignableFrom方法：
 * 判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口
 */
@EnjoyService("requestParamArgumentResolver")
// 解析声明注解为RequestParam, 获取注解的值
public class RequestParamArgumentResolver implements ArgumentResolver {
    //判断传进来的参数是否为EnjoyRequestParam
    public boolean support(Class<?> type, int paramIndex, Method method) {

        /**
         * 匹配EnjoyRequestParam注解的参数： true匹配成功，false匹配失败
         * HttpServletRequest request,
         * HttpServletResponse response,
         * @EnjoyRequestParam("name") String name,
         * @EnjoyRequestParam("age") String age
         * 方法中的参数是二维数组：因为一个参数前面可以添加多个注解，也就是多个类型
         * [][]: 参数脚标和类型
         * 自定义注解@EnjoyRequestParam一个参数
         */
        Annotation[][] an = method.getParameterAnnotations();
        Annotation[] paramAns = an[paramIndex];
        for (Annotation paramAn : paramAns) {
            // 判断传进的paramAn.getClass()是不是 EnjoyRequestParam 类型
            if (EnjoyRequestParam.class.isAssignableFrom(paramAn.getClass())) {
                return true;
            }
        }
        return false;
    }

    //参数解析,并获取注解的值
    public Object argumentResolver(HttpServletRequest request,
                                   HttpServletResponse response, Class<?> type, int paramIndex,
                                   Method method) {

        Annotation[][] an = method.getParameterAnnotations();
        Annotation[] paramAns = an[paramIndex];
        for (Annotation paramAn : paramAns) {
            if (EnjoyRequestParam.class.isAssignableFrom(paramAn.getClass())) {
                // 获取当前注解对象
                EnjoyRequestParam rp = (EnjoyRequestParam) paramAn;
                // 获取注解的值，就是@EnjoyRequestParam("name")中的name
                String value = rp.value();
                return request.getParameter(value);
            }
        }
        return null;
    }

}
