package com.project.pr.services;

import com.project.pr.dto.loginDto;
import com.project.pr.dto.userDto;
import com.project.pr.models.user;
import com.project.pr.response.loginMessage;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.project.pr.repositories.userRepository;

@Service
public class userService {
private final userRepository userRepository;

    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }




    public loginMessage register(userDto userDto) {
        user user = new user(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhone(),
                userDto.getType(),
                userDto.getStatus()
        );
        userRepository.save(user);
        return new loginMessage("signed up!", true);
    }

    public loginMessage loginUser(loginDto loginDto) {
        user user = findUserByEmail(loginDto.getEmail());
        if (user == null) {
            return new loginMessage("Email doesn't exist!", false);
        }

        if (!passwordMatches(loginDto.getPassword(), user.getPassword())) {
            return new loginMessage("Password doesn't match!", false);
        }

        Optional<user> authenticatedUser = authenticateUser(loginDto.getEmail(), user.getPassword());
        if (authenticatedUser.isPresent()) {
            return new loginMessage("Logged in!", true);
        } else {
            return new loginMessage("Login failed!", false);
        }
    }

    private user findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private boolean passwordMatches(String loginDtoPassword, String userPassword) {
        return loginDtoPassword.equals(userPassword);
    }

    private Optional<user> authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }


    public void updateUser(user updatedUser) {
        userRepository.save(updatedUser);


    }

    public void deleteUser(Integer ID) {
        userRepository.deleteById(ID);
    }


}

