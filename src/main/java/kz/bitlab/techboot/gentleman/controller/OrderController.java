package kz.bitlab.techboot.gentleman.controller;

import kz.bitlab.techboot.gentleman.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping(value="/order-panel")
    public String orderPanel(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Long userId = user.getId();
        model.addAttribute("userId", userId);
        return "order";
    }
}
