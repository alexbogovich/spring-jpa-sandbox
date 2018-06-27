package io.github.alexbogovich.springjpasandbox.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@NamedEntityGraph(name = "Tree.nodes",
        attributeNodes = @NamedAttributeNode("nodes"))
public class Tree {
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "tree", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Node> nodes;
}
