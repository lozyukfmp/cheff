package by.netcracker.chef.service.exception;

public class ServiceException extends Exception{
    public ServiceException(String message, Exception exception) {
        super(message, exception);
    }

    public ServiceException(Exception exception) {
        super(exception);
    }
}
