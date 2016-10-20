package by.netcracker.chef.web.command.impl.vegetable;

import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.exception.CommandException;
import by.netcracker.chef.web.controller.PageUtil;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

import static by.netcracker.chef.web.command.CommandUtil.VEGETABLE;
import static by.netcracker.chef.web.command.CommandUtil.VEGETABLE_ID;

public class GetEditVegetablePageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            int vegetableId = Integer.parseInt(request.getParameter(VEGETABLE_ID));

            IService vegetableService = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
            Vegetable vegetable = vegetableService.getVegetable(vegetableId);

            request.getSession().setAttribute(VEGETABLE, vegetable);

            return PageUtil.EDIT_VEGETABLE_PAGE;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
