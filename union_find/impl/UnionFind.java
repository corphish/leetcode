/**
 * Interface that defines the functions of Union Find.
 * <T> is the type of the node.
 */
public interface UnionFind<T> {
    
    /**
     * Finds the root node of the given vertex.
     * 
     * @param vertex Vertex whose root needs to be found.
     * @return Root node of the vertex.
     */
    T find(T vertex);

    /**
     * Performs the union operation for the 2 passed vertices.
     * In other words, connects the given 2 vertices.
     * 
     * @param vertexA Vertex that needs to be connected.
     * @param vertexB Vertex that needs to be connected.
     */
    void union(T vertexA, T vertexB);

    /**
     * Checks if the given vertices are connected.
     * 
     * @param vertexA Vertex to check.
     * @param vertexB Vertex to check.
     * @return Boolean indicating whether the 2 vertices are connected or not.
     */
    boolean isConnected(T vertexA, T vertexB);

    /**
     * Returns the size denoted by this data structure.
     * 
     * @return Number of nodes represented by this data structure.
     */
    int getSize();
}
