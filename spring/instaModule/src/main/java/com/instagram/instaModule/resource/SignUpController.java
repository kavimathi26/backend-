package com.instagram.instaModule.resource;

//import com.instagram.instaModule.Entity.UserInfo;
//import com.instagram.instaModule.dto.Authentication;
import com.instagram.instaModule.dto.JwtRequest;
import com.instagram.instaModule.dto.SignUpRequest;
import com.instagram.instaModule.model.SignUp;
import com.instagram.instaModule.repository.SignUpRepository;
import com.instagram.instaModule.service.JwtService;
import com.instagram.instaModule.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
//import com.instagram.instaModule.dto.Authentication;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("signup")
@CrossOrigin("*")
public class SignUpController {
    @Autowired
    SignUpRepository signUpRepository;
    @Autowired
    SignUpService signUpService;
    @Autowired
    JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Arulmozhi Karunagaran";
    }
    @PostMapping
    public SignUp signUpApi(@RequestBody SignUp signUp) {
       signUpService.signUpApi(signUp);
       return signUp;
    }

//    public void signUpApi(@PathVariable String email, @RequestParam String password, @RequestParam String profileId, @RequestParam String profileName) {
//        signUpService.signUpApi(email,password,profileId,profileName);
//    }
//    @PostMapping("/new")
//    public void addNewUser(@RequestBody UserInfo userInfo){
//        signUpService.addUser(userInfo);
//    }
@PostMapping("/authenticate")
public JwtRequest authenticateAndGetToken(@RequestBody SignUpRequest signUpRequest) {
    System.out.println("asrul");
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signUpRequest.getUserName(), signUpRequest.getPassword()));
    System.out.println(authentication.isAuthenticated());
    if (authentication.isAuthenticated()) {
        String token = jwtService.generateToken(signUpRequest.getUserName());
        return new JwtRequest(token);
    } else {
        throw new UsernameNotFoundException("invalid user request !");
    }


}
}
