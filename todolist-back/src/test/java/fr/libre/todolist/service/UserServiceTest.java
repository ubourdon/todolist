package fr.libre.todolist.service;

import fr.libre.todolist.dao.UserDao;
import fr.libre.todolist.domain.User;
import fr.libre.todolist.domain.UserBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: ugo
 * Date: 25/11/11
 */
public class UserServiceTest {

	UserDao dao;
	UserService service;

	@Before
	public void before() {
		dao = mock( UserDao.class );
		service = new UserServiceImpl( dao );
	}

	@Test
	public void shouldRetrieveUser() throws NoSuchFieldException {
		User expectedUser = new UserBuilder().withUsername( "username" ).withPassword( "password" ).toUser();

		when( dao.retrieveUser( expectedUser.getUsername(), expectedUser.getPassword() ) ).thenReturn( expectedUser );

		assertThat( service.retrieveUser( expectedUser ) ).isEqualTo( expectedUser );
	}
}