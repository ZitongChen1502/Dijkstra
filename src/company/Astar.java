package company;

public class Astar {
    private int[][]heuristic;
    private Graph graph;
    public  Astar(Graph g){
        graph=g;
        heuristic= new int[g.getVertices()][2];//This is a table recording the coordinates of each place on the graph
    }
    public void setLocation(int p, int x, int y){//This add the coordinate for a place
        heuristic[p][0]=x;
        heuristic[p][1]=y;
    }
    public void runAstar(String s, String e) {
        int visit=0;
        int start = graph.findPlace(s);
        boolean[] visited = new boolean[graph.getVertices()];
        System.out.println("Starting from here: " + start);
        int end = graph.findPlace(e);
        MinHeap pathRank = new MinHeap();
        MNode[] places = new MNode[graph.getVertices()];
        MNode[] stable = new MNode[graph.getVertices()];
        MNode[] totald = new MNode[graph.getVertices()];
        for (int i = 0; i < graph.place.length; i++) {
            places[i] = new MNode(start, i, 10000);
            stable[i] = new MNode(start, i, 10000);
            totald[i] = new  MNode(start, i, 10000);
            visited[i] = false;
            if (i == start) {
                places[i] = new MNode(start, i, 0);
                stable[i] = new MNode(start, i, 0);
                totald[i] = new MNode(start, i, 0);
            }
            pathRank.insert(places[i]);

        }

        while (pathRank.size > 0 && pathRank.getRoot().getTo()!=end) {
            MNode inspect = pathRank.getRoot();
         //    System.out.println("If we go from " + graph.place[inspect.getFrom()] + " to " + graph.place[inspect.getTo()] + ". Total distance: " + inspect.getLength());
            MyLinkedList connections = graph.getConnections(inspect.getTo());
            Node con = connections.getFirst();
            for (int j = 0; j < connections.size(); j++) {
                if (!visited[con.getDes()]) {
                    int des = con.getDes();
                    int h = (int)Math.sqrt(Math.pow((double)heuristic[end][0]-heuristic[des][0],2.0)+Math.pow((double)heuristic[end][1]-heuristic[des][1],2.0));
                    int dis = stable[inspect.getTo()].getLength() + con.getDis()+h;
                    int k = totald[inspect.getTo()].getLength() + con.getDis();

                    if (stable[des].getLength() > dis) {

                        // System.out.println("Recalculate path to " + graph.place[des]);
                        pathRank.findMN(des).setLength(dis);
                        pathRank.findMN(des).setFrom(inspect.getTo());

                        stable[des].setLength(dis);
                        stable[des].setFrom(inspect.getTo());
                        totald[des].setLength(k);
                        totald[des].setFrom(inspect.getTo());
                    }
                    visited[inspect.getTo()] = true;
               //     System.out.println("From " + graph.place[inspect.getTo()] + ", we can go to " + graph.place[con.getDes()] + " in total distance: " + dis);
                }
                con = con.getNext();

            }
            pathRank.extractMin();
            visit++;

        }
        System.out.println("We start from " + graph.place[start] + " to go to " + graph.place[end] + ".");
        int backTrack = stable[end].getFrom();
        int currentL = end;
        int tdis =0;
        String direction = "";
        while(backTrack != start){
            direction = "From " + graph.place[backTrack] + ", we go to " + graph.place[currentL] + ".\n" + direction;
            currentL = backTrack;
            backTrack = stable[backTrack].getFrom();
        }
        direction= "From " + graph.place[backTrack] + ", we go to " + graph.place[currentL] + ".\n" + direction;
        direction+="The total/shortest distance is: " + totald[end].getLength();
        System.out.println(direction);
        System.out.println("Total places examined: " + visit + ".");
    }

}
