package org.backend.Media.SocialBackend.service;

import org.backend.Media.SocialBackend.Repository.UserRepository;
import org.backend.Media.SocialBackend.entities.USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public USER save(USER user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<USER> findAll(){
        return userRepository.findAll();
    }

    public  void deletuser(String id){
        userRepository.deleteById(id);
    }

    public Optional<USER> findById(String id){
        return userRepository.findById(id);
    }

    public USER findByUserName(String name){
        return userRepository.findByUserName(name);
    }
}
