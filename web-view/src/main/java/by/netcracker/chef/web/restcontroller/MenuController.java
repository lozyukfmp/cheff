package by.netcracker.chef.web.restcontroller;

import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @RequestMapping(value = "/menu/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getMenuList() throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.MENU);
        return service.getMenuList();
    }

    @RequestMapping(value ="menu/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public  Menu getMenu(@PathVariable Integer id) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.MENU);
        return service.getMenu(id);
    }

    @RequestMapping(value = "/menu/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Menu createMenu(@RequestBody Menu menu) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.MENU);
        return service.createMenu(menu);
    }

    @RequestMapping(value = "/menu/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu editMenu(@RequestBody Menu menu) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.MENU);
        return service.updateMenu(menu);
    }

    @RequestMapping(value = "/menu/delete/{id}", method = RequestMethod.POST)
    public void createMenu(@PathVariable Integer id) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.MENU);
        service.deleteMenu(id);
    }
}
