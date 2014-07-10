package cims107.action;  
  
import cims107.service.UserService;  

import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;  
  
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
          
        public void validate()  
        {  
            if ((null == username) || (0==username.length()))  
            {  
                super.addActionError(super.getText("warning.empty",new String[] {getText("username")}));  
            }  
              
            if ((null == password) || (0 == password.length()))  
            {  
                super.addActionError(super.getText("warning.empty",new String[] {getText("password")}));  
                  
            }  
        }  
}  