package company;

public class Node<E> {
    int destination;
    int distance;
    Node next;

    public Node(int des, int dis){
        destination = des;
        distance = dis;
    }
    public void setNext(Node nxt){
        next = nxt;
    }
    public boolean isEnd(){
        if(next == null){
            return true;
        }
        else{
            return false;
        }
    }
    public Node getNext(){
        return next;
    }
    public int getDes(){
        return destination;
    }
    public int getDis(){
        return distance;
    }
    public void setDis(int d){
        distance = d;
    }


}
