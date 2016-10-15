package by.netcracker.chef.command.impl.menu;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.CommandName;
import by.netcracker.chef.command.CommandUtil;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.controller.PageUtil;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.netcracker.chef.command.CommandUtil.*;

public class GetEditMenuPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int menuId = request.getParameter(MENU_ID) == null ?
                    (Integer) request.getSession().getAttribute(MENU_ID) :
                    Integer.parseInt(request.getParameter(MENU_ID));

            IService menuService = ServiceFactory.getInstance().getService(ServiceName.MENU);
            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);

            List<Salad> saladList = saladService.getSaladList();
            Menu menu = menuService.getMenu(menuId);
            List<Salad> menuSaladList = request.getSession().getAttribute(MENU_SALAD_LIST) == null
                    ? menu.getSaladList()
                    : (List<Salad>) request.getSession().getAttribute(MENU_SALAD_LIST);

            request.getSession().setAttribute(MENU, menu);
            request.getSession().setAttribute(MENU_ID, menuId);

            request.getSession().setAttribute(MENU_SALAD_LIST, menuSaladList);
            request.getSession().setAttribute(SALAD_LIST,
                    CommandUtil.formSaladList(menuSaladList, saladList));
            request.getSession().setAttribute(PATH,
                    CommandUtil.convertFromCommandName(CommandName.GET_EDIT_MENU_PAGE));

            return PageUtil.EDIT_MENU_PAGE;

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
