package xin.zachary.nffn.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.springframework.stereotype.Component;

/**
    登录拦截器
    用于拦截一些需要登录而未登录的操作
 */
@Component
public class LoginInterceptor  extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object username=actionInvocation.getInvocationContext().getSession().get("username");
        if (username==null)
            return "login";
        else
            return actionInvocation.invoke();
    }
}
