import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTraverse {
    public static void main(String[] args) {
        Collection<String> coll = new HashSet<>();
        coll.add("zhangsan");
        coll.add("lisi");
        coll.add("wangwu");
        // 迭代器
        Iterator it = coll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        // Lambda表达式
        coll.forEach((String s)->{
            System.out.println(s);
        });
        // 增强for
        for(String s : coll){
            System.out.println(s);
        }
    }
}
