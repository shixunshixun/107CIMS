package cims107.service;  
  
import cims107.model.User;  
import cims107.dao.UserDao; 
  
public class UserService {  
    private UserDao userDao;  
      
    public boolean isLogin(User user) {  
        return isLogin(user.getUserName(),user.getUserPassword());  
    }  
    
    public User find(User user) {
    	return userDao.find(user);
    }
  
    public UserDao getUserDao() {  
        return userDao;  
    }  
  
    public void setUserDao(UserDao userDao) {  
        this.userDao = userDao;  
    }  
  
    public boolean isLogin(String name, String password) {  
        boolean isLogin = false;  
        try  
            {  
            User u = userDao.find(name, password);  
            if (u != null)  
                {  
                isLogin = true;  
                }  
            }  
        catch (Exception e)  
            {  
            System.out.println("isLogin error\n" + e.getMessage());  
            }  
        return isLogin;  
    }  
  
}  