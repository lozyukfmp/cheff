package by.netcracker.chef.web.command.impl.vegetable;

import by.netcracker.chef.web.command.CommandUtil;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.web.controller.PageUtil;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.web.command.Command;

import javax.servlet.http.HttpServletRequest;

public class GetCreateVegetablePageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        Vegetable vegetable = new Vegetable();

        request.setAttribute(CommandUtil.VEGETABLE, vegetable);

        return PageUtil.CREATE_VEGETABLE_PAGE;
    }
}
