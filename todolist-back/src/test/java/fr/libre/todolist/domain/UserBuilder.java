package fr.libre.todolist.domain;

import java.util.List;

/**
 * User: ugo
 * Date: 18/11/11
 */
public class UserBuilder {
	private Long id;
	private String username;
	private String password;
	private List<Todo> todos;

	public UserBuilder withId( Long id ) {
		this.id = id;
		return this;
	}

	public UserBuilder withUsername( String username ) {
		this.username = username;
		return this;
	}

	public UserBuilder withPassword( String password ) {
		this.password = password;
		return this;
	}

	public UserBuilder withTodos( List<Todo> todos ) {
		this.todos = todos;
		return this;
	}

	public User toUser() {
		User user = new User();
		user.setId( id );
		user.setUsername( username );
		user.setPassword( password );
		user.setTodos( todos );

		return user;
	}

}
