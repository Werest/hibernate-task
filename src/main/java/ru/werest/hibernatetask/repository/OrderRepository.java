package ru.werest.hibernatetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.werest.hibernatetask.dao.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT t.productName FROM Order t JOIN FETCH Customer c ON lower(c.name) = :productName")
    List<String> getProduct(@Param("productName") String productName);
}
