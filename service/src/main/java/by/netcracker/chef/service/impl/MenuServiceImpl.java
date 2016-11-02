package by.netcracker.chef.service.impl;

import by.netcracker.chef.dao.MenuDao;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.service.MenuService;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    @Transactional(readOnly = true)
    public List<Menu> getMenuList() throws ServiceException {
        return menuDao.all();
    }

    @Override
    @Transactional(readOnly = true)
    public Menu getMenuWithSalads(int menuId) throws ServiceException {
        return menuDao.findWithSalads(menuId);
    }

    @Override
    @Transactional(readOnly = true)
    public Menu getMenu(int menuId) throws ServiceException {
        Menu menu = menuDao.find(menuId);
        menu.setSaladList(Collections.EMPTY_LIST);

        return menu;
    }

    @Override
    @Transactional
    public void updateMenu(Menu menu) throws ServiceException {
        menuDao.update(menu);
    }

    @Override
    @Transactional
    public void deleteMenu(int menuId) throws ServiceException {
        menuDao.delete(menuId);
    }

    @Override
    @Transactional
    public Menu createMenu(Menu menu) throws ServiceException {
        menuDao.create(menu);

        return menu;
    }
}
