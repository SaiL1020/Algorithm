package initializer.block;

import java.util.ArrayList;
import java.util.List;

/**
 * author:      SaiL1020
 * time:        3/30/17 11:54 PM
 * project:     Algorithm
 */
public class Test {
    public static void main(final String[] args) {

        // 匿名内部类
        Person person = new Person("张三"){
            @Override
            public String getName() {
                return super.getName() + "123";
            }
        };
        System.out.println(person.getName());

        Person person2 = new Person("") {{
            setName("李四");
        }};
        System.out.println(person2.getName());

        // 两个大括号的方式初始化(本质上是匿名内部类 + 实例化代码块)
        List<String> personList = new ArrayList<String>(){{
            add("AA");
            add("BB");
            add("CC");

        }};
        for (String s : personList){
            System.out.println(s);
        }

        // 匿名类，必须显式指出类对象的类型，即第二个 String
        String mutableString = "ABC";
        List<String> strList = new ArrayList<String>(){{
            add(mutableString);
        }};

        // 不能改变匿名内部类内所引用的变量，否则会报错：
        // local variables referenced from an inner class must be final or effectively final

        // mutableString = "abc";


        // console
        /*
        静态初始化...
        实例初始化...
        构造方法执行...
        张三123
        实例初始化...
        构造方法执行...
        李四
        AA
        BB
        CC
         */
    }
}
