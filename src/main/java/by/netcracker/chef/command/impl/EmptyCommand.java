package by.netcracker.chef.command.impl;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.controller.PageUtil;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PageUtil.INDEX_PAGE;
    }
}
