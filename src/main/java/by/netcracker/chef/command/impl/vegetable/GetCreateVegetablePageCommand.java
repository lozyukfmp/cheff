package by.netcracker.chef.command.impl.vegetable;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.controller.PageUtil;
import by.netcracker.chef.entity.Vegetable;

import javax.servlet.http.HttpServletRequest;

import static by.netcracker.chef.command.CommandUtil.VEGETABLE;

public class GetCreateVegetablePageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        Vegetable vegetable = new Vegetable();

        request.setAttribute(VEGETABLE, vegetable);

        return PageUtil.CREATE_VEGETABLE_PAGE;
    }
}
