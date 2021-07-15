//WeightedGraph class

import java.util.*;

public class WeightedGraph {
    private class Node {
        String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
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

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for(var node : nodes.values()) {
            var edges = node.getEdges();
            if(!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }

    public int shortestDistance(String from, String to) {
        Node fromNode = nodes.get(from);

        Map<Node, Integer> distances = new HashMap<>();
        for(var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        queue.add(new NodeEntry(fromNode, 0));

        while(!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for(var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;
                var newDistance = distances.get(current) + edge.weight;
                if(newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        return distances.get(nodes.get(to));
    }

    public Path getShortestPath(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        Map<Node, Node> previousNodes = new HashMap<>();

        HashMap<Node, Integer> distances = new HashMap<>();
        for(var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        Set<Node> visited = new HashSet<>();
        queue.add(new NodeEntry(fromNode, 0));

        while(!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for(var edge : current.getEdges()) {
                if(visited.contains(edge))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if(newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(previousNodes, toNode);
    }

    private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);

        while(previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while(!stack.isEmpty())
            path.add(stack.pop().label);
        return path;
    }

    public boolean hasCycle (){
        HashSet<Node> visited = new HashSet<>();

        for(var node : nodes.values()) {
            if(!visited.contains(node) && hasCycle(node, visited, null))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> visited, Node parent) {
        visited.add(node);

        for(var edge : node.getEdges()) {
            if(edge.to == parent)
                continue;
            if(visited.contains(edge.to) || hasCycle(edge.to, visited, node))
                return true;
        }
        return false;
    }

    public WeightedGraph getMinimumSpanningTree() {
        WeightedGraph tree = new WeightedGraph();

        if(nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        Node startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        //Return empty tree if there aren't any edges.
        if(edges.isEmpty())
            return tree;

        while(tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove();
            var nextNode = minEdge.to;
            if(tree.containsNode(nextNode.label))
                continue;
            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, minEdge.to.label, minEdge.weight);

            for(var edge : nextNode.getEdges())
                if(!tree.containsNode(edge.to.label))
                    edges.add(edge);
        }
        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }
}

//Path class

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<String> nodes = new ArrayList<>();

    public void add(String node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return nodes.toString();
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
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 10);
        var path = graph.getShortestPath("A", "C");
        System.out.println(path);
//        graph.addEdge("C", "D", 5);
//        graph.addEdge("A", "C", 1);
//        graph.addEdge("B", "C", 2);
//        var tree = graph.getMinimumSpanningTree();
//        tree.print();
//        graph.print();
//        System.out.println(graph.hasCycle());
    }
}
