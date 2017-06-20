package ch.sebooom.jwt.controller;

import ch.sebooom.jwt.converter.ConverterFacade;
import ch.sebooom.jwt.model.Authority;
import ch.sebooom.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * Created by sce on 20.06.2017.
 */
@RestController
@RequestMapping("/api/users")
//@RolesAllowed("ROLE_ADMIN")
public class UsersController {

    private final UserService service;

    @Autowired
    public UsersController(final UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsersList() {
        return new ResponseEntity<>(
                service.findAll(), HttpStatus.OK);
    }
}
