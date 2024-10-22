package ltts.com.Exception;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice

public class GlobalExceptionHandler {
	  @ExceptionHandler(ProductNotFoundException.class)
	    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ProductNotFoundException exception,
	                                                                        WebRequest webRequest){
		  ErrorMessage errorDetails = new ErrorMessage(LocalDate.now(), exception.getMessage(),webRequest.getDescription(true));
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	

}
