package by.netcracker.chef.web.restcontroller;

import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VegetableController {
    @RequestMapping(value = "/vegetable/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vegetable> getVegetableList() throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
        return service.getVegetableList();
    }

    @RequestMapping(value ="vegetable/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Vegetable getVegetable(@PathVariable Integer id)  throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
        return service.getVegetable(id);
    }

    @RequestMapping(value ="/vegetable/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vegetable editVegetable(@RequestBody Vegetable vegetable)  throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
        return service.updateVegetable(vegetable);
    }

    @RequestMapping(value ="/vegetable/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vegetable createVegetable(@RequestBody Vegetable vegetable)  throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
        return service.createVegetable(vegetable);
    }

    @RequestMapping(value ="/vegetable/delete/{id}", method = RequestMethod.POST)
    public void createVegetable(@PathVariable Integer id)  throws ServiceException {
        IService service = ServiceFactory.getInstance().getService(ServiceName.VEGETABLE);
        service.deleteVegetable(id);
    }
}
