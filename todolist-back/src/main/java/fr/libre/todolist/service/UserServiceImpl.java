package fr.libre.todolist.service;

import fr.libre.todolist.dao.UserDao;
import fr.libre.todolist.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: ugo
 * Date: 25/11/11
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
	private final Logger log = LoggerFactory.getLogger( this.getClass() );

	private UserDao userDao;

	@Autowired
	public UserServiceImpl( UserDao userDao ) {
		this.userDao = userDao;
	}

	public User retrieveUser( User user ) {
		return userDao.retrieveUser( user.getUsername(), user.getPassword() );
	}
}
