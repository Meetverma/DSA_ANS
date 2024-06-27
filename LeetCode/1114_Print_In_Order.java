//Time Complexity: O(1)
// Space Complexity: O(1)

class Foo {

    private final Lock lock = new ReentrantLock();
    private final Condition firstDone = lock.newCondition();
    private final Condition secondDone = lock.newCondition();
    private boolean isFirstDone = false;
    private boolean isSecondDone = false;

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            printFirst.run();
            isFirstDone = true;
            firstDone.signal();
        }
        finally{
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while(!isFirstDone){
                firstDone.await();
            }
            printSecond.run();
            isSecondDone = true;
            secondDone.signal();
        }
        finally{
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while( !isSecondDone){
                secondDone.await();
            }
            printThird.run();
        }
        finally {
            lock.unlock();
        }
    }
}
