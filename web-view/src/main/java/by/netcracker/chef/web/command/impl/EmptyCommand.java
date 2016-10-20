package by.netcracker.chef.web.command.impl;

import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.web.controller.PageUtil;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PageUtil.INDEX_PAGE;
    }
}
