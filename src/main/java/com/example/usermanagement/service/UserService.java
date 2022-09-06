package com.example.usermanagement.service;

import com.example.usermanagement.domains.Users;
import com.example.usermanagement.response.BaseResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    BaseResponse<Users> createUser(Users users);

    BaseResponse<List<Users>> getAll();

    BaseResponse<Optional<Users>> getUser(Long id);

    BaseResponse<String> deleteUser(Long id);
}
