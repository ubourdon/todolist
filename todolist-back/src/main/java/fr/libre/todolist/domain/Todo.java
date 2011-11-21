package fr.libre.todolist.domain;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * User: ugo
 * Date: 11/11/11
 */
@Entity
public class Todo {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String title;
	private String content;

	@ManyToMany
	private List<Group> groups;

	@ManyToMany
	private List<User> owners;

	private DateTime creationDate;
	private DateTime timeboxDate;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle( String title ) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent( String content ) {
		this.content = content;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups( List<Group> groups ) {
		this.groups = groups;
	}

	public List<User> getOwners() {
		return owners;
	}

	public void setOwners( List<User> owners ) {
		this.owners = owners;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate( DateTime creationDate ) {
		this.creationDate = creationDate;
	}

	public DateTime getTimeboxDate() {
		return timeboxDate;
	}

	public void setTimeboxDate( DateTime timeboxDate ) {
		this.timeboxDate = timeboxDate;
	}
}