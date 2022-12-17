package lecture05;

public class Exercise5_3 {
    public static void main(String[] args) {
        Insect insect = new Butterfly();
        //型とインスタンス、違うクラス名でも構造が同じなら代入できる
        insect.move();
    }
}
