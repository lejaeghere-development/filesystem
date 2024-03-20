package com.datadobi.filesystem.depthsearchutil;

public class DepthFirstSearchPreorder {

    public static void dfsRecursive(Node node) {
        System.out.print(node.getValue() + " ");
        node.getAdjacentNodes().stream()
                .filter(n -> !n.isVisited())
                .forEach(DepthFirstSearchPreorder::dfsRecursive);
    }
}
