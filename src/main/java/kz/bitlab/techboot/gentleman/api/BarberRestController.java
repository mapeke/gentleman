package kz.bitlab.techboot.gentleman.api;

import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/barber")
@RequiredArgsConstructor
public class BarberRestController {

    private final AdminUserService adminUserService;

    @GetMapping
    public List<UserDTO> barberList(){
        return adminUserService.getBarbers();
    }

}
