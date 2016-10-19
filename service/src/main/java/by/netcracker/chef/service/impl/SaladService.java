package by.netcracker.chef.service.impl;

import by.netcracker.chef.dao.DaoFactory;
import by.netcracker.chef.dao.DaoName;
import by.netcracker.chef.dao.IDao;
import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.exception.ServiceException;

import java.util.List;

public class SaladService extends DefaultService {
    @Override
    public List<Salad> getSaladList() throws ServiceException {
        try {
            IDao saladDao = DaoFactory.getInstance().getDao(DaoName.SALAD);

            return saladDao.getSaladList();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Salad getSalad(int saladId) throws ServiceException {
        try {
            IDao saladDao = DaoFactory.getInstance().getDao(DaoName.SALAD);

            return saladDao.getSalad(saladId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateSalad(Salad salad) throws ServiceException {
        try {
            IDao saladDao = DaoFactory.getInstance().getDao(DaoName.SALAD);

            saladDao.updateSalad(salad);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteSalad(int saladId) throws ServiceException {
        try {
            IDao saladDao = DaoFactory.getInstance().getDao(DaoName.SALAD);

            saladDao.deleteSalad(saladId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Salad createSalad(Salad salad) throws ServiceException {
        try {
            IDao saladDao = DaoFactory.getInstance().getDao(DaoName.SALAD);

            return saladDao.createSalad(salad);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Vegetable> addVegetableToSalad(Vegetable vegetable, List<Vegetable> vegetableList) throws ServiceException {
        vegetableList.add(vegetable);

        return vegetableList;
    }

    @Override
    public List<Vegetable> deleteVegetableFromSalad(Vegetable vegetable, List<Vegetable> vegetableList) throws ServiceException {
        vegetableList.remove(vegetable);

        return vegetableList;
    }
}
