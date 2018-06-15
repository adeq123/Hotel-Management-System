package adro.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class models the generic to do action for the staff of the hotel. The annotations included allows to store the object as an entity in the DB.
 * @author ADRO
 */

@Entity
@Table(name = "toDo")
public class ToDo {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "task")
	private String task;
	
	public ToDo() {
		
	}

	public ToDo(String task) {
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	public String toString() {
		return "[ToDo: id = " + id + " ,task = " + task +" ]";
	}
	
	@Override
	public boolean equals(Object o) {
	    // self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	    // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    ToDo todo = (ToDo) o;
	    // field comparison
	    return todo.getTask().equals(this.task) && 
	    		todo.getId() == this.id ;
	}
}
