package com.example.demo.models;

import java.io.Serializable;

public class RegisterModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private PersonalInfo personalInfo;
	private BillingInfo billingInfo;

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(final PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public BillingInfo getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(final BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}
}