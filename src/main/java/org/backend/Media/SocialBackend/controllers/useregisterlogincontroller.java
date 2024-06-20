package org.backend.Media.SocialBackend.controllers;


import org.backend.Media.SocialBackend.entities.USER;
import org.backend.Media.SocialBackend.service.UserService;
import org.backend.Media.SocialBackend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class useregisterlogincontroller {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;
    @GetMapping
    public ResponseEntity<List<USER>> getAllUsers(){
       return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<USER> createUser(@RequestBody USER user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody USER user){
       try{
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
           UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
           String token = jwtUtils.generateToken(userDetails.getUsername());
           return new ResponseEntity<>(token,HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("/{username}")
    public  ResponseEntity<USER> getByUserName(@PathVariable String username){
        return new ResponseEntity<>(userService.findByUserName(username),HttpStatus.OK);
    }

    @GetMapping("/{ID}")
    public  ResponseEntity<USER> getByID(@PathVariable String ID){
        Optional<USER> user = userService.findById(ID);
        if (user.isPresent()){
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
