import java.util.HashMap;
import java.util.Map;

/**
 * author:      SaiL1020
 * time:        4/5/17 3:37 PM
 * project:     Algorithm
 */
public class MutableDouble {
    private double value_;
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof MutableDouble &&
                ((MutableDouble) obj).doubleValue().equals(doubleValue());
    }
    @Override
    public int hashCode() {
        return Double.hashCode(doubleValue());
    }

    public Double doubleValue() {
        return value_;
    }
    public MutableDouble(Double num){
        value_ = num;
    }

    public static void main(String[] args) {
        MutableDouble mutableObject = new MutableDouble(3.5);
        Map<MutableDouble, Object> map = new HashMap<>();
        map.put(mutableObject, "test");
//        Object pre = map.put(mutableObject, "haha");
//        System.out.println(pre);
//        System.out.println(map.size());
        double adouble = 3.5;
        System.out.println(map.containsKey(new MutableDouble(adouble)));
    }
}
