public class Demo {
    public static void main(String[] args) {
        int numA, numB, numC, numD;
        numA = -9;
        numB = numA << 2;
        numC = numA >> 2;
        numD = numA >>> 2;
        System.out.println("numA:" + Integer.toBinaryString(numA));
        System.out.println("numB:" + Integer.toBinaryString(numB));
        System.out.println("numC:" + Integer.toBinaryString(numC));
        System.out.println("numD:" + Integer.toBinaryString(numD));

    }
}
