package by.netcracker.chef.web.command;

import by.netcracker.chef.web.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
}
