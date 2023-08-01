import java.util.Objects;

public class GraphNode {
    public Character element;
    public boolean visited;

    public GraphNode(Character element, boolean visited) {
        this.element = element;
        this.visited = visited;
    }

    public static GraphNode makeGraphNodeFromChar(Character e){
        return new GraphNode(e, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return Objects.equals(element, graphNode.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }
}
