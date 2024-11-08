package sarapavo.be_progetto_s6.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sarapavo.be_progetto_s6.entities.User;
import sarapavo.be_progetto_s6.exceptions.BadRequestException;
import sarapavo.be_progetto_s6.payloads.NewUserDTO;
import sarapavo.be_progetto_s6.services.UserService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    //    @GetMapping("/booking")
//    public Page<Event> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
//                               @RequestParam(defaultValue = "id") String sortBy) {
//        return this.eventService.findAll(page, size, sortBy);
//    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Validated NewUserDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String message = validationResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Ci sono stati errori nel payload! " + message);
        }

        return this.userService.saveUser(body);
    }

}
