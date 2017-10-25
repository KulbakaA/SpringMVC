package com.getjavajob.repository.impl;

import com.getjavajob.model.entity.User;
import com.getjavajob.repository.IUserDao;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements IUserDao {

	private DataSource dataSource;
	private static final String SELECT_ALL = "SELECT * FROM user";
	private static final String SELECT_BY_ID = "SELECT * FROM user WHERE id = ?";
	private static final String UPDATE_USER = "UPDATE user SET name = ?, lastName = ? WHERE id =?";

	public UserDao() {
	}

	@Inject
	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<User> fetchAll() {
		System.out.println("hello");
		List<User> listOfAllExistUsers = new ArrayList<>();
		try (Connection connection = this.dataSource.getConnection()) {
			setAutoCommitAndTransactionIsolationLevel(connection);
			ResultSet resultSet = connection.prepareStatement(SELECT_ALL).executeQuery();
			while (resultSet.next()) {
				listOfAllExistUsers.add(createUserFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listOfAllExistUsers;
	}

	@Override
	public User getById(Long id) {
		try (Connection connection = this.dataSource.getConnection()) {
			setAutoCommitAndTransactionIsolationLevel(connection);
			PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return createUserFromResultSet(resultSet);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateUser(User user) {
		try (Connection connection = this.dataSource.getConnection()) {
			setAutoCommitAndTransactionIsolationLevel(connection);
			PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
			statement.setString(1, user.getName());
			statement.setString(2, user.getLastName());
			statement.setLong(3, user.getId());
			int countOfUserUpdate = statement.executeUpdate();
			System.out.println("countOfUserUpdate = " + countOfUserUpdate);
			connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void setAutoCommitAndTransactionIsolationLevel(Connection connection) throws SQLException {
		connection.setAutoCommit(false);
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	}

	private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getLong("id"));
		user.setName(resultSet.getString("name"));
		user.setLastName(resultSet.getString("lastName"));
		return user;
	}
//
//
// private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
//		return new User(resultSet.getLong("id"),
//				resultSet.getString("name"),
//				resultSet.getString("lastName"));
//
//	}
}
