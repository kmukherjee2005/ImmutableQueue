import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class ImmutableQueue<T> implements Queue<T> {
    private final List<T> queue;
    private int size;

    ImmutableQueue(int size)
    {
        if(size<=0){
            throw  new IllegalArgumentException("Queue size must be greater than 0");
        }

        this.size = size;
        queue = new LinkedList<T>();
    }

    private  ImmutableQueue(List<T> newList){
        queue =  Collections.unmodifiableList(new LinkedList<T>(newList));
    }



    @Override
    public Queue<T> enQueue(T t){

        if(null == t){
            throw new IllegalArgumentException("Value is null");

        }

        if(queue.size()== this.size){
            throw  new IllegalArgumentException("Queue is full");
        }

        List<T> newList = new LinkedList<T>(queue);
        newList.add(t);
        ImmutableQueue<T> newQueue = new ImmutableQueue<T>(newList);

        return newQueue;
    }

    @Override

    public Queue<T> deQueue(){

        if (queue.size() == 0){
            throw  new IllegalArgumentException("Queue size is empty");

        }

        List<T> tmpList = new LinkedList<>(queue);

        ImmutableQueue<T> newQueue = new ImmutableQueue<>(tmpList.subList(1,tmpList.size()));

        return  newQueue;
    }

    @Override
    public T head(){
        return queue.size()>0 ? queue.get(0):null;
    }

    @Override
    public boolean isEmpty(){
        return  queue.size()==0?true:false;
    }
}
