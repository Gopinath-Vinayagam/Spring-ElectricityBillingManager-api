package com.electricity.billing.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MessageDTO {

	private String message;

	public MessageDTO(String message) {
		super();
		this.message = message;
	}
	

}
