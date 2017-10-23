package com.getjavajob.service;

import com.getjavajob.model.entity.User;

import java.util.List;

public interface IService {

	List<User> fetchAll();

	User getById(Long id);

	void updateUser(User user);
}
