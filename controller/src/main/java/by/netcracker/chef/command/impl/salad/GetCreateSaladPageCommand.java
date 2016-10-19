package by.netcracker.chef.command.impl.salad;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.CommandName;
import by.netcracker.chef.command.CommandUtil;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.controller.PageUtil;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static by.netcracker.chef.command.CommandUtil.*;

public class GetCreateSaladPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            IService vegetableDao = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
            List<Vegetable> vegetableList = vegetableDao.getVegetableList();

            Salad salad = request.getSession().getAttribute(SALAD) == null
                    ? new Salad()
                    : (Salad) request.getSession().getAttribute(SALAD);

            List<Vegetable> ingredientList = request.getSession().getAttribute(INGREDIENT_LIST) == null
                    ? new ArrayList<>()
                    : (List<Vegetable>) request.getSession().getAttribute(INGREDIENT_LIST);

            request.getSession().setAttribute(SALAD, salad);
            request.getSession().setAttribute(VEGETABLE_LIST,
                    CommandUtil.formVegetableList(ingredientList, vegetableList));
            request.getSession().setAttribute(INGREDIENT_LIST, ingredientList);
            request.getSession().setAttribute(PATH,
                    CommandUtil.convertFromCommandName(CommandName.GET_CREATE_SALAD_PAGE));

            return PageUtil.CREATE_SALAD_PAGE;

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
