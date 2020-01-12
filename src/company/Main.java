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
        campus.randomLength();//This function randomize all paths available on the current map to integer distances between 1 to 10 inclusive.
        campus.showPath("Chapel");
        campus.showPath("Alums");





    }
}
