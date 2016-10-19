package by.netcracker.chef.command;

import by.netcracker.chef.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
}
