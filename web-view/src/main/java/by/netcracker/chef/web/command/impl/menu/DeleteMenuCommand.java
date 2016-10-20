package by.netcracker.chef.web.command.impl.menu;

import by.netcracker.chef.web.command.CommandName;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;
import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.CommandUtil;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

import static by.netcracker.chef.web.command.CommandUtil.MENU_ID;

public class DeleteMenuCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        try {
            int menuId = Integer.parseInt(request.getParameter(MENU_ID));

            IService menuService = ServiceFactory.getInstance().getService(ServiceName.MENU);
            menuService.deleteMenu(menuId);

            return CommandUtil.convertFromCommandName(CommandName.GET_INDEX_PAGE);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
