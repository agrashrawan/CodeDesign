public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username, String password) {
        User newUser = new User(username, password);
        userRepository.save(newUser);
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

}

public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // login()

    // createUser()

    // deleteUser()

}

public interface UserRepository {
    void save(User user);
    void deleteByUsername(String username);
    User findByUsername(String username);
}
