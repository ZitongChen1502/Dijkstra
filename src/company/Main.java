package company;

public class Main {

    public static void main(String[] args) {
        Graph campus = new Graph(14);
        campus.addPlace(0,"Gate");
        campus.addPlace(1,"Admin");
        campus.addPlace(2,"US");
        campus.addPlace(3,"TLot");
        campus.addPlace(4,"SLot");
        campus.addPlace(5,"VA");
        campus.addPlace(6,"GDorm");
        campus.addPlace(7,"Alums");
        campus.addPlace(8,"Chapel");
        campus.addPlace(9,"BDorm");
        campus.addPlace(10,"Sci");
        campus.addPlace(11,"MGH");
        campus.addPlace(12,"CES");
        campus.addPlace(13,"Rock");
        campus.addPath(0,1,1);
        campus.addPath(0,3,3);
        campus.addPath(0,4,1);
        campus.addPath(0,13,1);
        campus.addPath("Admin","US",1);
        campus.addPath(1,4,2);
        campus.addPath(1,7,4);
        campus.addPath("US","TLot",1);
        campus.addPath("US","VA",1);
        campus.addPath(3,6,2);
        campus.addPath(5,6,1);
        campus.addPath(6,7,3);
        campus.addPath(7,8,2);
        campus.addPath(8,9,1);
        campus.addPath(8,12,5);
        campus.addPath("BDorm","Sci",1);
        campus.addPath(10,11,1);
        campus.addPath(11,12,2);
        campus.addPath(11,13,3);
        campus.addPath("CES","Rock",2);
        campus.showPath("Chapel");
        campus.showPath("Alums");
        /*campus.randomLength();//This function randomize all paths available on the current map to integer distances between 1 to 10 inclusive.
        campus.showPath("Chapel");
        campus.showPath("Alums");*
         */
        Astar astar = new Astar(campus);
        astar.setLocation(0,0,0);
        astar.setLocation(1,1,1);
        astar.setLocation(2,1,2);
        astar.setLocation(3,0,2);
        astar.setLocation(4,-1,1);
        astar.setLocation(5,1,3);
        astar.setLocation(6,2,4);
        astar.setLocation(7,5,4);
        astar.setLocation(8,6,2);
        astar.setLocation(9,6,0);
        astar.setLocation(10,5,0);
        astar.setLocation(11,4,0);
        astar.setLocation(12,2,1);
        astar.setLocation(13,1,0);
        /*
        MinHeap k = new MinHeap();
        for(int i = 0; i<10;i++){
            k.insert(new MNode(i,i+1,10-i));
        }
       System.out.println(k.root.getLength());
        System.out.println(k.root.getLeft().getLength());
        System.out.println(k.root.getRight().getLength());
        System.out.println(k.root.getLeft().getLeft().getLength());
        System.out.println(k.root.getRight().getLeft().getLength());
        k.getMin();
        k.extractMin();
        System.out.println(k.root.getLength());
        System.out.println(k.root.getLeft().getLength());
        System.out.println(k.root.getRight().getLength());
        System.out.println(k.root.getLeft().getLeft().getLength());
        System.out.println(k.root.getRight().getLeft().getLength());
        k.remove(k.root.getLeft());
        System.out.println(k.root.getLength());
        System.out.println(k.root.getLeft().getLength());
        System.out.println(k.root.getRight().getLength());
        System.out.println(k.root.getLeft().getLeft().getLength());
        System.out.println(k.root.getRight().getLeft().getLength());

        MaxHeap j = new MaxHeap();
        for(int i = 0; i<10;i++){
            j.insert(new MNode(i,i+1,i+1));
        }
        System.out.println(j.root.getLength());
        System.out.println(j.root.getLeft().getLength());
        System.out.println(j.root.getRight().getLength());
        System.out.println(j.root.getLeft().getLeft().getLength());
        System.out.println(j.root.getRight().getLeft().getLength());
        j.getMax();
        j.extractMax();
        System.out.println(j.root.getLength());
        System.out.println(j.root.getLeft().getLength());
        System.out.println(j.root.getRight().getLength());
        System.out.println(j.root.getLeft().getLeft().getLength());
        System.out.println(j.root.getRight().getLeft().getLength());
        j.remove(j.root.getLeft());
        System.out.println(j.root.getLength());
        System.out.println(j.root.getLeft().getLength());
        System.out.println(j.root.getRight().getLength());
        System.out.println(j.root.getLeft().getLeft().getLength());
        System.out.println(j.root.getRight().getLeft().getLength());
        */
        System.out.println("This is Dijkstra:");
        Dijkstra Wednesday = new Dijkstra("CES", "Chapel", campus);
        System.out.println("This is A star:");
        astar.runAstar("CES", "Chapel");
        System.out.println("This is Dijkstra:");
        Dijkstra Lunch = new Dijkstra("US", "MGH",campus);
        System.out.println("This is A star:");
        astar.runAstar("US", "MGH");



    }
}
