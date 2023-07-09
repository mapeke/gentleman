package kz.bitlab.techboot.gentleman.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "barber_id", referencedColumnName = "id")
    private User barber;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "approved", columnDefinition = "boolean default false")
    private boolean approved;
}
