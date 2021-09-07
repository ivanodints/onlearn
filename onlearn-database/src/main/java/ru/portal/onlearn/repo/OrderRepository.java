package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
