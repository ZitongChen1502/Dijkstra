package company;

public class Dijkstra {
    public Dijkstra(String s, String e, Graph g) {
        Graph graph = g;
        int start = g.findPlace(s);
        boolean[] visited = new boolean[graph.getVertices()];
        System.out.println("Starting from here: " + start);
        int end = g.findPlace(e);
        MinHeap pathRank = new MinHeap();
        MNode[] places = new MNode[graph.getVertices()];
        MNode[] stable = new MNode[graph.getVertices()];
        for (int i = 0; i < graph.place.length; i++) {
            places[i] = new MNode(start, i, 10000);
            stable[i] = new MNode(start, i, 10000);
            visited[i] = false;
            if (i == start) {
                places[i] = new MNode(start, i, 0);
                stable[i] = new MNode(start, i, 0);
            }
            pathRank.insert(places[i]);

        }

        while (pathRank.size > 0) {
            MNode inspect = pathRank.getRoot();
            //System.out.println("If we go from " + graph.place[inspect.getFrom()] + " to " + graph.place[inspect.getTo()] + ". Total distance: " + inspect.getLength());
            MyLinkedList connections = g.getConnections(inspect.getTo());
            Node con = connections.getFirst();

            for (int j = 0; j < connections.size(); j++) {
                if (!visited[con.getDes()]) {
                    int des = con.getDes();
                    int dis = stable[inspect.getTo()].getLength() + con.getDis();

                    if (stable[des].getLength() > dis) {

                       // System.out.println("Recalculate path to " + graph.place[des]);
                        pathRank.findMN(des).setLength(dis);
                        pathRank.findMN(des).setFrom(inspect.getTo());

                        stable[des].setLength(dis);
                        stable[des].setFrom(inspect.getTo());
                    }
                    visited[inspect.getTo()] = true;
                    //System.out.println("From " + graph.place[inspect.getTo()] + ", we can go to " + graph.place[con.getDes()] + " in total distance: " + dis);
                }

                con = con.getNext();

            }
            pathRank.extractMin();

        }
        System.out.println("We start from " + graph.place[start] + " to go to " + graph.place[end] + ".");
        int backTrack = stable[end].getFrom();
        int currentL = end;
        String direction = "";
        while(backTrack != start){
                direction = "From " + graph.place[backTrack] + ", we go to " + graph.place[currentL] + ".\n" + direction;
            currentL = backTrack;
            backTrack = stable[backTrack].getFrom();
        }
        direction= "From " + graph.place[backTrack] + ", we go to " + graph.place[currentL] + ".\n" + direction;
        direction+="The total/shortest distance is: " + stable[end].getLength();
        System.out.println(direction);
    }

}
