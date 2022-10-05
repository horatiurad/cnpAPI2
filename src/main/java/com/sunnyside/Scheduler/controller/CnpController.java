package com.sunnyside.Scheduler.controller;
import com.sunnyside.Scheduler.dto.InputData;
import com.sunnyside.Scheduler.dto.PersonDTO;
import com.sunnyside.Scheduler.dto.ValidReturn;
import com.sunnyside.Scheduler.model.Cnp;
import com.sunnyside.Scheduler.operations.ValGen;
import com.sunnyside.Scheduler.service.PersonService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cnp")
public class CnpController {
    @Autowired
    private PersonService personService;
    private final ModelMapper modelMapper = new ModelMapper();
    @PostMapping("/save")
    public PersonDTO savedummy(@RequestBody PersonDTO personDTO){
        return personService.savePerson(personDTO);
    }
    @GetMapping("/validate/{input}")
    public ValidReturn validateCNP(@PathVariable("input") String input) {
        Cnp cnp = new Cnp(input);
        if (ValGen.validate(cnp)) {
            return new ValidReturn(cnp);
        } else {
            return new ValidReturn("e");
        }
    }
    @PostMapping("/generate")
    public PersonDTO generateCnp(@RequestBody InputData input){
        Cnp cnp=ValGen.generateCNP(input);
        PersonDTO personDTO=ValGen.generateNames();
        personDTO.setCnp(String.valueOf(cnp.getCnpString()));
        personService.savePerson(personDTO);
        return personDTO;
    }

}
