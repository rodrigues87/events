package com.ascode.events.repositories;

import com.ascode.events.entities.StablishmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EstabelecimentoRepository extends JpaRepository<StablishmentEntity, UUID> {
}