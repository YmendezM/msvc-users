package com.yiado.msvc.users.controller;

import com.yiado.msvc.users.entity.User;
import com.yiado.msvc.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return  userService.findAllList();
    };

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<User> userOptional =  userService.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok().body(userOptional.get());
        }
        return (ResponseEntity<?>) ResponseEntity.notFound().build();
    };

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>  create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>  update(@RequestBody User user, @PathVariable Long id){
        Optional<User> userOptional =  userService.findById(id);
        if(userOptional.isPresent()){
           User userCurrent =  userOptional.get();
           userCurrent.setName(user.getName());
           userCurrent.setEmail(user.getEmail());
           return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userCurrent));
        }
        return (ResponseEntity<?>) ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<User> userOptional =  userService.findById(id);
        if(userOptional.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
