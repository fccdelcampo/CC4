public class MCST {
    
    static class Vertex {
        public char data; 
        public int value;
        public boolean visited;
        public Vertex[] adjacentVertices;

        public Vertex(String input)
        {
            this.adjacentVertices = new Vertex[10];
            this.data = input.charAt(0);
            try {
                this.value = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                this.value = input.charAt(0);
            }
            this.visited = false;
        }

    }

    static class Edge {
        public Vertex tail;
        public Vertex head;
        public float cost;

        public Edge(Vertex tail, Vertex head, float cost) {
            this.tail = tail;
            this.head = head;
            this.cost = cost;

            // Append head to tail's adjacent vertices
            for (int i = 0; i < 10; i++) {
                if (tail.adjacentVertices[i] == null) {
                    tail.adjacentVertices[i] = head;
                    break;
                }
            }

            // Append tail to head's adjacent vertices
            for (int i = 0; i < 10; i++) {
                if (head.adjacentVertices[i] == null) {
                    head.adjacentVertices[i] = tail;
                    break;
                }
            }
        }

    }

    static class Graph {
        public Vertex[] vertices;
        public Edge[] edges;

        public Graph(int vertexCount, int edgeCount) {
            this.vertices = new Vertex[vertexCount];
            this.edges = new Edge[edgeCount];
        }

        public Vertex[] sortVertices() {
            Vertex [] sortedVertices = new Vertex[vertices.length];
            boolean swap;

            // Sort vertices' data lexicographically
            for (int i = vertices.length; i > 0; i--) {
                swap = false;
                for (int j = 0; j < i - 1; j++) {
                    if (sortedVertices[j].data > sortedVertices[j + 1].data) {
                        // Transfer data (w/ constructor so value and visited is automatically transferred) and adjacentVertices
                        Vertex tmp = new Vertex(String.valueOf(sortedVertices[j].data));
                        for (int k = 0; k < sortedVertices[j].adjacentVertices.length; k++) {
                            tmp.adjacentVertices[k] = sortedVertices[j].adjacentVertices[k];
                        }

                        sortedVertices[j].data = sortedVertices[j + 1].data;
                        sortedVertices[j].value = sortedVertices[j + 1].value;
                        sortedVertices[j].visited = sortedVertices[j + 1].visited;
                        for (int k = 0; k < sortedVertices[j].adjacentVertices.length; k++) {
                            sortedVertices[j].adjacentVertices[k] = sortedVertices[j + 1].adjacentVertices[k];
                        }

                        sortedVertices[j + 1].data = tmp.data;
                        sortedVertices[j + 1].value = tmp.value;
                        sortedVertices[j + 1].visited = tmp.visited;
                        for (int k = 0; k < sortedVertices[j].adjacentVertices.length; k++) {
                            sortedVertices[j + 1].adjacentVertices[k] = tmp.adjacentVertices[k];
                        }

                        swap = true;
                    }
                }
                if (!swap)
                    return sortedVertices;
            }
            return sortedVertices;
        }

        public Edge[] sortEdges() {
            Edge[] sortedEdges = new Edge[edges.length];
            for (int i = 0; i < edges.length; i++)
                sortedEdges[i] = edges[i];

            boolean swap;
            for (int i = edges.length; i > 0; i--) {
                swap = false;
                for (int j = 0; j < i - 1; j++) {
                    if (sortedEdges[j].cost > sortedEdges[j + 1].cost) {
                        Edge tmp = new Edge(sortedEdges[j].tail, sortedEdges[j].head, sortedEdges[j].cost);
                        
                        sortedEdges[j].cost = sortedEdges[j + 1].cost;
                        sortedEdges[j].tail = sortedEdges[j + 1].tail;
                        sortedEdges[j].head = sortedEdges[j + 1].head;

                        sortedEdges[j + 1].cost = tmp.cost;
                        sortedEdges[j + 1].tail = tmp.tail;
                        sortedEdges[j + 1].head = tmp.head;

                        swap = true;
                    }
                }
                if (!swap)
                    return sortedEdges;
            }
            return sortedEdges;
        }

        public void clearVisits() {
            for (Vertex vertex : vertices) 
                vertex.visited = false;
        }

        public boolean checkCycle(Graph G, Vertex source, Vertex dest, Vertex root, boolean cycleExists, boolean firstWalk) {

            // If dest is in the adjacent vertices array of source and source is not the root, return true;
            if (source.data == root.data) {
                source.visited = true;
                System.out.println("Source: " + source.data + " | Dest: " + dest.data + " | Root: " + source.data);

                if (!firstWalk) return true;

                for (Vertex v : source.adjacentVertices) {
                    if (v == null) {
                        break;
                    } else if (v != dest && v != root) {
                        System.out.println(" -> " + v.data);
                        v.visited = true;
                        return checkCycle(G, v, dest, root, cycleExists, false);
                    }
                }
            } else if (source.data == dest.data) {
                cycleExists = true;
                source.visited = true; dest.visited = true;
                System.out.println(" -> " + source.data + "CYCLE");
                return cycleExists;
            } else {
                for (Vertex v : source.adjacentVertices) {
                    if (v == null) {
                        return cycleExists || false;
                    }

                    if (v.data == dest.data) {
                        System.out.println(" -> " + v.data + "CYCLE");
                        v.visited = true;
                        G.clearVisits(); 
                        return cycleExists || true;
                    } else {
                        System.out.println(" -> " + v.data);
                        if (v != root && !v.visited && v != source) {
                            v.visited = true;
                            checkCycle(G, v, dest, root, false || cycleExists, false);
                        }

                    }
                    return cycleExists;
                }
                G.clearVisits();
            }
            G.clearVisits();
            return cycleExists;
        }

        public Graph Kruskal(int vertexCount) {
            float minCost = 0;

            Edge[] T = new Edge[vertexCount - 1];
            Edge[] E = sortEdges();

            Graph MCST = new Graph(vertexCount, vertexCount - 1);

            MCST.vertices = new Vertex[vertexCount];
            for (int i = 0; i < vertexCount; i++) {
                MCST.vertices[i] = new Vertex(Character.toString(vertices[i].data));
            }

            int edgeCount = 0;
            for (int i = 0; i < E.length; i++) {
                if (edgeCount == vertexCount - 1)
                {
                    System.out.println("=============================");
                    System.out.println("MINIMUM COST: " + minCost);
                    System.out.println("=============================");
                    break;
                }

                int tailIndex = 0; int headIndex = 0;

                for (int j = 0; j < vertexCount; j++) {
                    if (E[i].tail.data == MCST.vertices[j].data)
                        tailIndex = j;
                    
                    if (E[i].head.data == MCST.vertices[j].data)
                        headIndex = j;
                }

                if (!checkCycle(MCST, MCST.vertices[tailIndex], MCST.vertices[headIndex], MCST.vertices[tailIndex], false, true)) {
                    minCost += E[i].cost;
                    T[edgeCount] = E[i];
                    MCST.edges[edgeCount] = new Edge(MCST.vertices[tailIndex], MCST.vertices[headIndex], E[i].cost);
                    System.out.println("=====EDGE " + MCST.edges[edgeCount].tail.data + " <- " + MCST.edges[edgeCount].cost + " -> " + MCST.edges[edgeCount].head.data + " ADDED=====\n"); 
                    edgeCount++;
                }
            }

            if (edgeCount < vertexCount - 1) {
                System.out.println("=================");
                System.out.println("NO SPANNING TREE.");
                System.out.println("=================");
            }

            return MCST;
        }

        public boolean isNewVertex(Vertex v) {
            for (Vertex vx : vertices) {
                if (v == vx)
                    return true;
            }
            return false;
        }

        public void printAdjacencyMatrix(boolean mcst) {
            if (mcst) {
                System.out.println("===========================================");
                System.out.println("MINIMUM COST SPANNING TREE ADJACENCY MATRIX");
                System.out.println("===========================================");
            } else {
                System.out.println("===========================================");
                System.out.println("          GRAPH ADJACENCY MATRIX");
                System.out.println("===========================================");
            }

            for (int i = 0; i < vertices.length + 1; i++) {
                System.out.println();
                for (int j = 0; j < vertices.length + 1; j++) {
                    if (i == 0) {
                        if (j == 0)
                            System.out.print("   |");
                        else 
                            System.out.print(" " + vertices[j - 1].data + " |");
                        
                    } else {
                        if (j == 0) {
                            System.out.print(" " + vertices[i - 1].data + " |");
                        } else {
                            boolean edgeExists = false;

                            for (Edge edge: edges) {
                                if ((edge.tail.data == vertices[i - 1].data || edge.tail.data == vertices[j - 1].data) && (edge.head.data == vertices[i - 1].data || edge.head.data == vertices[j - 1].data)) {
                                    System.out.print(" 1 |");
                                    edgeExists = true;
                                }
                            }
                            if (!edgeExists)
                                System.out.print(" 0 |");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");
        Vertex J = new Vertex("J");
        Vertex K = new Vertex("K");
        Vertex L = new Vertex("L");
        Vertex M = new Vertex("M");
        Vertex N = new Vertex("N");
        Vertex O = new Vertex("O");
        Vertex P = new Vertex("P");
        Vertex Q = new Vertex("Q");

        Edge a = new Edge(K,D,5);
        Edge b = new Edge(D,F,6);
        Edge c = new Edge(F,H,5);
        Edge d = new Edge(H,L,6);
        Edge e = new Edge(K,B,5);
        Edge f = new Edge(K,G,6);
        Edge g = new Edge(D,G,7);
        Edge h = new Edge(D,J,5);
        Edge i = new Edge(F,J,8);
        Edge j = new Edge(F,A,6);
        Edge k = new Edge(F,M,7);
        Edge l = new Edge(H,M,6);
        Edge m = new Edge(H,O,7);
        Edge n = new Edge(L,O,8);
        Edge o = new Edge(L,C,6);

        Edge p = new Edge(B,G,7);
        Edge q = new Edge(G,J,5);
        Edge r = new Edge(J,A,7);
        Edge s = new Edge(A,M,6);
        Edge t = new Edge(M,O,5);
        Edge u = new Edge(O,C,6);

        Edge v = new Edge(B,P,7);
        Edge w = new Edge(G,P,6);
        Edge x = new Edge(G,N,8);
        Edge y = new Edge(J,N,7);
        Edge z = new Edge(J,I,5);
        Edge aa = new Edge(A,I,6);
        Edge ab = new Edge(M,I,7);
        Edge ac = new Edge(M,E,8);
        Edge ad = new Edge(O,E,8);
        Edge ae = new Edge(O,Q,8);
        Edge af = new Edge(C,Q,8);
        Edge ag = new Edge(P,N,6);
        Edge ah = new Edge(N,I,7);
        Edge ai = new Edge(I,E,6);
        Edge aj = new Edge(E,Q,7);

        Graph G1 = new Graph(17,36);

        G1.vertices[0] = A;
        G1.vertices[1] = B;
        G1.vertices[2] = C;
        G1.vertices[3] = D;
        G1.vertices[4] = E;
        G1.vertices[5] = F;
        G1.vertices[6] = G;
        G1.vertices[7] = H;
        G1.vertices[8] = I;
        G1.vertices[9] = J;
        G1.vertices[10] = K;
        G1.vertices[11] = L;
        G1.vertices[12] = M;
        G1.vertices[13] = N;
        G1.vertices[14] = O;
        G1.vertices[15] = P;
        G1.vertices[16] = Q;

        G1.edges[0] = a;
        G1.edges[1] = b;
        G1.edges[2] = c;
        G1.edges[3] = d;
        G1.edges[4] = e;
        G1.edges[5] = f;
        G1.edges[6] = g;
        G1.edges[7] = h;
        G1.edges[8] = i;
        G1.edges[9] = j;
        G1.edges[10] = k;
        G1.edges[11] = l;
        G1.edges[12] = m;
        G1.edges[13] = n;
        G1.edges[14] = o;
        G1.edges[15] = p;
        G1.edges[16] = q;
        G1.edges[17] = r;
        G1.edges[18] = s;
        G1.edges[19] = t;
        G1.edges[20] = u;
        G1.edges[21] = v;
        G1.edges[22] = w;
        G1.edges[23] = x;
        G1.edges[24] = y;
        G1.edges[25] = z;

        G1.edges[26] = aa;
        G1.edges[27] = ab;
        G1.edges[28] = ac;
        G1.edges[29] = ad;
        G1.edges[30] = ae;
        G1.edges[31] = af;
        G1.edges[32] = ag;
        G1.edges[33] = ah;
        G1.edges[34] = ai;
        G1.edges[35] = aj;        

        Edge[] edges = G1.sortEdges();

        for (Edge edge : edges) 
            System.out.println(edge.tail.data + " <-" + edge.cost + "-> " + edge.head.data);

        G1.printAdjacencyMatrix(false);
        
        Graph MST = G1.Kruskal(17);
        for (Edge edge : MST.edges)
            System.out.println(edge.tail.data + " <-" + edge.cost + "-> " + edge.head.data);

        for (Vertex vertex : MST.vertices) {
            System.out.print("Root Vertex: " + vertex.data + " -> ");
            for (Vertex vx : vertex.adjacentVertices) {
                if (vx != null)
                    System.out.print(vx.data + " | ");
                }
            System.out.println();
        }

        // MST.printAdjacencyMatrix(true);

    }

}