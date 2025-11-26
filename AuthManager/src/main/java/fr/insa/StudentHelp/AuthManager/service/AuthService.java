package fr.insa.StudentHelp.AuthManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insa.StudentHelp.AuthManager.mapper.UserMapper;
import fr.insa.StudentHelp.AuthManager.model.User;
import fr.insa.StudentHelp.AuthManager.model.UserEntity;
import fr.insa.StudentHelp.AuthManager.repository.AuthRepository;

@Service
public class AuthService {

    @Autowired
    private AuthRepository repo;

    @Autowired
    private UserMapper mapper;

    public User register(String email, String password) {

        if (repo.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email déjà utilisé");
        }

        UserEntity u = mapper.toEntity(email, password);
        UserEntity saved = repo.save(u);

        return mapper.toUser(saved);
    }

    public User login(String email, String password) {

        UserEntity user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        return mapper.toUser(user);
    }
}