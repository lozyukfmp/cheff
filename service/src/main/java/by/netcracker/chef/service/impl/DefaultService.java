package by.netcracker.chef.service.impl;

import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.IService;
import by.netcracker.chef.service.exception.ServiceException;

import java.util.List;

public class DefaultService implements IService {
    @Override
    public List<Menu> getMenuList() throws ServiceException {
        return null;
    }

    @Override
    public List<Salad> getSaladList() throws ServiceException {
        return null;
    }

    @Override
    public List<Vegetable> getVegetableList() throws ServiceException {
        return null;
    }

    @Override
    public Menu getMenu(int menuId) throws ServiceException {
        return null;
    }

    @Override
    public Salad getSalad(int saladId) throws ServiceException {
        return null;
    }

    @Override
    public Vegetable getVegetable(int vegetableId) throws ServiceException {
        return null;
    }

    @Override
    public Menu updateMenu(Menu menu) throws ServiceException {
        return menu;
    }

    @Override
    public Salad updateSalad(Salad salad) throws ServiceException {
        return salad;
    }

    @Override
    public Vegetable updateVegetable(Vegetable vegetable) throws ServiceException {
        return vegetable;
    }

    @Override
    public void deleteMenu(int menuId) throws ServiceException {

    }

    @Override
    public void deleteSalad(int saladId) throws ServiceException {

    }

    @Override
    public void deleteVegetable(int vegetableId) throws ServiceException {

    }

    @Override
    public Menu createMenu(Menu menu) throws ServiceException {
        return null;
    }

    @Override
    public Salad createSalad(Salad salad) throws ServiceException {
        return null;
    }

    @Override
    public Vegetable createVegetable(Vegetable vegetable) throws ServiceException {
        return null;
    }

    @Override
    public List<Salad> addSaladToMenu(Salad salad, List<Salad> saladList) throws ServiceException {
        return null;
    }

    @Override
    public List<Salad> deleteSaladFromMenu(Salad salad, List<Salad> saladList) throws ServiceException {
        return null;
    }

    @Override
    public List<Vegetable> addVegetableToSalad(Vegetable vegetable, List<Vegetable> vegetableList) throws ServiceException {
        return null;
    }

    @Override
    public List<Vegetable> deleteVegetableFromSalad(Vegetable vegetable, List<Vegetable> vegetableList) throws ServiceException {
        return null;
    }
}
