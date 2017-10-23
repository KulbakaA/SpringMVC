package com.getjavajob.repository;

import com.getjavajob.model.entity.User;

import java.util.List;

public interface IUserDao {

	List<User> fetchAll();

	User getById(Long id);

	void updateUser(User user);
}
