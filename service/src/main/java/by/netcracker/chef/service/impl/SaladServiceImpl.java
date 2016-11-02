package by.netcracker.chef.service.impl;

import by.netcracker.chef.dao.SaladDao;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.service.SaladService;
import by.netcracker.chef.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaladServiceImpl implements SaladService {

    @Autowired
    private SaladDao saladDao;

    @Override
    @Transactional(readOnly = true)
    public List<Salad> getSaladList() throws ServiceException {
        return saladDao.all();
    }

    @Override
    public Salad getSaladWithVegetables(int saladId) throws ServiceException {
        return saladDao.findWithVegetables(saladId);
    }

    @Override
    @Transactional(readOnly = true)
    public Salad getSalad(int saladId) throws ServiceException {
        return saladDao.find(saladId);
    }

    @Override
    @Transactional
    public Salad updateSalad(Salad salad) throws ServiceException {
        return saladDao.update(salad);
    }

    @Override
    @Transactional
    public void deleteSalad(int saladId) throws ServiceException {
        saladDao.delete(saladId);
    }

    @Override
    @Transactional
    public Salad createSalad(Salad salad) throws ServiceException {
        saladDao.create(salad);

        return salad;
    }
}
