package adro.hms.entity;

import java.time.LocalDate;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="guest")
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]{1,100}", message = "Letters only!")
	private String firstName;
	
	
	@Column(name = "last_name")
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]{1,100}", message = "Letters only!")
	private String lastName;

	@Column(name = "id_number")	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{1,30}", message = "Letters and numbers only!")
	private String idNumber;
	
	@Column(name = "phone_number")
	@NotNull
	@Pattern(regexp = "^[0-9]{1,16}", message = "Numbers only!")
	private String phoneNumber;
	
	
	@ManyToOne(	cascade = {
					CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH,
					CascadeType.ALL
					})
	@JoinColumn(name = "room_id")
	private Room room;
	
	@NotNull
	@Column(name = "number_of_nights")
	@Pattern(regexp = "^[0-9]{1,3}", message = "Numbers only! max 999")
	private String numberOfNights;
	
	@NotNull
	@Column(name = "checkout_date")
	private LocalDate checkoutDate;
	
	//
	//private java.util.Date checkoutDate;
	
	@Column(name = "is_checkedout")
	private boolean isCheckedout;
	
	public Guest() {
		
	}

	
	public Guest(String firstName, String lastName, String idNumber, String phoneNumber,
			 Room room, String numberOfNights, LocalDate checkoutDate) {
	
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

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	
	public boolean isCheckedout() {
		return isCheckedout;
	}


	public void setCheckedout(boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}


	public String toString() {
		return "[Guest: id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", idNumber = " + idNumber + ", isCheckedout = " + isCheckedout +"]";
	}
	
	  
}
