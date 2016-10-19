package by.netcracker.chef.command.impl.salad;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.CommandName;
import by.netcracker.chef.command.CommandUtil;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.netcracker.chef.command.CommandUtil.INGREDIENT_LIST;
import static by.netcracker.chef.command.CommandUtil.SALAD_NAME;

public class CreateSaladCommand implements Command {



    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            Salad salad = new Salad();
            salad.setName(request.getParameter(SALAD_NAME));
            salad.setIngredients((List<Vegetable>) request.getSession().getAttribute(INGREDIENT_LIST));

            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);

            saladService.createSalad(salad);

            CommandUtil.clearSession(request);

            return CommandUtil.convertFromCommandName(CommandName.GET_INDEX_PAGE);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
