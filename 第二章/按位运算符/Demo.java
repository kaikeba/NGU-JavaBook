public class Demo {
    public static void main(String[] args) {
        int numX, numY;
        numX = 5;// 101
        numY = 3;// 011
        int numExOr = numX ^ numY;
        int numOr = numX | numY;
        int numAnd = numX & numY;
        System.out.println("101 ^ 011\t" + Integer.toBinaryString(numExOr));
        System.out.println("101 | 011\t" + Integer.toBinaryString(numOr));
        System.out.println("101 & 011\t" + Integer.toBinaryString(numAnd));
    }
}
