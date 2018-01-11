package edjdc.demo.springthymleaf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edjdc.demo.springthymleaf.dto.CreatedPersonDTO;
import edjdc.demo.springthymleaf.dto.UpdatedPersonDTO;
import edjdc.demo.springthymleaf.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("personList", personService.findAll());
		return "person/index";
	}

	@GetMapping("/novo")
	public String novo(CreatedPersonDTO createdPersonDTO) {
		return "person/novo";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("updatedPersonDTO", personService.findOneForEdit(id));
		return "person/editar";
	}

	@PostMapping("/novo")
	public String create(@Valid CreatedPersonDTO dto, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return "person/novo";
		}
		Long id = personService.create(dto);
		attributes.addFlashAttribute("message", "Person " + id + " created!");
		return "redirect:/person/editar/" + id;
	}

	@PostMapping("/editar")
	public String editar(@Valid UpdatedPersonDTO dto, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return "person/editar";
		}
		personService.update(dto);
		attributes.addFlashAttribute("message", "Person " + dto.getId() + " updated!");
		return "redirect:/person/editar/" + dto.getId();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	@DeleteMapping("/remover/{id}")
    public void remover(@PathVariable("id") Long id) {
		personService.delete(id);
    }

}
