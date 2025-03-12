import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        myCollection.add("Hello");
        myCollection.add("World");
        System.out.println("集合大小：" + myCollection.size());
        System.out.println("集合内容：" + myCollection);
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll.contains(""));
        Object o;
        o.hashCode();
        String s = "";
        s.hashCode();
    }
}
class MyCollection implements Collection<Object>{
    private List<Object> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<Object> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(Object e) {
        return list.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Object> c) {
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    // 为了方便调试，可重写 toString() 方法
    @Override
    public String toString() {
        return list.toString();
    }


}
