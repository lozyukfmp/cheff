package by.netcracker.chef.dao.impl;

import by.netcracker.chef.dao.MenuDao;
import by.netcracker.chef.entity.Menu;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class MenuDaoImpl extends GenericDaoImpl<Menu, Integer> implements MenuDao {

    @Override
    public Menu findWithSalads(Integer id) {
        Menu menu = entityManager.createNamedQuery("Menu.findByIdWithSalads", Menu.class)
                .setParameter("id", id)
                .getSingleResult();

        menu.getSaladList().forEach(salad -> salad.setIngredients(Collections.EMPTY_LIST));

        return menu;
    }

    @Override
    public List<Menu> all() {
        List<Menu> result = entityManager.createNamedQuery("Menu.findAll", Menu.class)
                .getResultList();
        result.forEach(menu -> menu.setSaladList(Collections.EMPTY_LIST));

        return result;
    }

}
