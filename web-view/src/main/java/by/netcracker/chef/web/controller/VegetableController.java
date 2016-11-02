package by.netcracker.chef.web.controller;

import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.VegetableService;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @RequestMapping(value = "/vegetable/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vegetable> getVegetableList() throws ServiceException {
        return vegetableService.getVegetableList();
    }

    @RequestMapping(value ="vegetable/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Vegetable getVegetable(@PathVariable Integer id)  throws ServiceException {
        return vegetableService.getVegetable(id);
    }

    @RequestMapping(value ="/vegetable/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vegetable editVegetable(@RequestBody Vegetable vegetable)  throws ServiceException {
        return vegetableService.updateVegetable(vegetable);
    }

    @RequestMapping(value ="/vegetable/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vegetable createVegetable(@RequestBody Vegetable vegetable)  throws ServiceException {
        return vegetableService.createVegetable(vegetable);
    }

    @RequestMapping(value ="/vegetable/delete/{id}", method = RequestMethod.POST)
    public void deleteVegetable(@PathVariable Integer id)  throws ServiceException {
        vegetableService.deleteVegetable(id);
    }
}
