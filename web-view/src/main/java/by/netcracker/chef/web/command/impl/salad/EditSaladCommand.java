package by.netcracker.chef.web.command.impl.salad;

import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;
import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.CommandName;
import by.netcracker.chef.web.command.CommandUtil;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.netcracker.chef.web.command.CommandUtil.INGREDIENT_LIST;
import static by.netcracker.chef.web.command.CommandUtil.SALAD_ID;
import static by.netcracker.chef.web.command.CommandUtil.SALAD_NAME;

public class EditSaladCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            Salad salad = new Salad();
            salad.setId(Integer.parseInt(request.getParameter(SALAD_ID)));
            salad.setName(request.getParameter(SALAD_NAME));
            salad.setIngredients((List<Vegetable>) request.getSession().getAttribute(INGREDIENT_LIST));

            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);

            saladService.updateSalad(salad);

            CommandUtil.clearSession(request);

            return CommandUtil.convertFromCommandName(CommandName.GET_INDEX_PAGE);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
