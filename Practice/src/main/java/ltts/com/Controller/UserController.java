package ltts.com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ltts.com.Model.User;
import ltts.com.Repositry.UserRepositry;
import ltts.com.Service.UserService;

@RestController
public class UserController {
	@Autowired
     public UserService userService;
	
	 public UserController( UserService userService)
	 {
		 this.userService=userService;
	 }
		@Autowired
		public UserRepositry userRepo;
		
	
	@PostMapping("/signin")
	
	public ResponseEntity<?> AddUser(@RequestBody User user)
	{
		 try 
		 {  
			 return new ResponseEntity<>(user,HttpStatus.CREATED); 
		 } 
		 catch(Exception ex)
		 {
			 return new ResponseEntity<>(ex.getMessage(),HttpStatus.FAILED_DEPENDENCY);  
	     } 
	}
	@GetMapping("/userlist")
	public List<User> GetUsers()
	{
		return userRepo.findAll();
	}
	
}
