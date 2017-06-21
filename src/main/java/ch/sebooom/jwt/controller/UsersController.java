package ch.sebooom.jwt.controller;


import ch.sebooom.jwt.model.User;
import ch.sebooom.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


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

        List<User> users = service.findAll();
        List<Resource<User>> usersResources = new ArrayList<Resource<User>>();

        users.forEach((user)->{
            usersResources.add(getUserResource(user));
        });


        return new ResponseEntity<>(
                usersResources, HttpStatus.OK);
    }


    private Resource<User> getUserResource(User user){

        Resource<User> resource = new Resource<User>(user);

        resource.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());

        return resource;
    }
}
