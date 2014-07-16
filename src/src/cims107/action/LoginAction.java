package cims107.action;  
  
import java.util.Locale;

import cims107.service.UserService;  

import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;  
import com.opensymphony.xwork2.util.LocalizedTextUtil;
  
public class LoginAction extends ActionSupport {  
  
        public String username;  
        public String password;  
        private UserService userService;  
          
        public LoginAction()  
        {  
            System.out.println("initialize LoginAction......");  
        }
        
        public void setUserService(UserService userService)  
        {  
            this.userService = userService;  
        }  
          
        public String execute()  
        {  
            if (true == this.userService.isLogin(username, password))  
            {  
                ActionContext.getContext().getSession().put("username", username);  
                return SUCCESS;  
            }else{  
                super.addActionError(super.getText("loginfailed"));  
                return ERROR;  
            }  
        }  
        
        private String readRec(String key) {
        	return LocalizedTextUtil.findDefaultText(key, new Locale("zh_CN"));
        }
          
        public void validate()  
        {  
            if ((null == username) || (0==username.length()))  
            {  
                super.addActionError(LocalizedTextUtil.findDefaultText("warning.empty",new Locale(readRec("username"))));  
            }  
              
            if ((null == password) || (0 == password.length()))  
            {  
                super.addActionError(LocalizedTextUtil.findDefaultText("warning.empty",new Locale(readRec("password"))));  
                  
            }  
        }  
}  