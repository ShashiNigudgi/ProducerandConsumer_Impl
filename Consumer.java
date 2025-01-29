public class Consumer implements Runnable{
    private Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }
    public void run()
        {
            while(true){
                try{
                    int getval = buffer.consume();
                    System.out.println("Consumed : " + getval);
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }

                //System.out.println("the value cosumed is :" + getval);
            }

        }
}
