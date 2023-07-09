package kz.bitlab.techboot.gentleman.controller;

import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.model.User;
import kz.bitlab.techboot.gentleman.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminUserService adminUserService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value="/admin-panel")
    public String adminPanel(Model model) {
        return "admin";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value="/admin-add-barber")
    public String adminAddBarberPanel(Model model) {
        return "adminaddbarber";
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/to-add-barber")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        if (password.equals(repeatPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            UserDTO newUser = adminUserService.addBarber(user);
            if (newUser != null) {
                return "redirect:/admin-add-barber?success";
            } else {
                return "redirect:/admin-add-barber?emailerror";
            }
        } else {
            return "redirect:/admin-add-barber?passworderror";
        }
    }

}
