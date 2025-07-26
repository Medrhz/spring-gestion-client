package com.gestionClient.controller;

import com.gestionClient.model.Client;
import com.gestionClient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
   @Autowired
   private ClientService clientService;

   // Créer un nouveau client
   @PostMapping
   public ResponseEntity<Client> createClient (@RequestBody Client client) {
      Client savedClient = this.clientService.saveClient(client);
      return ResponseEntity.ok(savedClient);
   }

   // Récupérer tous les clients
   @GetMapping
   public List<Client> getAllClients () {
      return this.clientService.getAllClients();
   }

   // Récupérer un client par ID
   @GetMapping("/{id}")
   public ResponseEntity<Client> getClientById (@PathVariable long id) {
      Optional<Client> client = this.clientService.getClientById(id);
      return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @GetMapping("/nom/{nom}")
   public ResponseEntity<List<Client>> getClientsByNom (@PathVariable String nom) {
      List<Client> clients = this.clientService.getClientsByNom(nom);
      return ResponseEntity.ok(clients);
   }

   // Mettre à jour un client
   @PutMapping("/{id}")
   public ResponseEntity<Client> updateClient (@PathVariable long id, @RequestBody Client clientDetails) {
      Optional<Client> client = this.clientService.getClientById(id);
      if (client.isPresent()) {
         clientDetails.setId(id);
         Client updatedClient = this.clientService.updateClient(clientDetails);
         return ResponseEntity.ok(updatedClient);
      } else {
         return ResponseEntity.notFound().build();
      }
   }


   // get client
   @GetMapping("/ville/{ville}")
   public ResponseEntity<List<Client>> getClientsByVille (@PathVariable String ville) {
      List<Client> clients = this.clientService.getClientsByVille(ville);
      return ResponseEntity.ok(clients);
   }


   // Supprimer un client
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteClient (@PathVariable long id) {
      Optional<Client> client = this.clientService.getClientById(id);
      if (client.isPresent()) {
         this.clientService.deleteClient(id);
         return ResponseEntity.ok().build();
      } else {
         return ResponseEntity.notFound().build();
      }
   }
}
