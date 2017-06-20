package ch.sebooom.jwt.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class LoginDTO implements Serializable {

    private static final long serialVersionUID = -4159366809929151486L;

    @ApiModelProperty(notes = "Le nom d'utilisateur", required = true)
    private String username;
    @ApiModelProperty(notes = "Le mopt de passe", required = true)
    private String password;

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
