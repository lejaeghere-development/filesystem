package com.datadobi.filesystem.depthsearchutil;

import java.util.List;

public class GraphMock {
    public static Node FinalcreateGraphMock(List<List<String>> filteredEntries) {
        int i = 1;
        int maxDepth = 0;
        Node baseNode = new Node();
        baseNode.setValue("File system");

        for (List<String> entries : filteredEntries) {
            if (entries.size() > maxDepth) {
                maxDepth = entries.size();
            }
        }

        while (filteredEntries.size() >= maxDepth) {
            final int depth = i;
            if (i == 1) {
                filteredEntries.stream().filter(fe -> fe.size() == depth).forEach(fe -> {
                    Node node = new Node();
                    node.setValue(fe.get(depth - 1));
                    List<Node> adjacentNodes = baseNode.getAdjacentNodes();
                    adjacentNodes.add(node);
                });
            } else {
                //TODO: write logic to create the needed node structure

            }


            i++;
        }
        return null;
    }

    public static Node tempCreateGraphMock() {
        //UGLY HARDCODE DATA FOR DEMO PURPOSE
        Node ziptest = new Node();
        ziptest.setValue("ziptest");
        List<Node> adjacentNodes = ziptest.getAdjacentNodes();

        Node aaatxt = new Node();
        aaatxt.setValue("aaa.txt");
        adjacentNodes.add(aaatxt);

        Node newtxt = new Node();
        newtxt.setValue("new.txt");
        adjacentNodes.add(newtxt);

        Node sub = new Node();
        sub.setValue("sub");
        adjacentNodes.add(sub);
        List<Node> subAdjacentNodes = sub.getAdjacentNodes();

        Node new2txt = new Node();
        new2txt.setValue("new2.txt");
        subAdjacentNodes.add(new2txt);

        return ziptest;
    }
}
