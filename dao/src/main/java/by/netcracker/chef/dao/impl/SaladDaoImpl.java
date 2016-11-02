package by.netcracker.chef.dao.impl;

import by.netcracker.chef.dao.SaladDao;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class SaladDaoImpl extends GenericDaoImpl<Salad, Integer> implements SaladDao {

    @Override
    public Salad findWithVegetables(Integer id) {
        Salad salad = entityManager.createNamedQuery("Salad.findByIdWithVegetables", Salad.class)
                .setParameter("id", id)
                .getSingleResult();

        return salad;
    }

    @Override
    public List<Salad> all() {
        List<Salad> result = entityManager.createNamedQuery("Salad.findAll", Salad.class)
                .getResultList();
        result.forEach(salad -> salad.setIngredients(Collections.EMPTY_LIST));

        return result;
    }
}
