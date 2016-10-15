package by.netcracker.chef.dao.exception;

public class DuplicateNameException extends DaoException {
    public DuplicateNameException(String message, Exception exception) {
        super(message, exception);
    }

    public DuplicateNameException(Exception exception) {
        super(exception);
    }
}
