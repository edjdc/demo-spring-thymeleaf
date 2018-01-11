package edjdc.demo.springevents.service;

import java.util.List;

import edjdc.demo.springevents.dto.CreatedPersonDTO;
import edjdc.demo.springevents.dto.PersonDTO;
import edjdc.demo.springevents.dto.UpdatedPersonDTO;

public interface PersonService {

	Long create(CreatedPersonDTO dto);
	
	void update(UpdatedPersonDTO dto);
	
	UpdatedPersonDTO findOneForEdit(Long id);

	List<PersonDTO> findAll();

	void delete(Long id);
	
}
