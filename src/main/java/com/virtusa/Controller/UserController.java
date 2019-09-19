package com.virtusa.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.virtusa.DAO.UserRepository;
import com.virtusa.Entity.User;
import com.virtusa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/stockapi/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userrep;

    @RequestMapping( method=RequestMethod.GET)
    public List<User> getAllUsers()
    {
        List<User> list=userrep.findAll();
        //List<User> sortedList =
                return list.stream()
        .sorted(Comparator.comparing(User::getFirstName))
                .collect(Collectors.toList());
    }


    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public Optional<User> getUserDetails(@PathVariable int id)
    {
        return userService.getUserDetails(id);

    }
    @PostMapping()
    public User addUserDetails(@RequestBody User user) {

         return userrep.save(user);

    }
    @PostMapping("{id}")
    public ResponseEntity updateUserDetails(@PathVariable int id, @RequestBody User user) {
        //HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("StatusCode","1021");
        //httpHeaders.add("StatusMessage","User Not Found");
        if(userrep.existsById(id)) {
            User oldUser = userrep.findById(id).get();
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            oldUser.setEmail(user.getEmail());
            oldUser.setPhone(user.getPhone());
            oldUser.setCreditCardNo(user.getCreditCardNo());
            oldUser.setCreditCardValidity(user.getCreditCardValidity());
            oldUser.setSsn(user.getSsn());
            oldUser.setCvv(user.getCvv());
            userrep.save(oldUser);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else
        {
           return new ResponseEntity(new UserNotFound("1021","user Not Found"),HttpStatus.BAD_REQUEST);
            //return new ResponseEntity(httpHeaders, HttpStatus.BAD_REQUEST);
        }



    }

}
