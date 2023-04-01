package com.third.blog.app.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	private int id;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "user name lenght shud be between 3 and 10")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 3, max=10, message="user password shud be between 3 and 10")
	private String password;
	
	@NotEmpty
	private String about;

}
