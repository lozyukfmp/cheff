package by.netcracker.chef.dao;

import by.netcracker.chef.entity.Salad;

public interface SaladDao extends GenericDao<Salad, Integer> {
    Salad findWithVegetables(Integer id);
}
