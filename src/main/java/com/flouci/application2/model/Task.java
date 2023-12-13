package com.flouci.application2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
	private Long taskId;
	private Double amount;
	private Double tva;
}