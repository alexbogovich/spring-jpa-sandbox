package io.github.alexbogovich.springjpasandbox.repository;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import io.github.alexbogovich.springjpasandbox.model.Tree;

import java.util.Optional;

public interface TreeRepo extends EntityGraphJpaRepository<Tree, Long> {
    Optional<Tree> findByName(String name, EntityGraph entityGraph);
    Optional<Tree> findByName(String name);
}
