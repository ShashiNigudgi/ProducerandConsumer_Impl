import java.util.LinkedList;
import java.util.Queue;
//this is the shared resource:-
public class Buffer {

    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();
    boolean valueset = false;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    //producer adds items to the buffer:
    public synchronized void produce(int value) throws InterruptedException {

       //System.out.println(queue.size());


        /*while(valueset){
            wait();
        }*/

        while (queue.size() == capacity) {
            System.out.println("buffer is full :");
            wait();
        }

        queue.add(value);
        System.out.println("Produced : " +value);
        valueset = true;
        notify();

        System.out.println("total queue :"+queue);
    }

    public synchronized int consume() throws InterruptedException {

        while (queue.isEmpty()){
            System.out.println("consumer is empty :");
                wait();
        }
        /*while(!valueset){
            wait();
        }*/

        int value = queue.poll();
        valueset = false;
        notify();
        return value;

    }
}
