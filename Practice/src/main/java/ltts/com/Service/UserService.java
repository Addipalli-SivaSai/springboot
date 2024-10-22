package ltts.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import ltts.com.Model.User;
import ltts.com.Repositry.UserRepositry;


@Service
public class UserService {

	@Autowired
	public UserRepositry userRepo;
	
//	public BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);

	public String getuserDetails() {
	
		return "Hello";
	}

	public User Signin(User user) 
	{
//	    if(userRepo.findById(user.getUserId()).get().getUserId()==user.getUserId())
//	    {
//	    	return null;
//	    }
//	    else
//	    {
//		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		userRepo.save(user);
		return user;
//	    }
	     
	}

}
