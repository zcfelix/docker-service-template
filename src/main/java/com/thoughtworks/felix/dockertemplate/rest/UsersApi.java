package com.thoughtworks.felix.dockertemplate.rest;

import com.thoughtworks.felix.dockertemplate.domain.User;
import com.thoughtworks.felix.dockertemplate.domain.UserRepository;
import com.thoughtworks.felix.dockertemplate.rest.dto.UserDTO;
import com.thoughtworks.felix.dockertemplate.rest.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersApi {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {
        final Optional<User> userOptional = repository.findById(id);
        return userOptional
                .map(x -> ResponseEntity.ok(new UserDTO(x)))
                .orElseThrow(() -> new NotFoundException("user not found"));
    }

}
