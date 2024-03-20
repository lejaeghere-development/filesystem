package com.datadobi.filesystem.depthsearchutil;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String value;
    private List<Node> adjacentNodes = new ArrayList<>();
    private boolean visited;

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<Node> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
