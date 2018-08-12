package com.danielmedina;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.System.out;

class Graph {
    GraphNode root = new GraphNode(6);

    public Graph() {
        out.println("--- Creating Graph ---");
        this.generateGraph();
    }

    private void generateGraph() {
        GraphNode child1 = new GraphNode(4);
        GraphNode gChild1 = new GraphNode(5);
        GraphNode gChild2 = new GraphNode(3);
        GraphNode ggChild1 = new GraphNode(2);
        GraphNode gggChild1 = new GraphNode(1);

        // 4 <--> 6
        root.child.add(child1);
        child1.child.add(root);

        // 4 <--> 5
        child1.child.add(gChild1);
        gChild1.child.add(child1);

        // 4 <--> 3
        child1.child.add(gChild2);
        gChild2.child.add(child1);

        // 5 <--> 2
        gChild1.child.add(ggChild1);
        ggChild1.child.add(gChild1);

        // 5 <--> 1
        gChild1.child.add(gggChild1);
        gggChild1.child.add(gChild1);

        // 3 <--> 2
        gChild2.child.add(ggChild1);
        ggChild1.child.add(gChild2);

        // 1 <--> 2
        gggChild1.child.add(ggChild1);
        ggChild1.child.add(gggChild1);

    }

    public static void depthFirstSearch(GraphNode root) {
        if (root == null) {
            return;
        }

        root.visited = true;
        out.print(root.data);

        for (GraphNode node : root.child) {
            if (!node.visited) {
                depthFirstSearch(node);
            }
        }
    }

    public static void breathFirstSearch(GraphNode root) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode curr = queue.removeFirst();
            out.print(curr.data);
            for (GraphNode node : curr.child) {
                if (node.visited == false) {
                    node.visited = true;
                    queue.add(node);
                }
            }
        }
    }
}

class GraphNode {
    int data;
    boolean visited = false;
    ArrayList<GraphNode> child = new ArrayList<GraphNode>();

    public GraphNode(int data){
        this.data = data;
        out.println("--- New Node: " + this.data);
    }
    public GraphNode(){
        int newData = abs((new Random()).nextInt() % 10);
        out.println("--- New Node: " + this.data);
    }
}
