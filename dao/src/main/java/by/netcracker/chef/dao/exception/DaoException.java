package by.netcracker.chef.dao.exception;

public class DaoException extends Exception{
    public DaoException(String message, Exception exception) {
        super(message, exception);
    }

    public DaoException(Exception exception) {
        super(exception);
    }
}
