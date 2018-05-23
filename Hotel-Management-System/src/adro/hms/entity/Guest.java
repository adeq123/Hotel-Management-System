package adro.hms.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="guest")
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "id_number")	
	private String idNumber;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	@ManyToOne(	cascade = {
					CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH
					})
	@JoinColumn(name = "room_id")
	private Room room;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "number_of_nights")
	private String numberOfNights;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "checkout_date")
	private String checkoutDate;
	
	//@Temporal(TemporalType.DATE)
	//private java.util.Date checkoutDate;
	
	public Guest() {
		
	}

	
	public Guest(String firstName, String lastName, String idNumber, String phoneNumber,
			 Room room, String numberOfNights, String checkoutDate) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.room = room;
		this.numberOfNights = numberOfNights;
		this.checkoutDate = checkoutDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(String numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	public String toString() {
		return "[Guest: id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", idNumber = " + idNumber +"]";
	}
	
	  
}
