package by.netcracker.chef.command.impl.menu;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.CommandName;
import by.netcracker.chef.command.CommandUtil;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.netcracker.chef.command.CommandUtil.MENU_NAME;
import static by.netcracker.chef.command.CommandUtil.MENU_SALAD_LIST;

public class CreateMenuCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            Menu menu = new Menu();
            menu.setName(request.getParameter(MENU_NAME));
            menu.setSaladList((List<Salad>) request.getSession().getAttribute(MENU_SALAD_LIST));

            IService menuService = ServiceFactory.getInstance().getService(ServiceName.MENU);

            menuService.createMenu(menu);

            CommandUtil.clearSession(request);

            return CommandUtil.convertFromCommandName(CommandName.GET_INDEX_PAGE);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}