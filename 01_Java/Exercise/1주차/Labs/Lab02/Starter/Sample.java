public class Sample {
    public static void main(String[] args) {
        int[] tables = {2,3,4,5,6,7,8,9};

        int sum = 0;
        for(int i : tables) {
            if(i == 5) {
                continue;
            }
            sum += i;
        }
        System.out.println(sum);
    }
}
