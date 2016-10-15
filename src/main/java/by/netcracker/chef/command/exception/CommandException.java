package by.netcracker.chef.command.exception;

public class CommandException extends Exception{
    public CommandException(String message, Exception exception) {
        super(message, exception);
    }

    public CommandException(Exception e) {
        super(e);
    }
}
