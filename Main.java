package com.danielmedina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        // Trees
        Tree tree = new Tree();
        tree.generateBinaryTree(3);
        out.println("--- Pre-Order Traverse ---");
        Tree.preOrderTraverse(tree.root);


        // Graphs
        Graph graph = new Graph();
        out.println("--- Depth First Search ---");
        Graph.depthFirstSearch(graph.root);
        graph = new Graph();
        out.println("--- Breath First Search ---");
        Graph.breathFirstSearch(graph.root);

        // HashMaps/HashTables
        HashMapPractice map = new HashMapPractice();
        map.populateHashMap();
        out.println( "Get: " + map.map.get("1"));


        // Sorting
        SortingPractice sortArr = new SortingPractice();
        QuickSort quickSorted = new QuickSort(sortArr.data);
        MergeSort mergeSorted = new MergeSort(sortArr.data);

        // String Manipulation
        StringManipulation str = new StringManipulation("arr");
        out.print(StringManipulation.isPalindrome(""));

    }

}
