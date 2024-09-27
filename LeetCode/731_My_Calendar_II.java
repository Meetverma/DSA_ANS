class MyCalendarTwo {

    ArrayList<int[]> bookings1 ;
    ArrayList<int[]> bookings2 ;

    public MyCalendarTwo() {
        bookings1 = new ArrayList<>();
        bookings2 = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i=0;i<bookings2.size();i++){
            int cur[] = bookings2.get(i);
            if(start<cur[1] && end> cur[0]){
                return false;
            }
        }
        for(int i=0;i<bookings1.size();i++){
            int cur[] = bookings1.get(i);
            if(start < cur[1] && end>cur[0]){
                bookings2.add(new int[] {Math.max(cur[0],start),Math.min(cur[1],end)});
            }
        }
        bookings1.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
