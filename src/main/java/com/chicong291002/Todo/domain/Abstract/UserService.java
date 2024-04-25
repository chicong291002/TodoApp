package com.chicong291002.Todo.domain.Abstract;

import com.chicong291002.Todo.domain.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto addUser(UserDto userDto);
    UserDto removeUser(Integer userId);
    UserDto updateUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto save(UserDto userDto);
    UserDto findById(Integer id);

    UserDto findByEmail(String email);

    UserDto getUserById(Integer userId);

    boolean existsByEmail(String email);

    UserDto getAllUser();
}
