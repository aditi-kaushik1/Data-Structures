//Weighted graph class

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
    private class Node {
        String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        Node from;
        Node to;
        int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print() {
        for(var source : nodes.values()) {
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }
}

//Main class

import java .util.*;
public class Main
{
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 2);
        graph.print();
    }
}
