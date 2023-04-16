package com.productOrderApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productOrderApp.model.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
