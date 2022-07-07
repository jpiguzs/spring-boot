package com.example.demo.excetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String propertYName;
	private Long propertyValue;

	public RecourceNotFoundException(String resourceName, String propertYName, Long propertyValue) {
		super(String.format("%s No encontrado : %s: '%s'", resourceName, propertYName, propertyValue));
		this.resourceName = resourceName;
		this.propertYName = propertYName;
		this.propertyValue = propertyValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getPropertYName() {
		return propertYName;
	}

	public Long getPropertyValue() {
		return propertyValue;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void setPropertYName(String propertYName) {
		this.propertYName = propertYName;
	}

	public void setPropertyValue(Long propertyValue) {
		this.propertyValue = propertyValue;
	}

}
