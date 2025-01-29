public class Producer implements Runnable {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run()
    {
        int value = 0;
        while (true){
            try{
                buffer.produce(value++);
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }

            //System.out.println("value added:" +value);
        }
    }
}
