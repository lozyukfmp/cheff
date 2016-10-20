package by.netcracker.chef.dao.impl;

import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Menu;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.pool.exception.ConnectionPoolException;
import by.netcracker.chef.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDao extends DefaultDao{

    private static final String GET_MENU_LIST_QUERY = "SELECT * FROM MENU";
    private static final String GET_MENU_QUERY = "SELECT MENU_ID, MENU_NAME FROM MENU " +
            "WHERE MENU_ID = ?";
    private static final String GET_SALAD_LIST_QUERY = "SELECT SALAD.SALAD_ID, SALAD_NAME FROM MENU_M2M_SALAD " +
            "JOIN SALAD ON MENU_M2M_SALAD.SALAD_ID = SALAD.SALAD_ID WHERE MENU_ID = ?";
    private static final String UPDATE_MENU_QUERY = "UPDATE MENU SET MENU_NAME = ? WHERE MENU_ID = ?";
    private static final String DELETE_SALAD_QUERY = "DELETE FROM MENU_M2M_SALAD WHERE MENU_ID = ?";
    private static final String ADD_SALAD_QUERY = "INSERT INTO MENU_M2M_SALAD VALUES (?, ?)";
    private static final String DELETE_MENU_QUERY = "DELETE FROM MENU WHERE MENU_ID = ?";
    private static final String CREATE_MENU_QUERY = "INSERT INTO MENU VALUES(NULL,?)";

    @Override
    public List<Menu> getMenuList() throws DaoException {
        List<Menu> menuList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(GET_MENU_LIST_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Menu menu = new Menu();
                menu.setId(resultSet.getInt(1));
                menu.setName(resultSet.getString(2));

                menuList.add(menu);
            }

        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ConnectionPool.getInstance().closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DaoException(e);
            }
        }

        return menuList;
    }

    @Override
    public Menu getMenu(int menuId) throws DaoException {
        Menu menu = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(GET_MENU_QUERY);
            statement.setInt(1, menuId);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                menu = new Menu();
                menu.setId(resultSet.getInt(1));
                menu.setName(resultSet.getString(2));
            }

            List<Salad> saladList = new ArrayList<>();

            statement = connection.prepareStatement(GET_SALAD_LIST_QUERY);
            statement.setInt(1, menuId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Salad salad = new Salad();
                salad.setId(resultSet.getInt(1));
                salad.setName(resultSet.getString(2));

                saladList.add(salad);
            }

            menu.setSaladList(saladList);

        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ConnectionPool.getInstance().closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DaoException(e);
            }
        }

        return menu;
    }

    @Override
    public void updateMenu(Menu menu) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(UPDATE_MENU_QUERY);
            statement.setString(1, menu.getName());
            statement.setInt(2, menu.getId());

            statement.executeUpdate();

            statement = connection.prepareStatement(DELETE_SALAD_QUERY);
            statement.setInt(1, menu.getId());

            statement.execute();

            statement = connection.prepareStatement(ADD_SALAD_QUERY);

            for (Salad salad : menu.getSaladList()) {
                statement.setInt(1, menu.getId());
                statement.setInt(2, salad.getId());

                statement.execute();
            }

        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ConnectionPool.getInstance().closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public void deleteMenu(int menuId) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(DELETE_SALAD_QUERY);
            statement.setInt(1, menuId);

            statement.executeUpdate();

            statement = connection.prepareStatement(DELETE_MENU_QUERY);
            statement.setInt(1, menuId);

            statement.executeUpdate();

        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ConnectionPool.getInstance().closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public Menu createMenu(Menu menu) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(CREATE_MENU_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, menu.getName());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                menu.setId(rs.getInt(1));
            }

            statement = connection.prepareStatement(ADD_SALAD_QUERY);
            for (Salad salad : menu.getSaladList()) {
                statement.setInt(1, menu.getId());
                statement.setInt(2, salad.getId());

                statement.execute();
            }

        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ConnectionPool.getInstance().closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                throw new DaoException(e);
            }
        }

        return menu;
    }
}
