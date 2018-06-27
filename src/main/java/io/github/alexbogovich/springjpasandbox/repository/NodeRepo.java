package io.github.alexbogovich.springjpasandbox.repository;

import io.github.alexbogovich.springjpasandbox.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepo extends JpaRepository<Node, Long> {
}
