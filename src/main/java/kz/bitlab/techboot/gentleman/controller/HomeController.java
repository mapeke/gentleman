package kz.bitlab.techboot.gentleman.controller;

import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.model.User;
import kz.bitlab.techboot.gentleman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String indexPage(){
        return "index";
    }

    @GetMapping(value = "/sign-in-page")
    public String signInPage(){
        return "signin";
    }

    @GetMapping(value = "/sign-up-page")
    public String signUpPage(){
        return "signup";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage(){ return "profile"; }

    @GetMapping(value = "/403-page")
    public String accessDenied(){
        return "403";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/edit-profile")
    public String editProfilePage(){ return "editprofile"; }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        if (password.equals(repeatPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            UserDTO newUser = userService.addUser(user);
            if (newUser != null) {
                return "redirect:/sign-up-page?success";
            } else {
                return "redirect:/sign-up-page?emailerror";
            }
        } else {
            return "redirect:/sign-up-page?passworderror";
        }
    }

    @PostMapping(value = "/to-update-profile")
    public String toUpdateProfile(@RequestParam(name = "user_full_name") String fullName,
                                   @RequestParam(name = "user_old_password") String oldPassword,
                                   @RequestParam(name = "user_new_password") String newPassword,
                                   @RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {
        if(newPassword.equals(repeatNewPassword)) {

            UserDTO user = userService.updateProfile(fullName, newPassword, oldPassword);
            if(user != null) {
                return "redirect:/edit-profile?success";
            }else{
                return "redirect:/edit-profile?oldpassworderror";
            }

        } else {
            return "redirect:/edit-profile?passwordmismatch";
        }
    }

}
