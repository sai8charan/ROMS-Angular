package com.componentprocessing.pojo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ReplacementProcessService implements Service {
	private int processingDays=2;
	private double processingAmount=300;



}
