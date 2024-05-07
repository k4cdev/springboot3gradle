package com.springboot3.demo.auth;

import com.springboot3.demo.jwt.JwtService;
import com.springboot3.demo.user.Role;
import com.springboot3.demo.user.User;
import com.springboot3.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    AuthResponse login(LoginRequest login){
        return null;
    }

    AuthResponse register(RegisterRequest register){
        User user = User.builder()
                .username(register.getUsername())
                .password(passwordEncoder.encode(register.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }
}
