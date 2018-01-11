package edjdc.demo.springevents.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class UpdatedPersonDTO implements Serializable {

	private static final long serialVersionUID = 8289001321908587069L;
	
	@NotNull
	private Long id;
	@NotBlank
	@Length(max = 255)
	private String firstName;
	@NotBlank
	@Length(max = 255)
	private String lastName;
	@NotNull
	@Range(min = 0, max = 150)
	private Integer age;
	private Integer version;

}
