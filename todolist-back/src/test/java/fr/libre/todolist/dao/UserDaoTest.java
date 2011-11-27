package fr.libre.todolist.dao;

import fr.libre.todolist.ConstantDirectory;
import fr.libre.todolist.domain.Todo;
import fr.libre.todolist.domain.TodoBuilder;
import fr.libre.todolist.domain.User;
import fr.libre.todolist.domain.UserBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: ugo
 * Date: 12/11/11
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = ConstantDirectory.CLASSPATH_SPRING_CONFIGURATION_TEST_FILE )
@Transactional
public class UserDaoTest {
	final Logger log = LoggerFactory.getLogger( this.getClass() );

	final String TODO_TITLE_PROPERTY = "title";

	final String expectedUsername = "bob";
	final String expectedPassword = "marley";

	final String expectedTodoTitle = "title";

	@Autowired
	UserDao dao;

	@Autowired
	SessionFactory sessionFactory;

	@Before
	public void before() {
		insertUserInMemBdd();
	}

	@Test
	public void shouldRetrieveUserByUsernameAndPassword() {
		User user = dao.retrieveUser( expectedUsername, expectedPassword );
		assertThat( user.getUsername() ).isEqualTo( expectedUsername );
		assertThat( user.getPassword() ).isEqualTo( expectedPassword );
		assertThat( user.getTodos() ).hasSize( 1 );
		assertThat( user.getTodos() ).onProperty( TODO_TITLE_PROPERTY ).containsExactly( expectedTodoTitle );
	}

	@Test(expected = ConstraintViolationException.class)
	public void usernameShouldBeUnique() {
		sessionFactory.getCurrentSession().persist( new UserBuilder().
						withUsername( expectedUsername ).
						toUser() );
	}

	private void insertUserInMemBdd() {
		Todo todo = new TodoBuilder().withTitle( expectedTodoTitle ).toTodo();
		List<Todo> todos = new ArrayList<Todo>();
		todos.add( todo );
		User user = new UserBuilder().
				withUsername( expectedUsername ).
				withPassword( expectedPassword ).
				withTodos( todos ).
				toUser();

		sessionFactory.getCurrentSession().persist( user );
	}
}