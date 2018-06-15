package adro.hms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The class models the generic Room from the hotel. The annotations included allows to store the object as an entity in the DB.
 * @author ADRO
 */

@Entity
@Table(name = "room")
public class Room {
	
	public static final double TAX = 0.24;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "number")
	private int number;

	@Column(name = "standard")
	private String standard;
	
	@Column(name = "is_occupied")
	private boolean isOccupied;
	
	@OneToMany(mappedBy = "room", 
			cascade = {
					CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH
					}
	)
	private List<Guest> occupants;
	
	
	
	public Room() {
		
	}
	
	
	public Room(int number, String standard, boolean isOccupied, List<Guest> occupants) {
		super();
		this.number = number;
		this.standard = standard;
		this.isOccupied = isOccupied;
		this.occupants = occupants;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public boolean getIsOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public List<Guest> getOccupants() {
		return occupants;
	}

	public void setOccupants(List<Guest> occupants) {
		this.occupants = occupants;
	}
	
	public String toString () {
		return standard + " : " + number;
	}
/**
 * Returns the rate of the hotel depending on the standard. The rates are hardcoded.
 * @return
 */
	public double getRate() {
		if(standard.equals("standard")) {
			return 100.0;
		}else if(standard.equals("business")) {
			return 125.0;
		}
		return 150.0;
	}

}
