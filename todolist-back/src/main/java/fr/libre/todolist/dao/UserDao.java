package fr.libre.todolist.dao;

import fr.libre.todolist.domain.User;

/**
 * User: ugo
 * Date: 12/11/11
 */
public interface UserDao {
	public User retrieveUser( String username, String password );
}
