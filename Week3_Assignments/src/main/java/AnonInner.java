@FunctionalInterface
interface PopSocket{
    void getAge();
}
public class AnonInner {
    public static void main(String[] args){
        PopSocket a = () -> {System.out.println(22);};
        a.getAge();
    }
}
