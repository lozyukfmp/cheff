package by.netcracker.chef.dao;

import by.netcracker.chef.entity.Menu;

public interface MenuDao extends GenericDao<Menu> {
    Menu findWithSalads(Integer id);
}
