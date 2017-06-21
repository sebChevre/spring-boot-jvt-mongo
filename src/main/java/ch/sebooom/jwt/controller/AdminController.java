package ch.sebooom.jwt.controller;

import ch.sebooom.jwt.converter.ConverterFacade;
import ch.sebooom.jwt.dto.UserDTO;
import ch.sebooom.jwt.model.Authority;
import ch.sebooom.jwt.model.User;
import ch.sebooom.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sce on 21.06.2017.
 */

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService service;
    private final ConverterFacade converterFacade;


    @Autowired
    public AdminController(final UserService service, final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<?> getUserById() {

        service.findAll().forEach((user)->{
            service.delete(user.getId());
        });

        return new ResponseEntity<>("All users successfully deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/createAdmin", method = RequestMethod.POST)
    public ResponseEntity<?> getUserById(@RequestBody final UserDTO dto) {

        User admin = converterFacade.convert(dto);

        List<Authority> authorities = new ArrayList<>();
        authorities.add(Authority.ROLE_USER);
        authorities.add(Authority.ROLE_ADMIN);

        return new ResponseEntity<>("All users successfully deleted", HttpStatus.OK);
    }


}
