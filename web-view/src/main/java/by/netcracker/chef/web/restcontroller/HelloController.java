package by.netcracker.chef.web.restcontroller;

import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping(value = {"/hello", "/"}, method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/menu/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Menu> getMenuList() throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.MENU);
        return service.getMenuList();
    }

    @RequestMapping(value ="menu/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  Menu getMenu(@PathVariable Integer id) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.MENU);
        return service.getMenu(id);
    }

    @RequestMapping(value ="salad/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Salad getSalad(@PathVariable Integer id) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.SALAD);
        return service.getSalad(id);
    }

    @RequestMapping(value ="vegetable/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Vegetable getVegetable(@PathVariable Integer id)  throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
        return service.getVegetable(id);
    }


    @RequestMapping(value = "/salad/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Salad> getSaladList() throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.SALAD);
        return service.getSaladList();
    }

    @RequestMapping(value = "/vegetable/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Vegetable> getVegetableList() throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
        return service.getVegetableList();
    }

    @RequestMapping(value ="/vegetable/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Vegetable editVegetable(@RequestBody Vegetable vegetable)  throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
        return service.updateVegetable(vegetable);
    }

    @RequestMapping(value = "/salad/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editSalad(@RequestBody Salad salad) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.SALAD);
        service.updateSalad(salad);
    }

    @RequestMapping(value = "/menu/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editMenu(@RequestBody Menu menu) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.MENU);
        service.updateMenu(menu);
    }

}
