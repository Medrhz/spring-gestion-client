package com.gestionClient.service;

import com.gestionClient.model.Order;
import com.gestionClient.repos.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
 @Autowired
 private OrderRepository orderRepository;

   // Créer un nouveau Order
   public Order saveOrder (Order order) {
      return this.orderRepository.save(order);
   }

   // Récupérer tous les Orders
   public List<Order> getAllOrders () {
      return this.orderRepository.findAll();
   }

   // Récupérer un Order par son ID
   public Optional<Order> getOrderById (long id) {
      return this.orderRepository.findById((long) id);
   }

   // Mettre à jour un Order
   public Order updateOrder (Order Order) {
      return this.orderRepository.save(Order);
   }

   // Supprimer un Order
   public void deleteOrder (long id) {
      this.orderRepository.deleteById((long) id);
   }
}
