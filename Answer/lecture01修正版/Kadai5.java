package lecture01;

public class Kadai5 {
    public static void main(String[] args) {
        int[] score = {41, 85, 72, 38, 80};

        for (int i = 0; i < score.length; i++) {
            if (100 >= score[i] && score[i] >= 90) {
                System.out.println(i + "番" + score[i] + "点" + " 秀");
            } else if (90 > score[i] && score[i] >= 80) {
                System.out.println(i + "番" + score[i] + "点" + " 優");
            } else if (80 > score[i] && score[i] >= 70) {
                System.out.println(i + "番" + score[i] + "点" + " 良");
            } else if (70 > score[i] && score[i] >= 60) {
                System.out.println(i + "番" + score[i] + "点" + " 可");
            } else {
                System.out.println(i + "番" + score[i] + "点" + " 不可");
            }
        }
        int min = min(score);
        int max = max(score);
        double ave = average(score);

        System.out.println("最高点:" + max + "点");
        System.out.println("最低点:" + min + "点");
        System.out.println("平均点:" + ave + "点");
    }

    static int max(int[] score) {
        int max = 0;
        for (int scr : score) {
            if (max < scr) {
                max = scr;
            }
        }
        return max;
    }

    static int min(int[] score) {
        int min = 100;
        for (int scr : score) {
            if (min > scr) {
                min = scr;
            }
        }
        return min;
    }

    static double average(int[] score) {
        double sum = 0;
        int n = 0;
        for (int scr : score) {
            sum += scr;
            n++;
        }
        return sum / n;
    }
}
