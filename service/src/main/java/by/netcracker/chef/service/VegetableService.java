package by.netcracker.chef.service;

import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.exception.ServiceException;

import java.util.List;

public interface VegetableService {
    List<Vegetable> getVegetableList() throws ServiceException;
    Vegetable getVegetable(int vegetableId) throws ServiceException;
    Vegetable updateVegetable(Vegetable vegetable) throws ServiceException;
    void deleteVegetable(int vegetableId) throws ServiceException;
    Vegetable createVegetable(Vegetable vegetable) throws ServiceException;
}
