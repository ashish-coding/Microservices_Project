package ac.java.UserService.exceptions;

public class ResourceNotFoundCustomException extends RuntimeException{
	
	public ResourceNotFoundCustomException() {
		super("resource not found in database");
	}
	
	public ResourceNotFoundCustomException(String message) {
		super(message);
	}
}
