package io.github.alexbogovich.springjpasandbox.service;

import io.github.alexbogovich.springjpasandbox.repository.NodeRepo;
import io.github.alexbogovich.springjpasandbox.repository.TreeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExpServiceTest {

    @Autowired
    private ExpService expService;

    @Autowired
    private NodeRepo nodeRepo;

    @Autowired
    private TreeRepo treeRepo;

    @BeforeEach
    void setUp() {
    }

    @Test
    void initTree() {

        expService.initTree();
        Assertions.assertEquals(1, treeRepo.count());
        Assertions.assertEquals(30000, nodeRepo.count());

        System.out.println("call first version");
        expService.findByName();

        System.out.println("call second version");
        expService.findByNameWithGraph();
    }
}