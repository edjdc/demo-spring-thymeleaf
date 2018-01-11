package edjdc.demo.springevents.assembler;

import org.springframework.stereotype.Component;

import edjdc.demo.springevents.dto.CreatedPersonDTO;
import edjdc.demo.springevents.dto.PersonDTO;
import edjdc.demo.springevents.dto.UpdatedPersonDTO;
import edjdc.demo.springevents.model.Person;

@Component
public class PersonAssembler {

	public Person toPerson(CreatedPersonDTO dto) {
		Person person = new Person();
		person.setFirstName(dto.getFirstName());
		person.setLastName(dto.getLastName());
		person.setAge(dto.getAge());
		return person;
	}

	public Person toPerson(UpdatedPersonDTO dto) {
		Person person = new Person();
		person.setId(dto.getId());
		person.setFirstName(dto.getFirstName());
		person.setLastName(dto.getLastName());
		person.setAge(dto.getAge());
		person.setVersion(dto.getVersion());
		return person;
	}
	
	public UpdatedPersonDTO toUpdatedPersonDTO(Person person) {
		UpdatedPersonDTO dto = new UpdatedPersonDTO();
		dto.setId(person.getId());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setAge(person.getAge());
		dto.setVersion(person.getVersion());
		return dto;
	}
	
	public PersonDTO toPersonDTO(Person person) {
		PersonDTO dto = new PersonDTO();
		dto.setId(person.getId());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setAge(person.getAge());
		dto.setVersion(person.getVersion());
		return dto;
	}
	
}
