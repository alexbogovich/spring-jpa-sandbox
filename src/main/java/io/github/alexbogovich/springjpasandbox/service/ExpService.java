package io.github.alexbogovich.springjpasandbox.service;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import io.github.alexbogovich.springjpasandbox.model.Node;
import io.github.alexbogovich.springjpasandbox.model.NodeDescription;
import io.github.alexbogovich.springjpasandbox.model.Tree;
import io.github.alexbogovich.springjpasandbox.repository.NodeRepo;
import io.github.alexbogovich.springjpasandbox.repository.TreeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ExpService {

    private final NodeRepo nodeRepo;
    private final TreeRepo treeRepo;


    @Transactional
    public void initTree() {
        List<Node> collect = IntStream.range(1, 30001)
                .mapToObj(i -> Node.builder().value("Node" + i).description(NodeDescription.builder().desc("Node desc " + i).build()).build())
                .collect(Collectors.toList());

        Tree tree = Tree.builder().name("tree").nodes(collect).build();
        collect.forEach(n -> n.setTree(tree));

        treeRepo.save(tree);
    }

    @Transactional(readOnly = true)
    public void findByName() {
        Optional<Tree> tree = treeRepo.findByName("tree");
        tree.ifPresent(t -> System.out.println(t.getNodes().stream().map(Node::getDescription).filter(d -> d.getDesc().contains("40")).count()));
    }

    @Transactional(readOnly = true)
    public void findByNameWithGraph() {
        Optional<Tree> tree = treeRepo.findByName("tree", EntityGraphUtils.fromAttributePaths("nodes", "nodes.description"));
        tree.ifPresent(t -> System.out.println(t.getNodes().stream().map(Node::getDescription).filter(d -> d.getDesc().contains("40")).count()));
    }

}
