package by.netcracker.chef.service.impl;

import by.netcracker.chef.dao.VegetableDao;
import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.service.VegetableService;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    @Autowired
    private VegetableDao vegetableDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vegetable> getVegetableList() throws ServiceException {
        return vegetableDao.all();
    }

    @Override
    @Transactional(readOnly = true)
    public Vegetable getVegetable(int vegetableId) throws ServiceException {
        return vegetableDao.find(vegetableId);
    }

    @Override
    @Transactional
    public Vegetable updateVegetable(Vegetable vegetable) throws ServiceException {
        return vegetableDao.update(vegetable);
    }

    @Override
    @Transactional
    public void deleteVegetable(int vegetableId) throws ServiceException {
        vegetableDao.delete(vegetableId);
    }

    @Override
    @Transactional
    public Vegetable createVegetable(Vegetable vegetable) throws ServiceException {
        vegetableDao.create(vegetable);

        return vegetable;
    }
}
