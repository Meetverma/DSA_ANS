class MyCircularDeque {
    List<Integer> lst;
    int k;
    public MyCircularDeque(int k) {
        lst = new ArrayList<>(k);
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(lst.size() < k){
            lst.add(0,value);
        }
        else 
            return false;
        
        return true;
    }
    
    public boolean insertLast(int value) {
        if( lst.size()<k ){
            lst.add(value);
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(lst.size()>0){
            lst.remove(0);
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if(lst.size()>0){
            lst.remove(lst.size()-1);
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if(lst.size()>0){
            return lst.get(0);
        }
        return -1;
    }
    
    public int getRear() {
        if(lst.size()>0){
            return lst.get(lst.size()-1);
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return lst.isEmpty();
    }
    
    public boolean isFull() {
        return lst.size() == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
