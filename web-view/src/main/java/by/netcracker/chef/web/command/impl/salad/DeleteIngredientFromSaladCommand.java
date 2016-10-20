package by.netcracker.chef.web.command.impl.salad;

import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;
import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.netcracker.chef.web.command.CommandUtil.*;

public class DeleteIngredientFromSaladCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int vegetableId = Integer.parseInt(request.getParameter(VEGETABLE_ID));

            String saladName = request.getParameter(SALAD_NAME);

            IService vegetableService = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
            Vegetable vegetable = vegetableService.getVegetable(vegetableId);
            List<Vegetable> ingredientList = (List<Vegetable>) request.getSession().getAttribute(INGREDIENT_LIST);
            ingredientList.remove(vegetable);

            request.getSession().setAttribute(INGREDIENT_LIST, ingredientList);
            request.getSession().setAttribute(SALAD_NAME, saladName);

            return (String) request.getSession().getAttribute(PATH);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
