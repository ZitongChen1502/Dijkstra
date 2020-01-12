package company;

public class MyLinkedList {
    Node head;

    public MyLinkedList(){

    }
    public boolean add(Node n){
        return addN(n,head);
    }
    private boolean addN(Node n, Node pointer){
        if(head==null){
            head = n;
            return true;
        }
        else if(pointer.isEnd()==true){
            pointer.setNext(n);
            return true;
        }
        else{
            return addN(n, pointer.getNext());
        }
    }

    public void addFirst(Node n){
        n.setNext(head);
        head = n;
    }

    public void addLast(Node n){
        boolean finish = this.add(head);
    }

    public void clear(){
        head = null;
    }

    public Node getFirst(){
        return head;
    }

    public Node getLast(){
        Node last = head;
        while(last.isEnd() == false){
            last = last.getNext();
        }
       return last;
    }

   /* public void displayList(){
        Node last = head;
        while(last.isEnd() == false){
            System.out.println(last.getData());
            last = last.getNext();
        }
        System.out.println(this.getLast().getData());
    }*/
    public Node removeFirst(){
        Node first = head;
        head = first.getNext();
        return first;
    }

    /*public boolean remove(Node n){
        if(head.getData()== n.getData()){
            Node finish =this.removeFirst();
            return true;
        }

        else{
            Node search = head;
            boolean exist = false;
            while(search.isEnd()==false){
                if(search.getNext().getData() != n.getData()){
                    search = search.getNext();
                }
                else{search.setNext(search.getNext().getNext());
                    exist = true;
                }
            }
            return exist;
        }
    }
*/
    public Node set(int index, Node n){
        Node bye;
        if(this.size() +1 < index){
            return null;
        }
        else if(this.size() == index-1){
            this.addLast(n);
            return null;
        }
        else if(index ==0) {
            bye = head;
            n.setNext(head.getNext());
            head = n;
            return bye;
        }
        else{
            bye = head;
            for(int i = 1; i<index-1; i++){
                bye = head.getNext();
            }
            Node orig = bye;
            n.setNext(bye.getNext().getNext());
            bye.setNext(n);
            return orig.getNext();
        }
    }

    public int size(){
        int size = 0;
        Node pointer= head;
        while(pointer != null){
            size++;
            pointer= pointer.getNext();
        }
        return size;
    }
    public Node findP(int index) {
        Node pointer = head;
        while (pointer != null) {
            if (pointer.getDes() == index) {
                break;
            } else if (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
        }
        return pointer;
    }


}
