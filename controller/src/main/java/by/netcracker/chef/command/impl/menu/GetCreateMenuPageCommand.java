package by.netcracker.chef.command.impl.menu;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.CommandName;
import by.netcracker.chef.command.CommandUtil;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.controller.PageUtil;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static by.netcracker.chef.command.CommandUtil.*;

public class GetCreateMenuPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);
            List<Salad> saladList = saladService.getSaladList();

            Menu menu = request.getSession().getAttribute(MENU) == null
                    ? new Menu()
                    : (Menu) request.getSession().getAttribute(MENU);

            List<Salad> menuSaladList = request.getSession().getAttribute(MENU_SALAD_LIST) == null
                    ? new ArrayList<>()
                    : (List<Salad>) request.getSession().getAttribute(MENU_SALAD_LIST);

            request.getSession().setAttribute(MENU, menu);
            request.getSession().setAttribute(SALAD_LIST,
                    CommandUtil.formSaladList(menuSaladList, saladList));
            request.getSession().setAttribute(MENU_SALAD_LIST, menuSaladList);
            request.getSession().setAttribute(PATH,
                    CommandUtil.convertFromCommandName(CommandName.GET_CREATE_MENU_PAGE));

            return PageUtil.CREATE_MENU_PAGE;

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
