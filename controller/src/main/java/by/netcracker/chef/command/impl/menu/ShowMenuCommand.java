package by.netcracker.chef.command.impl.menu;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.controller.PageUtil;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

import static by.netcracker.chef.command.CommandUtil.MENU;
import static by.netcracker.chef.command.CommandUtil.MENU_ID;

public class ShowMenuCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int menuId = Integer.parseInt(request.getParameter(MENU_ID));

            IService menuService = ServiceFactory.getInstance().getService(ServiceName.MENU);
            Menu menu = menuService.getMenu(menuId);

            request.setAttribute(MENU, menu);

            return PageUtil.SHOW_MENU_PAGE;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
