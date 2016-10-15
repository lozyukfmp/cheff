package by.netcracker.chef.dao;

import by.netcracker.chef.dao.impl.MenuDao;
import by.netcracker.chef.dao.impl.SaladDao;
import by.netcracker.chef.dao.impl.VegetableDao;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {
    private static volatile DaoFactory instance = null;

    private Map<DaoName, IDao> daos = null;

    private DaoFactory() {
        daos = new HashMap<>();
        daos.put(DaoName.MENU, new MenuDao());
        daos.put(DaoName.SALAD, new SaladDao());
        daos.put(DaoName.VEGETABLE, new VegetableDao());
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            synchronized (DaoFactory.class) {
                if (instance == null) {
                    instance = new DaoFactory();
                } else {
                    return instance;
                }
            }
        }

        return instance;
    }

    public IDao getDao(DaoName daoName) {
        return daos.get(daoName);
    }
}
