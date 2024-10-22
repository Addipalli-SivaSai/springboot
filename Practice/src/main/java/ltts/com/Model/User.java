package ltts.com.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
        @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int Id;
	    private String UserName;
	    private String UserPassword;
	    
	    public User()
	    {
	    	
	    }
	    public User(int Id,String UserName,String UserPassword)
	    {
	    	this.Id=Id;
	    	this.UserName=UserName;
	    	this.UserPassword=UserPassword;
	    }
	    public int getUserId()
	    {
	        return Id;
	    }
	    public void seUserId(int Id)
	    {
	        this.Id=Id;
	    }
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getUserPassword() {
			return UserPassword;
		}
		public void setUserPassword(String userPassword) {
			UserPassword = userPassword;
		}



	    

}
