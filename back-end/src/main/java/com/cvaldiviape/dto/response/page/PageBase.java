package com.cvaldiviape.dto.response.page;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PageBase<E> {
	
	private Integer numberPage;
	private Integer sizePage;
	private Integer totalPages;
	private Boolean isLastPage;
	private Long totalElements;
	private List<E> elements;
	
}