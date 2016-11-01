package by.netcracker.chef.dao;

import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;

import java.util.List;

public interface IDao {
    List<Menu> getMenuList() throws DaoException;

    List<Salad> getSaladList() throws DaoException;

    List<Vegetable> getVegetableList() throws DaoException;

    Menu getMenu(int menuId) throws DaoException;

    Salad getSalad(int saladId) throws DaoException;

    Vegetable getVegetable(int vegetableId) throws DaoException;

    Menu updateMenu(Menu menu) throws DaoException;

    Salad updateSalad(Salad salad) throws DaoException;

    Vegetable updateVegetable(Vegetable vegetable) throws DaoException;

    void deleteMenu(int menuId) throws DaoException;

    void deleteSalad(int saladId) throws DaoException;

    void deleteVegetable(int vegetableId) throws DaoException;

    Menu createMenu(Menu menu) throws DaoException;

    Salad createSalad(Salad salad) throws DaoException;

    Vegetable createVegetable(Vegetable vegetable) throws DaoException;
}
