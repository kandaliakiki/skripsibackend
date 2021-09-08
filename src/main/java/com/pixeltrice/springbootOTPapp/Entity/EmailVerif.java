package com.pixeltrice.springbootOTPapp.Entity;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.pixeltrice.springbootOTPapp.Generator.Generator;

@Entity
@Table(name = "emailverif_tbl")
public class EmailVerif {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "emailverif_id", length = 1)
	private int emailverif_id;
	
	@Column(name = "email", nullable = false, length = 50)
	private String users_email;
	
	@Column(name = "verif_code", nullable = false, length = 6)
	private String verif_code;
    
	

	public int getEmailverif_id() {
		return emailverif_id;
	}
	public void setEmailverif_id(int emailverif_id) {
		this.emailverif_id = emailverif_id;
	}
	public String getUsers_email() {
		return users_email;
	}
	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}
	public String getVerif_code() {
		return verif_code;
	}
	public void setVerif_code(String verif_code) {
		this.verif_code = verif_code;
	}

}
