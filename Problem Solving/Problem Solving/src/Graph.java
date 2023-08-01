import java.util.*;

public class Graph {

    HashMap<GraphNode, ArrayList<GraphNode>> graph;
    HashSet<GraphNode> visitedNodes = new HashSet<>();

    void createGraph() {
        // graph representation using adjacency list
        graph = new HashMap<>();

        //first component
        graph.put(new GraphNode('a', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('c'),
                GraphNode.makeGraphNodeFromChar('b'))));
        graph.put(new GraphNode('b', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('d'))));
        graph.put(new GraphNode('c', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('e'))));
        graph.put(new GraphNode('d', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('f'))));
        graph.put(new GraphNode('e', false), new ArrayList<>());
        graph.put(new GraphNode('f', false), new ArrayList<>());

        //second component
        graph.put(new GraphNode('1', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('2'))));
        graph.put(new GraphNode('2', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('3'))));
        graph.put(new GraphNode('3', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('4'))));
        graph.put(new GraphNode('4', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('5'))));
        graph.put(new GraphNode('5', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('6'))));
        graph.put(new GraphNode('6', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('7'))));
        graph.put(new GraphNode('7', false), new ArrayList<>(Arrays.asList(GraphNode.makeGraphNodeFromChar('8'))));
        graph.put(new GraphNode('8', false), new ArrayList<>());


        //resetting visited nodes
        visitedNodes = new HashSet<>();
    }


    boolean hasPathInUndirectedGraph(GraphNode start, GraphNode end) {
        //reset graph
        createGraph();

        return hasPathInUndirectedGraphRec(start, end);
    }


    private boolean hasPathInUndirectedGraphRec(GraphNode start, GraphNode end) {
        if (start.equals(end))
            return true;

        ArrayList<GraphNode> current = graph.get(start);

        for (GraphNode node : current) {
            if (!node.visited) {
                node.visited = true;

                if (hasPathInUndirectedGraphRec(node, end))
                    return true;
            }
        }
        return false;
    }

    boolean hasPath(GraphNode start, GraphNode end) {

        Stack<GraphNode> dps = new Stack<>();
        dps.push(start);

        while (!dps.isEmpty()) {
            start = dps.pop();

            if (start == end)
                return true;

            ArrayList<GraphNode> current = graph.get(start);

            for (GraphNode path : current) {
                dps.push(path);
            }

        }
        return false;
    }

    boolean hasPathRec(GraphNode start, GraphNode end) {
        return hasPathHelper(start, end);
    }

    private boolean hasPathHelper(GraphNode start, GraphNode end) {

        if (start == end)
            return true;

        ArrayList<GraphNode> current = graph.get(start);

        for (GraphNode path : current) {
            if (hasPathHelper(path, end))
                return true;
        }

        return false;
    }

    void traverseDepthFirstPrintRec() {
        DepthFirstPrintRec(graph, GraphNode.makeGraphNodeFromChar('a'));
    }

    void traverseDepthFirstPrintIteratively() {
        DepthFirstPrintIterative(graph, GraphNode.makeGraphNodeFromChar('a'));
    }

    private void DepthFirstPrintRec(HashMap<GraphNode, ArrayList<GraphNode>> graph, GraphNode startingNode) {
        System.out.print(startingNode.element);
        System.out.print("  ");
        ArrayList<GraphNode> current = graph.get(startingNode);

        for (GraphNode neighbor : current) {
            DepthFirstPrintRec(graph, neighbor);
        }
    }

    private void DepthFirstPrintIterative(HashMap<GraphNode, ArrayList<GraphNode>> graph, GraphNode startingNode) {
        Stack<GraphNode> graphStack = new Stack<>();
        graphStack.push(startingNode);


        while (!graphStack.isEmpty()) {
            GraphNode current = graphStack.pop();
            System.out.print(current.element);
            System.out.print("  ");

            for (GraphNode neighbor : graph.get(current)) {
                graphStack.push(neighbor);
            }
        }
    }

    //can't be done recursively as it uses queue and writing recursion function will be using runtime stack
    void traverseBreadthFirstPrint() {
        BreadthFirstPrintIterative(graph, GraphNode.makeGraphNodeFromChar('a'));
    }

    private void BreadthFirstPrintIterative(HashMap<GraphNode, ArrayList<GraphNode>> graph, GraphNode startingNode) {
        Queue<GraphNode> graphQueue = new ArrayDeque<GraphNode>();
        graphQueue.add(startingNode);


        while (!graphQueue.isEmpty()) {
            GraphNode current = graphQueue.remove();
            System.out.print(current.element);
            System.out.print("  ");

            for (GraphNode neighbor : graph.get(current)) {
                graphQueue.add(neighbor);
            }
        }
    }

    int connectedComponentCount() {
        int componentCount = 0;

        for (Map.Entry<GraphNode, ArrayList<GraphNode>> entry : graph.entrySet()) {
            if (!visitedNodes.contains(entry.getKey())) {
                componentCount++;
                connectedComponentBreadthFirst(entry.getKey());
            }
        }

        return componentCount;
    }

    private void connectedComponentBreadthFirst(GraphNode startingNode) {
        Queue<GraphNode> graphQueue = new ArrayDeque<GraphNode>();
        graphQueue.add(startingNode);

        while (!graphQueue.isEmpty()) {
            GraphNode current = graphQueue.remove();
            visitedNodes.add(current);

            current.visited = true;
            for (GraphNode neighbor : graph.get(current)) {
                graphQueue.add(neighbor);
            }
        }
    }

    int largestComponentBFS() {
        int largestComponent = Integer.MIN_VALUE;

        for (Map.Entry<GraphNode, ArrayList<GraphNode>> entry : graph.entrySet()) {
            if (!visitedNodes.contains(entry.getKey())) {
                int componentSize = connectedComponentSizeBFS(entry.getKey());
                if (componentSize > largestComponent)
                    largestComponent = componentSize;
            }
        }

        return largestComponent;
    }


    private int connectedComponentSizeBFS(GraphNode startingNode) {
        int count = 0;
        Queue<GraphNode> graphQueue = new ArrayDeque<GraphNode>();
        graphQueue.add(startingNode);

        while (!graphQueue.isEmpty()) {
            count++;
            GraphNode current = graphQueue.remove();
            visitedNodes.add(current);

            current.visited = true;
            for (GraphNode neighbor : graph.get(current)) {
                graphQueue.add(neighbor);
            }
        }

        return count;
    }


    int largestComponentDFS() {
        int largestComponent = Integer.MIN_VALUE;

        for (Map.Entry<GraphNode, ArrayList<GraphNode>> entry : graph.entrySet()) {
            if (!visitedNodes.contains(entry.getKey())) {
                int componentSize = connectedComponentSizeDFS(entry.getKey());
                if (componentSize > largestComponent)
                    largestComponent = componentSize;
            }
        }

        return largestComponent;
    }

    private int connectedComponentSizeDFS(GraphNode node) {
        ArrayList<GraphNode> neighbors = graph.get(node);

        if (visitedNodes.contains(node)) return 0;

        visitedNodes.add(node);
        int size = 1;

        for (GraphNode neighbor : neighbors) {
            size += connectedComponentSizeDFS(neighbor);
        }

        return size;
    }

}
