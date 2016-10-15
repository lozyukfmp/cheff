package by.netcracker.chef.service;

import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.exception.ServiceException;

import java.util.List;

public interface IService {
    List<Menu> getMenuList() throws ServiceException;

    List<Salad> getSaladList() throws ServiceException;

    List<Vegetable> getVegetableList() throws ServiceException;

    Menu getMenu(int menuId) throws ServiceException;

    Salad getSalad(int saladId) throws ServiceException;

    Vegetable getVegetable(int vegetableId) throws ServiceException;

    void updateMenu(Menu menu) throws ServiceException;

    void updateSalad(Salad salad) throws ServiceException;

    void updateVegetable(Vegetable vegetable) throws ServiceException;

    void deleteMenu(int menuId) throws ServiceException;

    void deleteSalad(int saladId) throws ServiceException;

    void deleteVegetable(int vegetableId) throws ServiceException;

    Menu createMenu(Menu menu) throws ServiceException;

    Salad createSalad(Salad salad) throws ServiceException;

    Vegetable createVegetable(Vegetable vegetable) throws ServiceException;

    List<Salad> addSaladToMenu(Salad salad, List<Salad> saladList) throws ServiceException;

    List<Salad> deleteSaladFromMenu(Salad salad, List<Salad> saladList) throws ServiceException;

    List<Vegetable> addVegetableToSalad(Vegetable vegetable, List<Vegetable> vegetableList) throws ServiceException;

    List<Vegetable> deleteVegetableFromSalad(Vegetable vegetable, List<Vegetable> vegetableList) throws ServiceException;
}
