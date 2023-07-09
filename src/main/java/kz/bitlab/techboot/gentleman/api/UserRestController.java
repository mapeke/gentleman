package kz.bitlab.techboot.gentleman.api;

import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserRestController {

    private final AdminUserService adminUserService;

    @GetMapping
    public List<UserDTO> userList(){
        return adminUserService.getUsers();
    }

    @GetMapping(value = "{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id){
        return adminUserService.getUser(id);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable(name = "id") Long id){
        adminUserService.deleteUser(id);
    }

}
