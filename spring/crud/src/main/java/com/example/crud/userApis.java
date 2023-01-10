package com.example.crud;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class userApis {
    newUser objUser = new newUser();
    @GetMapping("/displayUsers")
    public Map display() {
        return objUser.displayUsers();
    }

    @GetMapping("/user")
    public Object user(@RequestParam Integer id) {
        return objUser.displayOne(id);
    }
    @PostMapping("/createUser")
    public Object setUsers(@RequestBody String s) {
        objUser.createUser(s);
//        return s;
        return objUser.users;
    }

    @DeleteMapping("/delete")
    public Object deleteUser(@RequestParam Integer id) {
        objUser.deleteUser(id);
        return null;
    }
}
