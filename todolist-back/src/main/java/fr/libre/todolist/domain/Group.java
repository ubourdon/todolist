package fr.libre.todolist.domain;

import javax.persistence.*;
import java.util.List;

/**
 * User: ugo
 * Date: 11/11/11
 */
@Entity
public class Group {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String name;

	@ManyToMany
	private List<User> members;

	@ManyToMany
	private List<Todo> todos;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers( List<User> members ) {
		this.members = members;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos( List<Todo> todos ) {
		this.todos = todos;
	}
}
