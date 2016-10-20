package by.netcracker.chef.service.impl;

import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.exception.ServiceException;
import by.netcracker.chef.dao.DaoFactory;
import by.netcracker.chef.dao.DaoName;
import by.netcracker.chef.dao.IDao;

import java.util.List;

public class MenuService extends DefaultService {
    @Override
    public List<Menu> getMenuList() throws ServiceException {
        try {
            IDao menuDao = DaoFactory.getInstance().getDao(DaoName.MENU);

            return menuDao.getMenuList();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Menu getMenu(int menuId) throws ServiceException {
        try {
            IDao menuDao = DaoFactory.getInstance().getDao(DaoName.MENU);

            return menuDao.getMenu(menuId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateMenu(Menu menu) throws ServiceException {
        try {
            IDao menuDao = DaoFactory.getInstance().getDao(DaoName.MENU);

            menuDao.updateMenu(menu);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteMenu(int menuId) throws ServiceException {
        try {
            IDao menuDao = DaoFactory.getInstance().getDao(DaoName.MENU);

            menuDao.deleteMenu(menuId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Menu createMenu(Menu menu) throws ServiceException {
        try {
            IDao menuDao = DaoFactory.getInstance().getDao(DaoName.MENU);

            return menuDao.createMenu(menu);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Salad> addSaladToMenu(Salad salad, List<Salad> saladList) throws ServiceException {
        saladList.add(salad);

        return saladList;
    }

    @Override
    public List<Salad> deleteSaladFromMenu(Salad salad, List<Salad> saladList) throws ServiceException {
        saladList.remove(salad);

        return saladList;
    }
}
