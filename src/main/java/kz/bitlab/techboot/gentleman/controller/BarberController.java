package kz.bitlab.techboot.gentleman.controller;

import kz.bitlab.techboot.gentleman.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarberController {

    @PreAuthorize("hasAnyRole('ROLE_BARBER')")
    @GetMapping(value="/barber-panel")
    public String barberPanel(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Long userId = user.getId();
        model.addAttribute("userId", userId);
        return "barber";
    }
}
