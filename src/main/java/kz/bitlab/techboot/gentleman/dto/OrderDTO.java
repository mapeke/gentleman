package kz.bitlab.techboot.gentleman.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private UserDTO client;
    private UserDTO barber;
    private LocalDateTime date;
    private boolean approved;
}
