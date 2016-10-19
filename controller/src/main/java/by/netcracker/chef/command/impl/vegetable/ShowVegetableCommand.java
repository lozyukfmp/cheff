package by.netcracker.chef.command.impl.vegetable;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.CommandUtil;
import by.netcracker.chef.command.exception.CommandException;
import by.netcracker.chef.controller.PageUtil;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ShowVegetableCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int vegetableId = Integer.parseInt(request.getParameter(CommandUtil.VEGETABLE_ID));

            IService vegetableService = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);

            Vegetable vegetable = vegetableService.getVegetable(vegetableId);
            request.setAttribute(CommandUtil.VEGETABLE, vegetable);

            return PageUtil.SHOW_VEGETABLE_PAGE;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
