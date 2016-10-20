package by.netcracker.chef.web.command.impl.menu;

import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.CommandUtil;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.web.controller.PageUtil;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ShowMenuCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int menuId = Integer.parseInt(request.getParameter(CommandUtil.MENU_ID));

            IService menuService = ServiceFactory.getInstance().getService(ServiceName.MENU);
            Menu menu = menuService.getMenu(menuId);

            request.setAttribute(CommandUtil.MENU, menu);

            return PageUtil.SHOW_MENU_PAGE;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
