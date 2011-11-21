package fr.libre.todolist.dao;

import fr.libre.todolist.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.hibernate.criterion.Restrictions.*;

/**
 * User: ugo
 * Date: 13/11/11
 */
@Repository
public class HibernateUserDao implements UserDao {
	private final Logger log = LoggerFactory.getLogger( this.getClass() );

	private final String USERNAME_FIELDS = "username";
	private final String PASSWORD_FIELDS = "password";

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User retrieveUser( String username, String password ) {
		return (User) getCurrentSession().
			createCriteria( User.class ).
			add( eq( USERNAME_FIELDS, username ) ).
			add( eq( PASSWORD_FIELDS, password ) ).
			uniqueResult();
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
