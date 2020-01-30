package company;

public class MNode {
    int from;
    int to;
    int length;
    MNode left;
    MNode right;
    MNode parent;
    private boolean visited;
    public MNode(int f, int t, int le){
        from = f;
        to = t;
        length = le;
        visited=false;
    }
    public boolean isVisited() {
        return visited;
    }
    public void visit() {
        visited=true;
    }
    public void setChild(MNode c){
        if(left!=null){
                right = c;
        }
        else{
            left = c;
        }
    }
    public int getFrom(){
        return from;
    }
    public void setFrom(int f){
        from = f;
    }
    public void setTo(int t){
        to = t;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public void setParent(MNode p){
        parent = p;
    }
    public MNode getParent(){
        return parent;
    }
    public MNode getLeft(){
        return left;
    }
    public  MNode getRight(){
        return right;
    }
    public int getLength(){
        return length;
    }
    public void updatePath(int f, int l){
        from = f;
        length = l;
    }
    public int getTo(){
        return to;
    }
    public boolean isFull(){
        if(left!=null && right!=null){
            return true;
        }
        else{
            return false;
        }
    }
    public void setLNull(){
        if(left!=null){
        left = null;}
    }
    public void setRNull(){
        if(right!=null) {
            right = null;
        }
    }
}
