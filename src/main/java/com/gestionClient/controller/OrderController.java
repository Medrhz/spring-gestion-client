package com.gestionClient.controller;

import com.gestionClient.model.Order;
import com.gestionClient.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
   @Autowired
   private OrderService orderService;



   // Créer un nouveau Order
   @PostMapping
   public ResponseEntity<Order> createOrder (@RequestBody Order Order) {
      Order savedOrder = this.orderService.saveOrder(Order);
      return ResponseEntity.ok(savedOrder);
   }

   // Récupérer tous les Orders
   @GetMapping
   public List<Order> getAllOrders () {
      return this.orderService.getAllOrders();
   }

   // Récupérer un Order par ID
   @GetMapping("/{id}")
   public ResponseEntity<Order> getOrderById (@PathVariable long id) {
      Optional<Order> Order = this.orderService.getOrderById(id);
      return Order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }
}
