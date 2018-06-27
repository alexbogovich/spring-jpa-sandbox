package io.github.alexbogovich.springjpasandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Node {
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Long id;

    private String value;

    @ManyToOne
    private Tree tree;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private NodeDescription description;
}
