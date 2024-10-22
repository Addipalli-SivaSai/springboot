package ltts.com.Exception;

import org.springframework.http.HttpStatusCode;

public class ProductNotFoundException extends RuntimeException  {
	
	public ProductNotFoundException(String message)
	{
	    super(message);
	}

}
