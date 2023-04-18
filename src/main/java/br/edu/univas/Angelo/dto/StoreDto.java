package br.edu.univas.Angelo.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data

public class StoreDto {

	@NotNull
	private double amountStored;

	@NotNull
	private double minimumAmount;

	@NotBlank
	private String provider;

	@NotBlank
	private String location;

	@NotBlank
	private String joinDate;

	@NotNull
	private boolean active;

}
