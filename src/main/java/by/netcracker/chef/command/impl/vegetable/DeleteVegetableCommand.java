package by.netcracker.chef.command.impl.vegetable;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.CommandName;
import by.netcracker.chef.command.CommandUtil;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

import static by.netcracker.chef.command.CommandUtil.VEGETABLE_ID;

public class DeleteVegetableCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int vegetableId = Integer.parseInt(request.getParameter(VEGETABLE_ID));
            IService vegetableService = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
            vegetableService.deleteVegetable(vegetableId);

            return CommandUtil.convertFromCommandName(CommandName.GET_INDEX_PAGE);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
