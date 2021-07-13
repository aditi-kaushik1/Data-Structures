//Graph class

import java.util.*;

public class Graph {
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

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if(fromNode == null)
                throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if(toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for(var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if(node == null)
            return;

        for(var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if(fromNode == null)
            return;

        Node toNode = nodes.get(to);
        if(toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String root) {
        Node node = nodes.get(root);
        if(node == null)
            return;
        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for(var node : adjacencyList.get(root)) {
            if (!visited.contains(node))
                traverseDepthFirst(node, visited);
        }
    }

    public void traverseDepthFirstIterative(String root) {
        Node node = nodes.get(root);
        if(node == null)
            return;

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        stack.push(node);
        while(!stack.isEmpty()) {
            Node current = stack.pop();

            if(visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);

            for(var neighbours : adjacencyList.get(current))
                if(!visited.contains(neighbours))
                    stack.push(neighbours);
        }
    }

    public void BreadthFirst(String root) {
        Node node = nodes.get(root);
        if(node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.add(node);
        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(visited.contains(curr))
                continue;

            System.out.println(curr);
            visited.add(curr);

            for(Node neighbours : adjacencyList.get(curr)) {
                if (!visited.contains(neighbours))
                    q.add(neighbours);
            }
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for(var node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> list = new ArrayList<>();
        while(!stack.isEmpty())
            list.add(stack.pop().label);

        return list;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if(visited.contains(node))
            return;

        visited.add(node);

        for(var neighbour : adjacencyList.get(node))
            if(!visited.contains(neighbour))
                topologicalSort(neighbour, visited, stack);
        stack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while(!all.isEmpty()) {
            Node current = all.iterator().next();
            if(hasCycle(current, all, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for(var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;
            if (visiting.contains(neighbour))
                return true;
            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }
        visiting.remove(node);
        visited.add(node);

        return false;
    }
}

//****************************************************************************************************

//Main class

import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Graph graph = new Graph();
//      graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
//      graph.addEdge("B", "P");
        //graph.BreadthFirst("A");
        System.out.println(graph.topologicalSort());
        System.out.println(graph.hasCycle());
    }
}
