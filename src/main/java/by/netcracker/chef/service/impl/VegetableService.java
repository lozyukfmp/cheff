package by.netcracker.chef.service.impl;

import by.netcracker.chef.dao.DaoFactory;
import by.netcracker.chef.dao.DaoName;
import by.netcracker.chef.dao.IDao;
import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.exception.ServiceException;

import java.util.List;

public class VegetableService extends DefaultService {
    @Override
    public List<Vegetable> getVegetableList() throws ServiceException {
        try {
            IDao vegetableDao = DaoFactory.getInstance().getDao(DaoName.VEGETABLE);

            return vegetableDao.getVegetableList();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Vegetable getVegetable(int vegetableId) throws ServiceException {
        try {
            IDao vegetableDao = DaoFactory.getInstance().getDao(DaoName.VEGETABLE);

            return vegetableDao.getVegetable(vegetableId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateVegetable(Vegetable vegetable) throws ServiceException {
        try {
            IDao vegetableDao = DaoFactory.getInstance().getDao(DaoName.VEGETABLE);

            vegetableDao.updateVegetable(vegetable);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteVegetable(int vegetableId) throws ServiceException {
        try {
            IDao vegetableDao = DaoFactory.getInstance().getDao(DaoName.VEGETABLE);

            vegetableDao.deleteVegetable(vegetableId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Vegetable createVegetable(Vegetable vegetable) throws ServiceException {
        try {
            IDao vegetableDao = DaoFactory.getInstance().getDao(DaoName.VEGETABLE);

            return vegetableDao.createVegetable(vegetable);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
