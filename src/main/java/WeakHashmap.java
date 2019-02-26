import java.util.WeakHashMap;
import java.util.HashMap;
import java.util.Map;

public class WeakHashmap{
    public static void main(String[] args){
        Map<Order, String> orderBy = new WeakHashMap<>();
        Order or1 = new Order("101","4");
        orderBy.put(or1,"Namu");

        orderBy.put((new Order("102","7")),"Arjun");
        orderBy.put((new Order("103","6")),"Bhargav");

        System.out.println("Size of orderBy map : " + orderBy.size());

        System.gc();

        System.out.println("Size of orderBy map After garbage collector run : " + orderBy.size());
    }
}

class Order{
    String orderNum;
    String orderQuan;

    public Order(String orderNum, String orderQuan){
        this.orderNum = orderNum;
        this.orderQuan = orderQuan;
    }

}
