package com.gestionClient.service;

import com.gestionClient.model.Client;
import com.gestionClient.model.Order;
import com.gestionClient.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
   @Autowired
   private ClientRepository clientRepository;

   // Créer un nouveau client
   public Client saveClient (Client client) {
      return this.clientRepository.save(client);
   }

   // Récupérer tous les clients
   public List<Client> getAllClients () {
      return this.clientRepository.findAll();
   }

   public List<Client> getClientsByVille (String ville) {
      return this.clientRepository.findByVille(ville);
   }

   public List<Client> getClientsByNom (String nom) {
      return this.clientRepository.findByNom(nom);
   }
   public Long getNumberOfClientByVille(String ville) {
      return clientRepository.countByVille(ville);
   }

   // Récupérer un client par son ID
   public Optional<Client> getClientById (long id) {
      return this.clientRepository.findById((long) id);
   }

   // Mettre à jour un client
   public Client updateClient (Client client) {
      return this.clientRepository.save(client);
   }

   // Supprimer un client
   public void deleteClient (long id) {
      this.clientRepository.deleteById((long) id);
   }

   //! relations with client

   public List<Order> getOrdersByClient (long id) {
      return  clientRepository.findById(id).map(Client::getOrders).orElse(new ArrayList<>());
   }
}
