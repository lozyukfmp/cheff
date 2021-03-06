package by.netcracker.chef.web.command.impl.salad;

import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.netcracker.chef.web.command.CommandUtil.INGREDIENT_LIST;
import static by.netcracker.chef.web.command.CommandUtil.PATH;
import static by.netcracker.chef.web.command.CommandUtil.VEGETABLE_ID;

public class AddIngredientToSaladCommand implements Command {



    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int vegetableId = Integer.parseInt(request.getParameter(VEGETABLE_ID));

            IService vegetableService = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
            Vegetable vegetable = vegetableService.getVegetable(vegetableId);

            List<Vegetable> ingredientList = (List<Vegetable>) request.getSession().getAttribute(INGREDIENT_LIST);
            ingredientList.add(vegetable);

            request.getSession().setAttribute(INGREDIENT_LIST, ingredientList);

            return (String) request.getSession().getAttribute(PATH);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
