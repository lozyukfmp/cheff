package by.netcracker.chef.service;

import by.netcracker.chef.service.impl.MenuService;
import by.netcracker.chef.service.impl.SaladService;
import by.netcracker.chef.service.impl.VegetableService;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static volatile ServiceFactory instance = null;

    private Map<ServiceName, IService> services = null;

    private ServiceFactory() {
        services = new HashMap<>();
        services.put(ServiceName.MENU, new MenuService());
        services.put(ServiceName.SALAD, new SaladService());
        services.put(ServiceName.VEGETABLE, new VegetableService());
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            synchronized (ServiceFactory.class) {
                if (instance == null) {
                    instance = new ServiceFactory();
                } else {
                    return instance;
                }
            }
        }

        return instance;
    }

    public IService getService(ServiceName daoName) {
        return services.get(daoName);
    }
}
