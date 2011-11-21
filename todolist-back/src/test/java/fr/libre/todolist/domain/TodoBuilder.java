package fr.libre.todolist.domain;

import org.joda.time.DateTime;

import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.List;

/**
 * User: ugo
 * Date: 20/11/11
 */
public class TodoBuilder {
	private Long id;
	private String title;
	private String content;
	private List<Group> groups;
	private List<User> owners;
	private DateTime creationDate;
	private DateTime timeboxDate;

	public TodoBuilder withId( Long id ) {
		this.id = id;
		return this;
	}

	public TodoBuilder withTitle( String title ) {
		this.title = title;
		return this;
	}

	public TodoBuilder withContent( String content ) {
		this.content = content;
		return this;
	}

	public TodoBuilder withGroups( Group... groups ) {
		this.groups = Arrays.asList( groups );
		return this;
	}

	public TodoBuilder withOwners( User... owners ) {
		this.owners = Arrays.asList( owners );
		return this;
	}

	public TodoBuilder withCreationDate( DateTime creationDate ) {
		this.creationDate = creationDate;
		return this;
	}

	public TodoBuilder withTimeboxDate( DateTime timeboxDate ) {
		this.timeboxDate = timeboxDate;
		return this;
	}

	public Todo toTodo() {
		Todo todo = new Todo();
		todo.setId( id );
		todo.setTitle( title );
		todo.setContent( content );
		todo.setGroups( groups );
		todo.setOwners( owners );
		todo.setCreationDate( creationDate );
		todo.setTimeboxDate( timeboxDate );

		return todo;
	}
}