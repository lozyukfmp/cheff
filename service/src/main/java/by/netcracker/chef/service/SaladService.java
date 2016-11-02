package by.netcracker.chef.service;

import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.exception.ServiceException;

import java.util.List;

public interface SaladService {
    List<Salad> getSaladList() throws ServiceException;
    Salad getSalad(int saladId) throws ServiceException;
    Salad getSaladWithVegetables(int saladId) throws ServiceException;
    Salad updateSalad(Salad salad) throws ServiceException;
    void deleteSalad(int saladId) throws ServiceException;
    Salad createSalad(Salad salad) throws ServiceException;
}
