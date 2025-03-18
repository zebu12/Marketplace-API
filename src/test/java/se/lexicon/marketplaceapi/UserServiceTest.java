package se.lexicon.marketplaceapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.repository.UserRepository;
import se.lexicon.marketplaceapi.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private UserService userService;



    @Test
    void testRegisterUser() {

        String email = "test@test.com";
        String password = "password";
        String hashedPassword = "hashedPassword123";

        when(passwordEncoder.encode(any())).thenReturn(hashedPassword);

        User mockUser = new User(email, password);
        when(userRepository.save(any(User.class))).thenReturn(mockUser);

        User user = userService.register("test@example.com", "password123");

        assertNotNull(user);
        assertEquals(email, user.getEmail());
        assertEquals(hashedPassword,user.getPassword());
    }
}
