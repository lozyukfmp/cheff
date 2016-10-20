package by.netcracker.chef.web.command.impl.salad;

import by.netcracker.chef.web.controller.PageUtil;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;
import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

import static by.netcracker.chef.web.command.CommandUtil.SALAD;
import static by.netcracker.chef.web.command.CommandUtil.SALAD_ID;

public class ShowSaladCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int saladId = Integer.parseInt(request.getParameter(SALAD_ID));

            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);
            Salad salad = saladService.getSalad(saladId);

            request.setAttribute(SALAD, salad);

            return PageUtil.SHOW_SALAD_PAGE;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
