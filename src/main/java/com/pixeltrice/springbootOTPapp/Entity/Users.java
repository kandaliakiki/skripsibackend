package com.pixeltrice.springbootOTPapp.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.pixeltrice.springbootOTPapp.Generator.Generator;

@Entity
@Table(name = "users_tbl")
public class Users {
	
	private static final long OTP_VALIDATION_DURATION = 5* 60 * 1000; //5 MENIT
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@GenericGenerator(name = "users_seq", strategy = "com.pixeltrice.springbootOTPapp.Generator.Generator",
						parameters = {
								@Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
								@Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "UID_"),
						})
	@Column(name = "users_id", length = 15)
	private String users_id;
	
	@Column(name = "users_name", nullable = true, length = 20)
	private String users_name;
	
	@Column(name = "users_birthday_date", nullable = true, length = 8)
	private Date users_birthday_date;
	
	@Column(name = "users_phone", nullable = true, length = 14)
	private String users_phone;
	
	@Lob
	@Column(name = "users_picture", nullable = true)
	private Byte users_picture;
	
	@Column(name = "users_gender", nullable = true, length = 3)
	private String users_gender;
	
	@Column(name = "users_email", nullable = true, length = 20)
	private String users_email;
	
	@Column(name = "users_password", nullable = true, length = 20)
	private String users_password;
	
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	public Date getUsers_birthday_date() {
		return users_birthday_date;
	}
	public void setUsers_birthday_date(Date users_birthday_date) {
		this.users_birthday_date = users_birthday_date;
	}
	public String getUsers_phone() {
		return users_phone;
	}
	public void setUsers_phone(String users_phone) {
		this.users_phone = users_phone;
	}
	public Byte getUsers_picture() {
		return users_picture;
	}
	public void setUsers_picture(Byte users_picture) {
		this.users_picture = users_picture;
	}
	public String getUsers_gender() {
		return users_gender;
	}
	public void setUsers_gender(String users_gender) {
		this.users_gender = users_gender;
	}
	public String getUsers_email() {
		return users_email;
	}
	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}
	public String getUsers_password() {
		return users_password;
	}
	public void setUsers_password(String users_password) {
		this.users_password = users_password;
	}
	
	
	

}
