package by.netcracker.chef.web.controller;

import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.service.MenuService;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menu/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getMenuList() throws ServiceException {
        return menuService.getMenuList();
    }

    @RequestMapping(value ="menu/show/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu getMenu(@PathVariable Integer id) throws ServiceException {
        return menuService.getMenuWithSalads(id);
    }

    @RequestMapping(value = "/menu/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu createMenu(@RequestBody Menu menu) throws ServiceException {
        return menuService.createMenu(menu);
    }

    @RequestMapping(value = "/menu/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Menu editMenu(@RequestBody Menu menu) throws ServiceException {
        menuService.updateMenu(menu);
        return menu;
    }

    @RequestMapping(value = "/menu/delete/{id}", method = RequestMethod.POST)
    public void deleteMenu(@PathVariable Integer id) throws ServiceException {
        menuService.deleteMenu(id);
    }
}
