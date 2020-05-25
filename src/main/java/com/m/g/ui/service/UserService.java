package com.m.g.ui.service;

import com.m.g.ui.model.User;
import com.m.g.ui.jpa.model.UserEntity;
import com.m.g.ui.jpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean processAndSaveUser(User user)
    {
        UserEntity userEntity = new UserEntity();
        if(user.getId()!=null)
        {
            userEntity.setId(user.getId());
        }
        else
        {
            userEntity.setId(Long.valueOf(Math.abs(new Random().nextInt())));
        }

        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        UserEntity returnResult = userRepository.save(userEntity);
        return returnResult!=null;
    }

    public List<UserEntity> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUserByID(long id)
    {
        Optional<UserEntity> userEntity =  userRepository.findById(id);
        User user = new User();
        user.setEmail(userEntity.get().getEmail());
        user.setId(userEntity.get().getId());
        user.setName(userEntity.get().getName());
        return Optional.of(user);
    }

    public void deleteUser(long id)
    {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(userEntity);
    }

}
