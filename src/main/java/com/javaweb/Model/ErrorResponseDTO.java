package com.javaweb.Model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponseDTO {
	private String error;
	private List<String> detail = new ArrayList<String>();

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getDetails() {
		return detail;
	}

	public void setDetails(List<String> detail) {
		this.detail = detail;
	}

}
