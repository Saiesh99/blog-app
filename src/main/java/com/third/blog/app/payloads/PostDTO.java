package com.third.blog.app.payloads;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;

	private UserDTO user;
	private CategoryDTO category;
}
