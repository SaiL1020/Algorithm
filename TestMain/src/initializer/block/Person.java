package initializer.block;

/**
 * author:      SaiL1020
 * time:        3/30/17 11:55 PM
 * project:     Algorithm
 */
public class Person {
    private String name;
    public Person(String name){
        this.name = name;
        System.out.println("构造方法执行...");
    }
    // 实例化代码块，先于构造方法执行，每次创造实例都会执行。可供多个构造函数共享。
    // The Java compiler copies initializer blocks into every constructor.
    // Therefore, this approach can be used to share a block of code between multiple constructors.
    {
        System.out.println("实例初始化...");
    }
    {

    }
    // 静态实例化代码块，更先执行，只执行一次。可以有多个，按顺序执行。
    // whatever code is needed for initialization goes here
    static {
        System.out.println("静态初始化...");
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
