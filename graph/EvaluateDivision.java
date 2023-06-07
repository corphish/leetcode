// https://leetcode.com/problems/evaluate-division
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        DisjointSet djs = new DisjointSet(equations, values);
        double[] res = new double[queries.size()];
        int i = 0;
        
        for (List<String> Q: queries) {
            double x = djs.getResult(Q.get(0), Q.get(1));
            res[i++] = x;
        }
        
        return res;
    }
    
    class DisjointSet {
        int[] root;
        double[][] values;
        Map<String, Integer> indexes;
        int V;
        
        DisjointSet(List<List<String>> equations, double[] values) {
            this.indexes = getIndexes(equations);
            int size = indexes.size();
            this.V = size;
            
            //System.out.println(indexes);
            
            root = new int[size];
            this.values = new double[size][size];
            
            for (int i = 0; i < size; i++) {
                root[i] = i;
                this.values[i][i] = 1;
            }
            
            for (int i = 0; i < values.length; i++) {
                String a = equations.get(i).get(0);
                String b = equations.get(i).get(1);
                
                int x = indexes.get(a);
                int y = indexes.get(b);
                
                this.values[x][y] = values[i];
                this.values[y][x] = 1/values[i];
            }
        }
        
        public double getResult(String a, String b) {
            Integer x = indexes.get(a);
            Integer y = indexes.get(b);
            
            if (x == null || y == null) {
                return -1;
            }
            
            double[] res = dijkstra(values, x);
            
            return res[y] == Integer.MAX_VALUE ? -1 : res[y];
        }
        
        int minDistance(double dist[], boolean sptSet[])
        {
            // Initialize min value
            int min_index = -1;
            double min = Integer.MAX_VALUE;

            for (int v = 0; v < V; v++)
                if (sptSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }

        // A utility function to print the constructed distance array
        void printSolution(double dist[], int source)
        {
            System.out.println("Vertex \t\t Distance from Source (" + source + ")");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + dist[i]);
        }

        // Function that implements Dijkstra's single source shortest path
        // algorithm for a graph represented using adjacency matrix
        // representation
        double[] dijkstra(double graph[][], int src)
        {
            double dist[] = new double[V]; // The output array. dist[i] will hold
            // the shortest distance from src to i

            // sptSet[i] will true if vertex i is included in shortest
            // path tree or shortest distance from src to i is finalized
            boolean sptSet[] = new boolean[V];

            // Initialize all distances as INFINITE and stpSet[] as false
            for (int i = 0; i < V; i++) {
                dist[i] = Integer.MAX_VALUE;
                sptSet[i] = false;
            }

            // Distance of source vertex from itself is always 0
            dist[src] = 1;

            // Find shortest path for all vertices
            for (int count = 0; count < V - 1; count++) {
                // Pick the minimum distance vertex from the set of vertices
                // not yet processed. u is always equal to src in first
                // iteration.
                int u = minDistance(dist, sptSet);

                // Mark the picked vertex as processed
                sptSet[u] = true;

                // Update dist value of the adjacent vertices of the
                // picked vertex.
                for (int v = 0; v < V; v++)

                    // Update dist[v] only if is not in sptSet, there is an
                    // edge from u to v, and total weight of path from src to
                    // v through u is smaller than current value of dist[v]
                    if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                        dist[v] = dist[u] * graph[u][v];
            }

            // print the constructed distance array
            //printSolution(dist, src);
            return dist;
        }
        
        private Map<String, Integer> getIndexes(List<List<String>> input) {
            int index = 0;
            Map<String, Integer> res = new HashMap<>();
            
            for (List<String> l: input) {
                for (String s: l) {
                    Integer I = res.get(s);
                    if (I == null) {
                        res.put(s, index++);
                    }
                }
            }
            
            return res;
        }
    }
}