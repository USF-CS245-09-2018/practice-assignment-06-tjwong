
public class ArrayQueue implements Queue{

    public Object[] arr;
    public int size;
    public int head;
    public int tail;


    public ArrayQueue(){
        arr = new Object[10];
        head = 0;
        tail = 0;
        size = 10;
    }

    @Override
    public Object dequeue() {
        Object temp;

        if(head == tail){
            return null;
        }
        temp = arr[head];
        head = (head + 1) % size;
        return temp;
    }


    @Override
    public void enqueue(Object item) {
        if((tail + 1) % size == head){
           growQueue();
        }
        arr[tail] = item;
        tail = (tail + 1) % size;
    }

    @Override
    public boolean empty() {
        return head==tail;
    }

    protected void growQueue(){
        int index = 0;
        Object[] tempdata = new Object[size * 2];
        if (head > tail) {
            for (int j = head; j < arr.length; j++) {
                tempdata[index++] = arr[j];
            }
            for (int j = 0; j < tail; j++) {
                tempdata[index++] = arr[j];
            }
            head = 0;
            tail = arr.length - 1;
        } else {
            for (int i = index; i < size; i++)
                tempdata[i] = arr[i];
        }
        arr = tempdata;
        size = size * 2;
    }
}
