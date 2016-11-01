package by.netcracker.chef.web.restcontroller;

import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.ServiceFactory;
import by.netcracker.chef.service.ServiceName;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaladController {

    @RequestMapping(value = "/salad/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Salad> getSaladList() throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.SALAD);
        return service.getSaladList();
    }

    @RequestMapping(value ="salad/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Salad getSalad(@PathVariable Integer id) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.SALAD);
        return service.getSalad(id);
    }

    @RequestMapping(value = "/salad/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Salad editSalad(@RequestBody Salad salad) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.SALAD);
        return service.updateSalad(salad);
    }

    @RequestMapping(value = "/salad/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Salad createSalad(@RequestBody Salad salad) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.SALAD);
        return service.createSalad(salad);
    }

    @RequestMapping(value = "/salad/delete/{id}", method = RequestMethod.POST)
    public void createSalad(@PathVariable Integer id) throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.SALAD);
        service.deleteSalad(id);
    }

}
