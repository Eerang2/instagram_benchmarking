package instagram.presentation;

import instagram.application.auth.service.AuthService;
import instagram.presentation.dto.UserRegisterReq;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("/signup")
    public void registerUser(@RequestBody UserRegisterReq user) {
        authService.registerUser(user.toEntity());
    }
}
