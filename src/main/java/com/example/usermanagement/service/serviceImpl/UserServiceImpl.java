package com.example.usermanagement.service.serviceImpl;

import com.example.usermanagement.domains.Users;
import com.example.usermanagement.exceptions.CustomException;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.response.BaseResponse;
import com.example.usermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BaseResponse<Users> createUser(Users users) {
        return new BaseResponse<>("successfully created", HttpStatus.OK, userRepository.save(users));
    }

    @Override
    public BaseResponse<List<Users>> getAll() {

        return new BaseResponse<>("successfully created", HttpStatus.OK, userRepository.findAll());
    }

    @Override
    public BaseResponse<Optional<Users>> getUser(Long id) {

        return new BaseResponse<>("success", HttpStatus.OK, Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new CustomException("User not found"))));

    }

    @Override
    public BaseResponse<String> deleteUser(Long id) {
        Users users = userRepository.findById(id).get();
        userRepository.delete(users);
        return new BaseResponse<>("success", HttpStatus.OK, "User Deleted");

    }
}
