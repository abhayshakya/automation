package programming;

public class program extends program2{

    void  add (int a, int b){
        int c = a+b;
        System.out.println("addition of Number="+c);
    }

    void multiply(int a, int b){
        int m = a*b;
        System.out.println("Multiply of Number="+m);
    }

    void substract(int a, int b){
        int s = a-b;
        System.out.println("Multiply of Number="+s);

    }

    public static void main(String[] args) {
        program p1 = new program();
        p1.add(10,20);
        p1.multiply(5,2);
        p1.substract(20,12);
    }


}
