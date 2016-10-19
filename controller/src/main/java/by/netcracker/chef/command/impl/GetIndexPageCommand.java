package by.netcracker.chef.command.impl;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.controller.PageUtil;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetIndexPageCommand implements Command {

    private static final String MENU_LIST = "menuList";
    private static final String SALAD_LIST = "saladList";
    private static final String VEGETABLE_LIST = "vegetableList";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            IService menuService = ServiceFactory.getInstance().getService(ServiceName.MENU);
            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);
            IService vegetableService = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);

            List<Menu> menuList = menuService.getMenuList();
            List<Salad> saladList = saladService.getSaladList();
            List<Vegetable> vegetableList = vegetableService.getVegetableList();

            request.setAttribute(MENU_LIST, menuList);
            request.setAttribute(SALAD_LIST, saladList);
            request.setAttribute(VEGETABLE_LIST, vegetableList);

            return PageUtil.INDEX_PAGE;

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
