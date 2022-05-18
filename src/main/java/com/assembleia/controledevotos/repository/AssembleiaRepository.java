package com.assembleia.controledevotos.repository;

import com.assembleia.controledevotos.domain.Assembleia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssembleiaRepository extends MongoRepository<Assembleia, String> {
}
