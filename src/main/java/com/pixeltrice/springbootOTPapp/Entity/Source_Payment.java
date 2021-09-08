package com.pixeltrice.springbootOTPapp.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.pixeltrice.springbootOTPapp.Generator.Generator;


@Entity
@Table(name = "payment_source_tbl")
public class Source_Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_source_seq")
	@GenericGenerator(name = "payment_source_seq", strategy = "com.pixeltrice.springbootOTPapp.Generator.Generator",
						parameters = {
								@Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
								@Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "PAYSRC_"),
						})
	@Column(name = "payment_source_id", length = 10)
	private String payment_source_id;
	
	

	@Column(name = "payment_source_name", nullable = true, length = 10)
	private String payment_source_name;
	
	public String getPayment_source_id() {
		return payment_source_id;
	}

	public void setPayment_source_id(String payment_source_id) {
		this.payment_source_id = payment_source_id;
	}

	public String getPayment_source_name() {
		return payment_source_name;
	}

	public void setPayment_source_name(String payment_source_name) {
		this.payment_source_name = payment_source_name;
	}


}
