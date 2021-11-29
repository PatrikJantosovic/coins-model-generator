package com.jantosovic.dss;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static ArrayList<Node<Move>> addToTree(Node<Move> parent) {
        var leaves = new ArrayList<Node<Move>>(2);
        var move = parent.value;
        if (move.getRemaining() >= 2) {
            leaves.add(parent.insertToTree(new Move(move, 2)));
        }
        if (move.getRemaining() >= 1) {
            leaves.add(parent.insertToTree(new Move(move, 1)));
        }
        return leaves;
    }

    public static void main(String[] args) {
        var remaining = Integer.parseInt(args[0]);
        // root initialization
        var treeNode = new Node<Move>();
        var root = new Move(remaining);
        treeNode.insertToTree(root);
        // iterate through leaves of the tree
        var leaves = new ArrayList<Node<Move>>(1);
        leaves.add(treeNode);
        while (!leaves.isEmpty()) {
            var generated = new ArrayList<Node<Move>>(1);
            for (var leaf : leaves) {
                generated.addAll(addToTree(leaf));
            }
            leaves = generated;
        }
        try {
            treeNode.printTree(System.out);
            // optionally can be exported to file
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
