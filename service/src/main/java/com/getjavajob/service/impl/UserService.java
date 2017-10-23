package com.getjavajob.service.impl;

import com.getjavajob.model.entity.User;
import com.getjavajob.repository.IUserDao;
import com.getjavajob.service.IService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Component
public class UserService implements IService {

	private IUserDao userDao;

	public UserService() {
	}

	@Inject
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public List<User> fetchAll() {
		return this.userDao.fetchAll();
	}

	@Transactional
	@Override
	public User getById(Long id) {
		return this.userDao.getById(id);
	}

	@Transactional
	@Override
	public void updateUser(User user) {
		this.userDao.updateUser(user);
	}
}
