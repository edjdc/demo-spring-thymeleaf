package edjdc.demo.springthymleaf.service;

import java.util.List;

import edjdc.demo.springthymleaf.dto.CreatedPersonDTO;
import edjdc.demo.springthymleaf.dto.PersonDTO;
import edjdc.demo.springthymleaf.dto.UpdatedPersonDTO;

public interface PersonService {

	Long create(CreatedPersonDTO dto);
	
	void update(UpdatedPersonDTO dto);
	
	UpdatedPersonDTO findOneForEdit(Long id);

	List<PersonDTO> findAll();

	void delete(Long id);
	
}
