package by.netcracker.chef.web.command.impl.vegetable;

import by.netcracker.chef.web.command.CommandName;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;
import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.CommandUtil;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.service.IService;

import javax.servlet.http.HttpServletRequest;

import static by.netcracker.chef.web.command.CommandUtil.*;

public class CreateVegetableCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            Vegetable vegetable = new Vegetable();

            vegetable.setName(request.getParameter(VEGETABLE_NAME));
            vegetable.setCalories(Double.parseDouble(request.getParameter(VEGETABLE_CALORIES)));
            vegetable.setFats(Double.parseDouble(request.getParameter(VEGETABLE_FATS)));
            vegetable.setProteins(Double.parseDouble(request.getParameter(VEGETABLE_PROTEINS)));
            vegetable.setCarbohydrates(Double.parseDouble(request.getParameter(VEGETABLE_CARBOHYDRATES)));

            IService vegetableService = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
            vegetableService.createVegetable(vegetable);

            return CommandUtil.convertFromCommandName(CommandName.GET_INDEX_PAGE);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
