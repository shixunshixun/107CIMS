package cims107.action;  
  
import java.util.Locale;
import java.util.Map;

import cims107.model.Building;
import cims107.model.User;
import cims107.service.UserService;  

import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;  
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.LocalizedTextUtil;
  
public class LogOutAction extends ActionSupport{  
          
        public LogOutAction()  
        {  
            System.out.println("initialize LoginAction......");  
        }
        
        public String execute()  
        {  
        	ActionContext.getContext().getSession().clear();
        	return LOGIN;
        }  
}  