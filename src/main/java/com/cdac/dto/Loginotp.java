package com.cdac.dto;

public class Loginotp {

	private String uotp;

	public Loginotp() {
		super();
	}

	public Loginotp(String uotp) {
		super();
		this.uotp = uotp;
	}

	public String getUotp() {
		return uotp;
	}

	public void setUotp(String uotp) {
		this.uotp = uotp;
	}

	@Override
	public String toString() {
		return "Loginotp [uotp=" + uotp + "]";
	}
}
