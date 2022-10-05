package com.sunnyside.Scheduler.service;
import com.sunnyside.Scheduler.dto.PersonDTO;
import com.sunnyside.Scheduler.model.Person;
import com.sunnyside.Scheduler.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public PersonDTO savePerson (PersonDTO personDTO){
        Person person = modelMapper.map(personDTO, Person.class);
        log.info("Job entity:{} creation BEGIN", person.getCnp());
        Person savedPerson = personRepository.save(person);
        log.info("Job saved:{} creation END", savedPerson);
        return modelMapper.map(savedPerson, PersonDTO.class);
    }
}
