package edjdc.demo.springthymleaf.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.StaleObjectStateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edjdc.demo.springthymleaf.exception.PersonNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PersonNotFoundException.class)
	public String personNotFoundException(PersonNotFoundException ex, RedirectAttributes attributes) {
		attributes.addFlashAttribute("errorMessage", "Person not found!");
		return "redirect:/person";
	}

	@ExceptionHandler(StaleObjectStateException.class)
	public String staleObjectStateException(StaleObjectStateException ex, HttpServletRequest request, RedirectAttributes attributes) {
		String id = request.getParameter("id");
		attributes.addFlashAttribute("registroDesatualizado", "Pessoa desatualizada!");
		return "redirect:/person/editar/" + id;
	}

}
