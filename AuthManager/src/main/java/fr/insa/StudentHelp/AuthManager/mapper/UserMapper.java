package fr.insa.StudentHelp.AuthManager.mapper;

import org.springframework.stereotype.Component;

import fr.insa.StudentHelp.AuthManager.model.User;
import fr.insa.StudentHelp.AuthManager.model.UserEntity;

@Component
public class UserMapper {

    public User toUser(UserEntity e) {
        return new User(e.getId(), e.getEmail());
    }

    public UserEntity toEntity(String email, String password) {
        UserEntity u = new UserEntity();
        u.setEmail(email);
        u.setPassword(password);
        return u;
    }
}