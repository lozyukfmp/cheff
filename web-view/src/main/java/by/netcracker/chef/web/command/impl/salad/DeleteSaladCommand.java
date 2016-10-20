package by.netcracker.chef.web.command.impl.salad;

import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.CommandName;
import by.netcracker.chef.web.command.CommandUtil;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class DeleteSaladCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        try {
            int saladId = Integer.parseInt(request.getParameter(CommandUtil.SALAD_ID));

            IService saladService = ServiceFactory.getInstance().getService(ServiceName.SALAD);
            saladService.deleteSalad(saladId);

            return CommandUtil.convertFromCommandName(CommandName.GET_INDEX_PAGE);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
