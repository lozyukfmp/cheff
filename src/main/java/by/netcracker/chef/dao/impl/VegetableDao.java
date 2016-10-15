package by.netcracker.chef.dao.impl;

import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.pool.ConnectionPool;
import by.netcracker.chef.pool.exception.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VegetableDao extends DefaultDao {

    private static final String GET_VEGETABLE_LIST_QUERY = "SELECT * FROM VEGETABLE";
    private static final String GET_VEGETABLE_QUERY = "SELECT * FROM VEGETABLE WHERE VEGETABLE_ID = ?";
    private static final String UPDATE_VEGETABLE_QUERY = "UPDATE VEGETABLE " +
            "SET VEGETABLE_NAME = ?, CALORIES = ?, FATS = ?, " +
            "PROTEINS = ?, CARBOHYDRATES = ? WHERE VEGETABLE_ID = ?";
    private static final String DELETE_VEGETABLE_QUERY = "DELETE FROM VEGETABLE WHERE VEGETABLE_ID = ?";
    private static final String DELETE_INGREDIENT_QUERY = "DELETE FROM SALAD_M2M_VEGETABLE WHERE VEGETABLE_ID = ?";
    private static final String CREATE_VEGETABLE_QUERY = "INSERT INTO VEGETABLE VALUES(NULL, ?, ?, ?, ?, ?)";

    @Override
    public List<Vegetable> getVegetableList() throws DaoException {
        List<Vegetable> vegetableList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(GET_VEGETABLE_LIST_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vegetable vegetable = new Vegetable();

                vegetable.setId(resultSet.getInt(1));
                vegetable.setName(resultSet.getString(2));
                vegetable.setCalories(resultSet.getDouble(3));
                vegetable.setFats(resultSet.getDouble(4));
                vegetable.setProteins(resultSet.getDouble(5));
                vegetable.setCarbohydrates(resultSet.getDouble(6));

                vegetableList.add(vegetable);
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

        return vegetableList;
    }

    @Override
    public Vegetable getVegetable(int vegetableId) throws DaoException {
        Vegetable vegetable = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(GET_VEGETABLE_QUERY);
            statement.setInt(1, vegetableId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vegetable = new Vegetable();

                vegetable.setId(resultSet.getInt(1));
                vegetable.setName(resultSet.getString(2));
                vegetable.setCalories(resultSet.getDouble(3));
                vegetable.setFats(resultSet.getDouble(4));
                vegetable.setProteins(resultSet.getDouble(5));
                vegetable.setCarbohydrates(resultSet.getDouble(6));
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

        return vegetable;
    }

    @Override
    public void updateVegetable(Vegetable vegetable) throws DaoException{
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(UPDATE_VEGETABLE_QUERY);
            statement.setString(1, vegetable.getName());
            statement.setDouble(2, vegetable.getCalories());
            statement.setDouble(3, vegetable.getFats());
            statement.setDouble(4, vegetable.getProteins());
            statement.setDouble(5, vegetable.getCarbohydrates());
            statement.setInt(6, vegetable.getId());

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
    public void deleteVegetable(int vegetableId) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(DELETE_INGREDIENT_QUERY);
            statement.setInt(1, vegetableId);

            statement.execute();

            statement = connection.prepareStatement(DELETE_VEGETABLE_QUERY);
            statement.setInt(1, vegetableId);

            statement.execute();
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
    public Vegetable createVegetable(Vegetable vegetable) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(CREATE_VEGETABLE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, vegetable.getName());
            statement.setDouble(2, vegetable.getCalories());
            statement.setDouble(3, vegetable.getFats());
            statement.setDouble(4, vegetable.getProteins());
            statement.setDouble(5, vegetable.getCarbohydrates());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                vegetable.setId(rs.getInt(1));
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

        return vegetable;
    }
}
