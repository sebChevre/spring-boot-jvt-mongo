package ch.sebooom.jwt.converter;

import ch.sebooom.jwt.converter.factory.ConverterFactory;
import ch.sebooom.jwt.dto.UserDTO;
import ch.sebooom.jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConverterFacade {

    @Autowired
    private ConverterFactory converterFactory;

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
