package net.cts.hms.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorEntity {

	private int errorCode;
	private String errorMsg;
	private LocalDate date;
	
}
