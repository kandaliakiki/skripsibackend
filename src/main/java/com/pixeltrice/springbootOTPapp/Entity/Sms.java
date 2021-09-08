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
@Table(name = "sms_tbl")
public class Sms {


	
	@Id
	@Column(name = "sms_id", length = 15)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_seq")
	@GenericGenerator(name = "sms_seq", strategy = "com.pixeltrice.springbootOTPapp.Generator.Generator",
						parameters = {
								@Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
//								@Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "BOOK_"),
	})
	private String sms_id;
	
	@Column(name = "otp_sms",nullable = true, length = 6)
	private String otp_sms;


	@Column(name = "phone_no",nullable = true, length = 20)
	private String phone_no;


	public String getSms_id() {
		return sms_id;
	}


	public void setSms_id(String sms_id) {
		this.sms_id = sms_id;
	}


	public String getOtp_sms() {
		return otp_sms;
	}


	public void setOtp_sms(String otp_sms) {
		this.otp_sms = otp_sms;
	}


	public String getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	
}
