package by.netcracker.chef.command.impl.menu;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.netcracker.chef.command.CommandUtil.*;

public class DeleteSaladFromMenuCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int saladId = Integer.parseInt(request.getParameter(SALAD_ID));
            System.out.println("SALAD ID : " + saladId);

            String menuName = request.getParameter(MENU_NAME);

            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);
            Salad salad = saladService.getSalad(saladId);
            List<Salad> menuSaladList = (List<Salad>) request.getSession().getAttribute(MENU_SALAD_LIST);
            menuSaladList.remove(salad);

            request.getSession().setAttribute(MENU_SALAD_LIST, menuSaladList);
            request.getSession().setAttribute(MENU_NAME, menuName);

            return (String) request.getSession().getAttribute(PATH);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
