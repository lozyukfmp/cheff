package by.netcracker.chef.dao.impl;

import by.netcracker.chef.dao.IDao;
import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;

import java.util.List;

public class DefaultDao implements IDao {
    @Override
    public List<Menu> getMenuList() throws DaoException {
        return null;
    }

    @Override
    public List<Salad> getSaladList() throws DaoException {
        return null;
    }

    @Override
    public List<Vegetable> getVegetableList() throws DaoException {
        return null;
    }

    @Override
    public Menu getMenu(int menuId) throws DaoException {
        return null;
    }

    @Override
    public Salad getSalad(int saladId) throws DaoException {
        return null;
    }

    @Override
    public Vegetable getVegetable(int vegetableId) throws DaoException {
        return null;
    }

    @Override
    public Menu updateMenu(Menu menu) throws DaoException {
        return menu;
    }

    @Override
    public Salad updateSalad(Salad salad) throws DaoException {
        return salad;
    }

    @Override
    public Vegetable updateVegetable(Vegetable vegetable) throws DaoException {
        return vegetable;
    }

    @Override
    public void deleteMenu(int menuId) throws DaoException {

    }

    @Override
    public void deleteSalad(int saladId) throws DaoException {

    }

    @Override
    public void deleteVegetable(int vegetableId) throws DaoException {

    }

    @Override
    public Menu createMenu(Menu menu) throws DaoException {
        return null;
    }

    @Override
    public Salad createSalad(Salad salad) throws DaoException {
        return null;
    }

    @Override
    public Vegetable createVegetable(Vegetable vegetable) throws DaoException {
        return null;
    }
}
