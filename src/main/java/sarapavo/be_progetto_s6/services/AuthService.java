package sarapavo.be_progetto_s6.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sarapavo.be_progetto_s6.entities.User;
import sarapavo.be_progetto_s6.exceptions.UnauthorizedException;
import sarapavo.be_progetto_s6.payloads.UserLoginDTO;
import sarapavo.be_progetto_s6.tools.JWT;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private JWT jwt;

    @Autowired
    private PasswordEncoder bcrypt;

    public String checkCredentialsAndGenerateToken(UserLoginDTO body) {
        User found = this.userService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), found.getPassword())) {
            String accessToken = jwt.createToken(found);
            return accessToken;
        } else {
            throw new UnauthorizedException("Credenziali errate!");
        }

    }
}
