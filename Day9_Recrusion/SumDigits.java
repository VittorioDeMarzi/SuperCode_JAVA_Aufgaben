public class SumDigits {
    public static void main(String[] args) {
        int num = 12345;
        int sumDigits = summDigits(num);
        System.out.println(sumDigits);
    }

    private static int summDigits(int num) {
        int index = 0;
        return sum(num, index);
    }
    
    private static int sum(int num, int index) {
        String[] numArray = Integer.toString(num).split("");
        int numAtIndex = Integer.parseInt(numArray[index]);
        if (index == numArray.length-1) {
            return numAtIndex;
        }
        return numAtIndex + sum(num, index+1);
    }
}
