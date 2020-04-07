package hometask3.linkedListTask;

public class Item <V>{
    public V value;
    public Item <V> next;
    public Item <V> prev;

   public Item (V value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }
}
