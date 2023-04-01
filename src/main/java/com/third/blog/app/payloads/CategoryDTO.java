package com.third.blog.app.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	private Integer categoryId;
	@NotBlank
	@Size(max = 10)
	private String categoryDescription;
	
	@NotBlank
	@Size(min = 4)
	private String categoryTitle;

}
