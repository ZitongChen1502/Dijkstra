package company;


public class MaxHeap {
    MNode root;
    int size;
    public MaxHeap(){
        size =0;
    }

    public void insert(MNode m){
        if(root!=null){
            int index = size+1;
            if(index%2!=0){
                index=(index-1)/2;
            }
            else{
                index/=2;
            }
            String findParents ="";
            while(index>1){
                if(index % 2==1){
                    findParents="R" + findParents;
                    index= (index-1)/2;
                }
                else{
                    findParents="L" + findParents;
                    index/=2;
                }
            }
            recursiveAdd(findParents,root,m);//Add node at the end of the tree
            bubbleUp(m);
        }
        else{
            root = m;
        }
        size++;
    }
    public MNode recursiveAdd(String findParents, MNode p, MNode m) {
        if (findParents.length() == 0) {
            MNode k = m;
            k.setParent(p);
            p.setChild(k);
            return null;
        } else {
            if (findParents.substring(0, 1).equals("L")) {
                return recursiveAdd(findParents.substring(1), p.getLeft(), m);
            } else {
                return recursiveAdd(findParents.substring(1), p.getRight(), m);
            }
        }
    }
    public MNode bubbleUp(MNode m){
        int saveF = m.getFrom();
        int saveT = m.getTo();
        int saveL =m.getLength();
        if(m.getParent()!=null) {
            if(m.getLength() > m.getParent().getLength()) {
                m.setFrom(m.getParent().getFrom());
                m.setTo(m.getParent().getTo());
                m.setLength(m.getParent().getLength());
                m.getParent().setFrom(saveF);
                m.getParent().setTo(saveT);
                m.getParent().setLength(saveL);

                return bubbleUp(m.getParent());
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }

    public void remove(MNode m){
        MNode p = root;
        String findLastP="";
        int s = size;
        while(s>1){
            if(s% 2==1){
                findLastP="R" + findLastP;
                s= (s-1)/2;
            }
            else{
                findLastP="L" + findLastP;
                s/=2;
            }
        }
        findLastP=findLastP.substring(0,findLastP.length()-1);
        recursiveDelete(findLastP,root,m);
        bubbleUp(m);
        sinkDown(m);
        size--;
    }
    public MNode recursiveDelete(String path, MNode lastP, MNode m){
        if(path.length()==0) {
            if (lastP.getRight() != null) {
                int saveF =lastP.getRight().getFrom();
                int saveT = lastP.getRight().getTo();
                int saveL = lastP.getRight().getLength();
                lastP.setRNull();
                m.setFrom(saveF);
                m.setTo(saveT);
                m.setLength(saveL);
                return null;
            } else {
                int saveF =lastP.getLeft().getFrom();
                int saveT = lastP.getLeft().getTo();
                int saveL = lastP.getLeft().getLength();
                lastP.setLNull();
                m.setFrom(saveF);
                m.setTo(saveT);
                m.setLength(saveL);
                return null;
            }
        }
        else{
            if (path.substring(0, 1).equals("L")) {
                return recursiveDelete(path.substring(1), lastP.getLeft(), m);
            } else {
                return recursiveDelete(path.substring(1), lastP.getRight(), m);
            }
        }

    }
    public MNode sinkDown(MNode m){
        MNode pointer = m;
        int minLocation =0;
        if(m.getLeft()!=null && m.getRight()!=null) {
            MNode min = m;
            if(m.getLeft().getLength()>min.getLength()){
                min = m.getLeft();
                minLocation =-1;}
            if(m.getRight().getLength()>min.getLength()){
                min=m.getRight();
                minLocation = 1;}
            int saveF =min.getFrom();
            int saveT = min.getTo();
            int saveL =min.getLength();
            if(minLocation==-1) {
                m.getLeft().setFrom(m.getFrom());
                m.getLeft().setTo(m.getTo());
                m.getLeft().setLength(m.getLength());
                m.setFrom(saveF);
                m.setTo(saveT);
                m.setLength(saveL);
                pointer = m.getLeft();
            }
            else if(minLocation==1) {
                m.getRight().setFrom(m.getFrom());
                m.getRight().setTo(m.getTo());
                m.getRight().setLength(m.getLength());
                m.setFrom(saveF);
                m.setTo(saveT);
                m.setLength(saveL);
                pointer = m.getRight();
            }
        }
        if(minLocation!=0){
            return sinkDown(pointer);
        }
        else{
            return null;
        }
    }

    public void getMax(){
        System.out.println("We goes from location " + root.getFrom() + " to location " + root.getTo() + " in " + root.getLength()
                + " distance.");
    }
    public MNode extractMax(){
        MNode original = root;
        remove(root);
        return original;
    }
}
