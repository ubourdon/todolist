package fr.libre.todolist.domain;

import javax.persistence.*;
import java.util.List;

/**
 * User: ugo
 * Date: 11/11/11
 */
@Entity
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Column( unique = true )
	private String username;
	private String password;

	@ManyToMany
	private List<Todo> todos;

	@ManyToMany
	private List<Group> groups;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id + ", " +
				"username='" + username + '\'' + ", " +
				"password='" + password + '\'' + ", " +
				"todos=" + todos +
				"groups=" + groups +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos( List<Todo> todos ) {
		this.todos = todos;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups( List<Group> groups ) {
		this.groups = groups;
	}
}