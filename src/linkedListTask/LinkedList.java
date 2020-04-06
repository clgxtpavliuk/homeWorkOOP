package linkedListTask;

public class LinkedList<V> {
    private Item<V> tail;
    int count;

    public LinkedList() {
        this.tail = null;
        this.count = 0;
    }

    public void add(V data) {
        Item<V> newValue = new Item<V>(data);
        if (this.tail == null) {
        } else {
            newValue.prev = tail;
            tail.next = newValue;
        }
        this.count++;
        this.tail = newValue;
    }

    public V remove(int index) {
        Item<V> needValue;
        int number = count - index - 1;
        needValue = tail;
        while (number > 0) {
            needValue = needValue.prev;
            number--;
        }
        if (index == 0) {
            needValue.next.prev = null;
            count--;
        } else if (index == count-1) {
            tail = tail.prev;
            tail.next = null;
            count--;
        } else {
            needValue.prev.next = needValue.next;
            needValue.next.prev = needValue.prev;
            count--;
        }
        return needValue.value;
    }

    public V get(int index) {
        Item<V> needValue;
        int number = count - index - 1;
        if (index > count - 1) {
            throw new IllegalArgumentException("Index " + index + " does not exist");
        }
        needValue = tail;
        while (number > 0) {
            needValue = needValue.prev;
            number--;
        }
        return needValue.value;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        Item temp = tail;
        while (hasPrev(temp)) {
            temp = temp.prev;
        }
        final StringBuilder sb = new StringBuilder();
        while (hasNext(temp)) {
            sb.append(temp);
            sb.append(", ");
            temp = temp.next;
        }
        sb.append(temp);
        return sb.toString();
    }

    public boolean hasNext(Item item) {
        boolean result = false;
        if (item.next != null) {
            result = true;
        }
        return result;
    }

    public boolean hasPrev(Item item) {
        boolean result = false;
        if (item.prev != null) {
            result = true;
        }
        return result;
    }
}
