package ch.sebooom.jwt.security.service;


public interface TokenService {

    String getToken(String username, String password);
}
