package lecture01;

public class Kadai4 {
    public static void main(String[] args) {
        int[] array = new int[100];
        int sum = 0;

        for(int i = 0; i < 100; i++) {
            array[i] = i + 1;
            //System.out.println(array[i]);
        }

        for(int j = 0; j < 100; j++) {
            if(j % 2 == 0) {
                sum += array[j];
                //System.out.println(sum);
            }
        }
        System.out.println(sum);
    }
}
