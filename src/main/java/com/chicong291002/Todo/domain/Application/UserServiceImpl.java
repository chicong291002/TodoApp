package com.chicong291002.Todo.domain.Application;

import com.chicong291002.Todo.domain.Abstract.UserService;
import com.chicong291002.Todo.domain.entitiy.User;
import com.chicong291002.Todo.domain.repository.UserRepository;
import com.chicong291002.Todo.domain.dto.UserDto;
import com.chicong291002.Todo.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDto) {
        User existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }
        User user = ConvertUtil.gI().toEntity(userDto, User.class);
        user = userRepository.save(user);
        return ConvertUtil.gI().toDto(user, UserDto.class);
    }

    @Override
    public UserDto removeUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        UserDto userDto = ConvertUtil.gI().toDto(user, UserDto.class);
        userRepository.delete(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId()).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user = ConvertUtil.gI().toEntity(userDto, User.class);
        user = userRepository.save(user);
        return ConvertUtil.gI().toDto(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> ConvertUtil.gI().toDto(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = ConvertUtil.gI().toEntity(userDto, User.class);
        user = userRepository.save(user);
        return ConvertUtil.gI().toDto(user, UserDto.class);
    }

    @Override
    public UserDto findById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return ConvertUtil.gI().toDto(user, UserDto.class);
        }
        return null;
    }

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return ConvertUtil.gI().toDto(user, UserDto.class);
        }
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return ConvertUtil.gI().toDto(user, UserDto.class);
        }
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDto getAllUser() {
        List<User> users = userRepository.findAll();
        return ConvertUtil.gI().toDto(users, UserDto.class);
    }
}
