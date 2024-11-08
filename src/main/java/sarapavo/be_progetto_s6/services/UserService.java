package sarapavo.be_progetto_s6.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sarapavo.be_progetto_s6.entities.User;
import sarapavo.be_progetto_s6.exceptions.BadRequestException;
import sarapavo.be_progetto_s6.exceptions.NotFoundException;
import sarapavo.be_progetto_s6.payloads.NewUserDTO;
import sarapavo.be_progetto_s6.repositories.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder bcrypt;

    public User saveUser(NewUserDTO body) {
        this.usersRepository.findByEmail(body.email()).ifPresent(
                user -> {
                    throw new BadRequestException("Email " + body.email() + " già in uso!");
                }
        );

        User newUser = new User(body.name(), body.surname(), body.email(), bcrypt.encode(body.password()));

        User savedUser = this.usersRepository.save(newUser);

        return savedUser;
    }

    public User findByEmail(String email) {
        return this.usersRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("L'utente con email " + email + " non è stato trovato"));
    }


}
