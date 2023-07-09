package kz.bitlab.techboot.gentleman.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.techboot.gentleman.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByClientId(Long id);

    List<Order> findAllByBarberId(Long id);

    Order findByDate(LocalDateTime date);

    void deleteByBarberId(Long id);

    void deleteByClientId(Long id);

}
