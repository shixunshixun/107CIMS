package cims107.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class IsAdminInterceptor extends AbstractInterceptor {
	@Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
  
        // ȡ��������ص�ActionContextʵ��  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        Boolean isadmin = (Boolean) session.get("isadmin");
  
        if (isadmin) {  
            //System.out.println("test2");  
            return invocation.invoke();  
        }  
  
        ctx.put("tip", "�㲻�ǹ���Ա");  
        return "buildingsearch";  
    }
}
