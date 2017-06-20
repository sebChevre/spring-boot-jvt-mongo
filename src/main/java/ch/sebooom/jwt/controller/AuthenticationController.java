package ch.sebooom.jwt.controller;

import ch.sebooom.jwt.dto.LoginDTO;
import ch.sebooom.jwt.dto.TokenDTO;
import ch.sebooom.jwt.security.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@Api(tags = "Authentification",value="Authentification", description="Operations liées à l'authentification",
        produces = "application/json",consumes = "application/json")
public class AuthenticationController {

    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @ApiOperation(value = "Authentification d'un utilisateur",response = LoginDTO.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody final LoginDTO dto) {
        final String token = tokenService.getToken(dto.getUsername(), dto.getPassword());
        if (token != null) {
            final TokenDTO response = new TokenDTO();
            response.setToken(token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.BAD_REQUEST);
        }
    }
}
