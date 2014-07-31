package cims107.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	@Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
  
        // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String islogin = (String) session.get("islogin");
  
        if (islogin != null && islogin.equals("true")) {  
            //System.out.println("test1");  
            return invocation.invoke();  
        }  
  
        ctx.put("tip", "你还没有登录");  
        return Action.LOGIN;  
    }
}
