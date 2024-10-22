package ltts.com.Exception;

import java.sql.Date;
import java.time.LocalDate;

public class ErrorMessage {
	  private LocalDate timestamp;
	    private String message;
	    private String details;

	    public ErrorMessage(LocalDate timestamp, String message, String details) {
	        this.timestamp = timestamp;
	        this.message = message;
	        this.details = details;
	    }

	    public LocalDate getTimestamp() {
	        return timestamp;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public String getDetails() {
	        return details;
	    }

}
