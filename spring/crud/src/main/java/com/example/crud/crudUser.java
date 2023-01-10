package com.example.crud;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class crudUser {
    @GetMapping("/")
    public String crud() {
        return "CRUDjgyujbui";
    }
//    newUser objUser = new newUser();
    userApis ua = new userApis();
}
