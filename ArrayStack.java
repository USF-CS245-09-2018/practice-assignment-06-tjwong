public class ArrayStack implements Stack {

    public int size;
    public Object[] arr;
    public int top;


    public ArrayStack(){
        arr = new Object[10];
        top = 0;
        size = 10;
    }

    public void push(Object obj){
        if(top == size){
            Object[] temp = new Object[size *2];
            for(int i =0; i < size; i++){
                temp[i] = arr[i];
            }
            arr = temp;
            size = size * 2;

        }
        arr[top] = obj;
        top++;
    }

    @Override
    public Object pop() {
        if(top > 0){
            return arr[--top];
        }
        else{
            return null;
        }
    }


    @Override
    public Object peek() {
        return arr[top];
    }

    @Override
    public boolean empty() {
        return top == 0;
    }
}
