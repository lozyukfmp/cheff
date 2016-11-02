package by.netcracker.chef.web.controller;

import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.SaladService;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaladController {

    @Autowired
    private SaladService saladService;

    @RequestMapping(value = "/salad/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Salad> getSaladList() throws ServiceException {
        return saladService.getSaladList();
    }

    @RequestMapping(value ="salad/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Salad getSalad(@PathVariable Integer id) throws ServiceException {
        return saladService.getSaladWithVegetables(id);
    }

    @RequestMapping(value = "/salad/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Salad editSalad(@RequestBody Salad salad) throws ServiceException {
        return saladService.updateSalad(salad);
    }

    @RequestMapping(value = "/salad/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Salad createSalad(@RequestBody Salad salad) throws ServiceException {
        return saladService.createSalad(salad);
    }

    @RequestMapping(value = "/salad/delete/{id}", method = RequestMethod.POST)
    public void deleteSalad(@PathVariable Integer id) throws ServiceException {
        saladService.deleteSalad(id);
    }

}
