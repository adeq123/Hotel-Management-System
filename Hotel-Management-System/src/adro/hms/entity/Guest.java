package adro.hms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="guest")
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")	
	private String gender;
	
	@Column(name = "id_type")
	private String idType;
	
	@Column(name = "id_number")	
	private String idNumber;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "room")
	private String room;
	
	@Column(name = "number_of_nights")
	private String numberOfNights;
	
	@Column(name = "checkout_date")
	private String checkoutDate;
	
	//@Temporal(TemporalType.DATE)
	//private java.util.Date checkoutDate;
	
	public Guest() {
		
	}

	
	public Guest(String firstName, String lastName, String gender, String idType, String idNumber, String phoneNumber,
			String address, String room, String numberOfNights, String checkoutDate) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.idType = idType;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
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
		return "[Guest: id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", IDtype = " + idType + ", idNumber = " + idNumber +"]";
	}
}
