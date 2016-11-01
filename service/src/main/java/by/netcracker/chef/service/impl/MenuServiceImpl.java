package by.netcracker.chef.service.impl;

import by.netcracker.chef.dao.MenuDao;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.service.MenuService;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenuList() throws ServiceException {
        return menuDao.all();
    }

    @Override
    public Menu getMenu(int menuId) throws ServiceException {
        return menuDao.find(menuId);
    }

    @Override
    public Menu updateMenu(Menu menu) throws ServiceException {
        return menuDao.update(menu);
    }

    @Override
    public void deleteMenu(int menuId) throws ServiceException {
        menuDao.delete(menuId);
    }

    @Override
    public Menu createMenu(Menu menu) throws ServiceException {
        menuDao.create(menu);

        return menu;
    }
}
