package by.netcracker.chef.web.command.impl.menu;

import by.netcracker.chef.web.command.CommandName;
import by.netcracker.chef.web.command.CommandUtil;
import by.netcracker.chef.web.controller.PageUtil;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;
import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GetCreateMenuPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);
            List<Salad> saladList = saladService.getSaladList();

            Menu menu = request.getSession().getAttribute(CommandUtil.MENU) == null
                    ? new Menu()
                    : (Menu) request.getSession().getAttribute(CommandUtil.MENU);

            List<Salad> menuSaladList = request.getSession().getAttribute(CommandUtil.MENU_SALAD_LIST) == null
                    ? new ArrayList<>()
                    : (List<Salad>) request.getSession().getAttribute(CommandUtil.MENU_SALAD_LIST);

            request.getSession().setAttribute(CommandUtil.MENU, menu);
            request.getSession().setAttribute(CommandUtil.SALAD_LIST,
                    CommandUtil.formSaladList(menuSaladList, saladList));
            request.getSession().setAttribute(CommandUtil.MENU_SALAD_LIST, menuSaladList);
            request.getSession().setAttribute(CommandUtil.PATH,
                    CommandUtil.convertFromCommandName(CommandName.GET_CREATE_MENU_PAGE));

            return PageUtil.CREATE_MENU_PAGE;

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
