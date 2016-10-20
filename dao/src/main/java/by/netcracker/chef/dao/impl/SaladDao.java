package by.netcracker.chef.dao.impl;

import by.netcracker.chef.dao.exception.DaoException;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import by.netcracker.chef.pool.exception.ConnectionPoolException;
import by.netcracker.chef.pool.ConnectionPool;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaladDao extends DefaultDao {

    private static final String GET_SALAD_LIST_QUERY = "SELECT * FROM SALAD";
    private static final String GET_SALAD_QUERY = "SELECT SALAD.SALAD_ID, SALAD_NAME FROM SALAD " +
            "WHERE SALAD.SALAD_ID = ?";
    private static final String GET_VEGETABLE_LIST_QUERY = "SELECT VEGETABLE.VEGETABLE_ID, VEGETABLE_NAME, " +
            "CALORIES, FATS, PROTEINS, CARBOHYDRATES FROM SALAD_M2M_VEGETABLE " +
            "JOIN VEGETABLE ON SALAD_M2M_VEGETABLE.VEGETABLE_ID = VEGETABLE.VEGETABLE_ID " +
            "WHERE SALAD_ID = ?";
    private static final String UPDATE_SALAD_QUERY = "UPDATE SALAD SET SALAD_NAME = ? WHERE SALAD_ID = ?";
    private static final String DELETE_INGREDIENT_QUERY = "DELETE FROM SALAD_M2M_VEGETABLE WHERE SALAD_ID = ?";
    private static final String ADD_INGREDIENT_QUERY = "INSERT INTO SALAD_M2M_VEGETABLE VALUES (?, ?)";
    private static final String DELETE_SALAD_QUERY = "DELETE FROM SALAD WHERE SALAD_ID = ?";
    private static final String DELETE_SALAD_FROM_MENU_QUERY = "DELETE FROM MENU_M2M_SALAD WHERE SALAD_ID = ?";
    private static final String CREATE_SALAD_QUERY = "INSERT INTO SALAD VALUES(NULL,?)";

    @Override
    public List<Salad> getSaladList() throws DaoException {
        List<Salad> saladList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(GET_SALAD_LIST_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Salad salad = new Salad();
                salad.setId(resultSet.getInt(1));
                salad.setName(resultSet.getString(2));

                saladList.add(salad);
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

        return saladList;
    }

    @Override
    public Salad getSalad(int saladId) throws DaoException {
        Salad salad = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(GET_SALAD_QUERY);
            statement.setInt(1, saladId);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                salad = new Salad();

                salad.setId(resultSet.getInt(1));
                salad.setName(resultSet.getString(2));
            }

            List<Vegetable> vegetableList = new ArrayList<>();

            statement = connection.prepareStatement(GET_VEGETABLE_LIST_QUERY);
            statement.setInt(1, saladId);

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


            salad.setIngredients(vegetableList);

        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ConnectionPool.getInstance().closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                throw new DaoException(e);
            }
        }

        return salad;
    }

    @Override
    public void updateSalad(Salad salad) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(UPDATE_SALAD_QUERY);
            statement.setString(1, salad.getName());
            statement.setInt(2, salad.getId());

            statement.executeUpdate();

            statement = connection.prepareStatement(DELETE_INGREDIENT_QUERY);
            statement.setInt(1, salad.getId());

            statement.execute();

            statement = connection.prepareStatement(ADD_INGREDIENT_QUERY);

            for (Vegetable vegetable : salad.getIngredients()) {
                statement.setInt(1, salad.getId());
                statement.setInt(2, vegetable.getId());

                statement.executeUpdate();
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
    public void deleteSalad(int saladId) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();

            statement = connection.prepareStatement(DELETE_SALAD_FROM_MENU_QUERY);
            statement.setInt(1, saladId);
            statement.execute();

            statement = connection.prepareStatement(DELETE_INGREDIENT_QUERY);
            statement.setInt(1, saladId);
            statement.execute();

            statement = connection.prepareStatement(DELETE_SALAD_QUERY);
            statement.setInt(1, saladId);
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
    public Salad createSalad(Salad salad) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            statement = connection.prepareStatement(CREATE_SALAD_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, salad.getName());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                salad.setId(rs.getInt(1));
            }

            statement = connection.prepareStatement(ADD_INGREDIENT_QUERY);
            for (Vegetable vegetable : salad.getIngredients()) {
                statement.setInt(1, salad.getId());
                statement.setInt(2, vegetable.getId());

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

        return salad;
    }
}
