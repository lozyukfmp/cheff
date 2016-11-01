package by.netcracker.chef.service;

import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.service.exception.ServiceException;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuList() throws ServiceException;
    Menu getMenu(int menuId) throws ServiceException;
    Menu updateMenu(Menu menu) throws ServiceException;
    void deleteMenu(int menuId) throws ServiceException;
    Menu createMenu(Menu menu) throws ServiceException;
}
