package pinterest.Topic7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graphs {

    static Map<Integer, List<Integer>> adj = new HashMap<>();

    public void addEdge(int sourceNode, int destinationNode) {
        adj.computeIfAbsent(sourceNode, k -> new ArrayList<>()).add(destinationNode);
        adj.computeIfAbsent(destinationNode, k -> new ArrayList<>()).add(sourceNode);
    }

    private static void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            System.out.println("source: (" + entry.getKey() + ") --> " + "destination: " + entry.getValue());
        }
    }


    //DFS
    public static void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS from node " + start + ":");
        dfsHelper(start, visited);
    }

    private static void dfsHelper(int start, Set<Integer> visited) {
        if (visited.contains(start)) return;
        visited.add(start);
        System.out.println("node: " + start);
        for (int neighbor : adj.getOrDefault(start, new ArrayList<>())) {
            dfsHelper(neighbor, visited);
        }
    }

    //BFS
    public static void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        System.out.println("BFS from node " + start + ":");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("node: " + node);
            for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }


    public static void main(String[] args) {
        Graphs graphs = new Graphs();
        graphs.addEdge(1, 2);
        graphs.addEdge(1, 3);
        graphs.addEdge(2, 4);
        graphs.addEdge(3, 5);
        graphs.addEdge(5, 6);

        dfs(1);
        bfs(1);
    }

}
