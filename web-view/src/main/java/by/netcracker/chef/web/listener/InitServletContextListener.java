package by.netcracker.chef.web.listener;

import by.netcracker.chef.pool.exception.ConnectionPoolException;
import by.netcracker.chef.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitServletContextListener implements ServletContextListener{

    private static Logger logger = LogManager.getLogger(InitServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            logger.trace("INITIALIZING CONNECTION POOL...");

            ConnectionPool.getInstance().initPoolData();

            logger.trace("CONNECTION POOL INITIALIZED SUCCESSFULLY.");
        } catch (ConnectionPoolException e) {
            logger.error("UNABLE TO INITIALIZE CONNECTION POOL", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            logger.trace("DESTROYING CONNECTION POOL...");

            ConnectionPool.getInstance().dispose();

            logger.trace("CONNECTION POOL DESTROYED.");
        } catch (ConnectionPoolException e) {
            logger.error("UNABLE TO DESTROY CONNECTION POOL", e);
        }
    }
}
