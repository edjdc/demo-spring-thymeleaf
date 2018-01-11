package edjdc.demo.springthymleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edjdc.demo.springthymleaf.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
