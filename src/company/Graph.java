package company;

public class Graph {
    int Vertices;
    MyLinkedList[] graph;
    String[] place;
    public Graph(int v){
        Vertices = v;
        graph = new MyLinkedList[v];
        place = new String[v];
        for(int i=0; i<v; i++){
            graph[i] = new MyLinkedList();
        }
    }
    public void addPlace(int index, String name){
        if(place[index]==null){
        place[index] = name;}
        else{
            System.out.println("Index occupied.");
        }
    }
    public int findPlace(String name){
        int index =-1;
        for(int i = 0; i<place.length;i++){
            if(place[i].equals(name)){
                index =i;
                break;
            }
        }
       return index;
    }

    public void addPath(int v1, int v2, int dis){
        if(v1>=0 && v2>=0 && v1<=graph.length && v2<=graph.length) {
            graph[v1].add(new Node(v2, dis));
            graph[v2].add(new Node(v1, dis));
        }
        else{
            System.out.println("Index out of bound.");
        }
    }
    public void addPath(String p1, String p2, int dis){
        int v1 = findPlace(p1);
        int v2 = findPlace(p2);
        addPath(v1, v2,dis);
    }
    public void modDis(int v1, int v2, int dis){
        graph[v1].add(new Node(v2, dis));
        graph[v2].add(new Node(v1, dis));
    }
    public void showPath(String pl){
        int index = findPlace(pl);
        Node des = graph[index].getFirst();
        if(des==null){
            System.out.println("You can't go anywhere from " + pl +". I guess you need a helicopter.");
        }
        else{
            System.out.println("From " + pl+", you can go to:");
        }
        while(des!=null){
            index=des.getDes();
            System.out.println(place[index] + " in distance " + des.getDis()+ ".");
            des = des.getNext();
            if(des!=null) {
                index = des.getDes();
            }
        }
    }
    public void randomLength(){
        for(int i=0; i<graph.length;i++){
            Node destination = graph[i].getFirst();
            while(destination!=null){
                int des =destination.getDes();
                if(i<des){
                    int newDis = (int)(Math.random()*9)+1;
                    Node correspond=graph[des].getFirst();
                    while(correspond.getDes()!=i){
                        correspond=correspond.getNext();
                    }
                    destination.setDis(newDis);
                    correspond.setDis(newDis);
                }
                destination=destination.getNext();
            }
        }
    }
    public MyLinkedList getConnections(int i){
        return graph[i];
    }
    public int getVertices(){
        return Vertices;
    }
}
