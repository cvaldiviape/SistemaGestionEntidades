package com.cvaldiviape.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class AppHelpers {

	public String convertLocalDateTimeToString(LocalDateTime localDateTime) {
		LocalDateTime currentDateTime = localDateTime;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}
	
	public Pageable getPageable(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) 
				? Sort.by(sortBy).ascending() 
				: Sort.by(sortBy).descending();
		return PageRequest.of(numberPage, sizePage, sort);
	}
	
}