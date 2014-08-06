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
  
public class LoginAction extends ActionSupport implements ModelDriven<User>{  
  
        private User user;
        private UserService userService;  
          
        public LoginAction()  
        {  
            System.out.println("initialize LoginAction......");  
        }
        
        @Override
        public User getModel() {
        	if(user == null) {
        		user = new User();
        	}
        	return user;
        }
        
        public void setUserService(UserService userService)  
        {  
            this.userService = userService;  
        }  
        private boolean isValid(String value) {     
            return !((value == null || value.length() == 0));     
        }
          
        public String execute()  
        {  
        	if (!isValid(user.getUserName()))     
                return INPUT;     
        
            if (!isValid(user.getUserPassword()))     
                return INPUT;
            
            User u = new User();
            u = userService.find(user);
            if (u != null) {
            	//if (user.isUserIsAdmin())
            	//System.out.println("login");
            	Map<String, Object> s = ActionContext.getContext().getSession();
            	ActionContext.getContext().getSession().put("isadmin", u.isUserIsAdmin());
            	ActionContext.getContext().getSession().put("islogin", "true");
            	ActionContext.getContext().getSession().put("username", u.getUserName());
            	return SUCCESS;
            }
            return ERROR;
        }  
        
        
}  