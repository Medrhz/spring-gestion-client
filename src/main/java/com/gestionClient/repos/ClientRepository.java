package com.gestionClient.repos;

import com.gestionClient.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
   List<Client> findByVille (String ville);

   List<Client> findByNom (String ville);
   long countByVille (String ville);
}
