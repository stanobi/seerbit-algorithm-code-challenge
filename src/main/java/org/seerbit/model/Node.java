package org.seerbit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Node {

    Node[] node;
    boolean isEnd;

    public Node() {
        this.node = new Node[2];
        this.isEnd = false;
    }
}
