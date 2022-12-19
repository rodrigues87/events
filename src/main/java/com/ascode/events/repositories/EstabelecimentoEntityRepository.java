package com.ascode.events.repositories;

import com.ascode.events.entities.EstabelecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EstabelecimentoEntityRepository extends JpaRepository<EstabelecimentoEntity, UUID> {
}