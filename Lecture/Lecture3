# ライブラリの利用

## ライブラリ(クラスライブラリ)とは

汎用的に使われる機能を誰もが利用できるようにまとめたもの。  
Javaの場合はクラス群となるため、クラスライブラリとも呼ぶ。  
自ら開発しなくても様々なプログラム部品がライブラリとして用意されている。  

Javaでは対応するパッケージを import することでそのパッケージに属するクラスを使用することが出来る。  
例えば`import java.util.Scanner;`と記述すると、java.util パッケージ内のScannerというクラスを使用します、という意味になる。  

## 標準ライブラリと外部ライブラリ

プログラミング言語に元から備わっているライブラリを「標準ライブラリ」と呼ぶ。  
C言語における <stdio.h> や <stdlib.h> などがこれにあたる。  
Javaにおいては標準で付属しているクラスのことを指す。  

有志の開発者などが独自に開発するなど、プログラミング言語の外部で開発されたライブラリを「外部ライブラリ」呼ぶ。  


## クラスライブラリの種類

Javaには様々なライブラリが存在する。
例としては、  
* `java.util.ArrayList`
    * 可変長な配列(長さが理論上無限な配列)ArrayListを提供する
* `java.util.Scanner`
    * 標準入力からの入力を受け付けるScannerを提供する(scanf()のようなもの)
* `java.util.Random`
    * 乱数を生成するRandomを提供する(rand()のようなもの)  
クラスライブラリの詳細は[こちら](https://docs.oracle.com/javase/jp/11/docs/api/index.html)(Java SE 11)から確認可能


## クラスライブラリを使用する

クラスライブラリのScannerをimportし、実際に使用する場合、以下のように記述する。  
補足:
* 大体の場合はIDEが自動的にimportしてくれる。
* 全く同じ名称のクラスが別のライブラリに存在する場合もあるため、その際は注意してインポートする。

```java
import java.util.Scanner;		// Scannerを使うという宣言

public class Main {
  public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        // 1行分の文字列入力を受け付ける
		String input = scanner.nextLine();
	}
}
```

## java.util.Scannerクラス

Scannerクラスは標準入力からの入力を受け付ける。  
コンストラクタにはどこからの入力を受け付けるのかを記述する。  
コンソールからの入力を受け付ける場合の例:
`Scanner scanner = new Scanner(System.in);`  
また、Scannerは以下のメソッドを持つ(よく使うもののみ抜粋する)  

```java
String nextLine()		// 入力された1行分の文字列を読み取って返す
String next()			// 入力された文字列の内、空白までの文字列を返す
int nextInt()			// 入力された32bit整数値を返す
double nextDouble()	// 入力された64bit浮動小数点値を返す
```

以下、標準入力から32bit整数値を受け取り、その値を表示する例を示す。

```java
Scanner scanner = new Scanner(System.in);
int input = scanner.nextInt();		// 32bit整数値の入力受け付け
System.out.println(“入力された整数 = ” + input);

実行例:
> 64
入力された整数 = 64
```
文字列の解析にも利用できる。

```java
Scanner scanner=new Scanner("123");	// 文字列"123"を解析
System.out.println(scanner.nextInt());

実行例:
123
```

## java.util.ArrayListクラス

ArrayListクラスは、サイズが理論上無制限の可変長配列を提供する。  
長さを変更する(要素の追加･削除)場合は配列ではなく、ArrayListを使う(固定長でいい場合は配列の方が高速)。
複数の値やインスタンスをとりまとめて管理することができる。
インスタンス化する際に、どういった型のArrayListを用意するのかを型引数という形で宣言しなければならない。  
型引数は <> の中に記述する。  
以下、Student型およびDog型のArrayListをインスタンス化する場合の例を示す。  

```java
ArrayList<Student> students = new ArrayList<Student>();

//JavaSE7からは以下のように右辺の型引数を省略可能になった。
ArrayList<Student> students = new ArrayList<>();
ArrayList<Dog> dogs = new ArrayList<>();
```

上の <> の中に書かれている型が型引数である。  
= の前後で型引数を同じにしなければならない。 

## java.util.ArrayListクラスの持つメソッド

ArrayListクラスはインスタンス化することで以下のメソッドが使用可能になる。  
ただし、ここではよく使うメソッドのみを挙げる。

```java
void add(Engine engine)			//Eクラスのengineインスタンスを末尾に追加する(例: Car型のcar、Tire型のtire )

E get(int index)		//index番目の要素を返す(例: arrayList.get(15) )

int size()				//要素数を返す(例: for(int i=0; i<arrayList.size(); i++){ /*  */ } )

boolean isEmpty()	//要素数が0ならtrue、そうでなければfalseを返す
(例: if(arrayList.isEmpty()){  /* 処理 */  }  )

remove(int index｜Object o)		//指定の要素を削除  
```


## java.util.ArrayListクラスの使用例

以下、Studentクラスのコンストラクタを、Student型を型引数とするArrayListに追加しgetName()を呼び出す例を示す。

```java
ArrayList<Student> students = new ArrayList<>();
students.add(new Student(“佐藤”,21));		// 佐藤を末尾(0番目)に追加
students.add(new Student(“鈴木”,20));		// 鈴木を末尾(1番目)に追加
//studentsの要素数分繰り返えしを行う
for(int i = 0; i < students.size(); i++){
	students.get(i).getName();		// studentsのi番目に格納されている要素を参照し、getName()を呼び出す
}
```

## 拡張for文

Java SE 5.0以降の機能  
for(int i...の書き方よりも記述を簡略化することができる。  
ArrayListなどの要素を、一つずつ変数に取り出して繰り返し処理をするためのfor文。

以下、先程の例のfor文を拡張for文を用いて表す。

```java
for(Student student : students){
	student.getName();		// studentsの要素を一つずつstudentに取り出し、処理を行う
}
```

## 型引数にプリミティブ型をとるArrayList(発展)

ArrayListの型引数に、int型やlong型、double型などのプリミティブ型を渡そうとすると、エラーが出る。  
つまり、
`ArrayList<int> numbers = new ArrayList<>();	// ダメ！`
と記述が出来ないということである。  
ここで用いるのが、各プリミティブ型のラッパークラスであり、プリミティブ型をその名の通りラッピングするクラスのことである。  
例えば、int型ならIntegerクラス、double型ならDoubleクラスなど、プリミティブ型それぞれに対応するラッパークラスが用意されている。  

以上のことから、int型の値をListとして保持しておきたい場合、以下のように記述する。  
`ArrayList<Integer> numbers = new ArrayList<>();`  


## より詳しく知りたい場合

ArrayListの型引数にプリミティブ型の値を渡せないのは、ArrayListの定義が,

`ArrayList<E>`

でありそもそもEという型はクラスでなければならないためである。  
加えて、ArrayList<E>というクラスは、List<>というインターフェースを実装しているため(厳密には違う)、
	
`List<E> list = new ArrayList<>();`
という書き方が一般によく用いられる。

さらに詳しく知りたい場合は[こちら](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Integer.html)からドキュメントを参照すること。



## 演習課題

### 課題1

Exercise3_1クラスを作成し、その中にmain()メソッドを作成すること。  

#### Exercise3_1クラス

* main()
  * Scannerを用いて標準入力から任意の文字列を1行分取得し、それを標準出力に表示せよ

#### 実行結果

```java
任意の文字列を入力してください: 
> こんにちは。
“こんにちは。” と入力されました
```

以降、 実行結果のうち、 “>” から始まる行は標準入力に入力した文字列とする。

### 課題2

Exercise3_2クラスを作成し、その中にmain()メソッドを作成すること。  
標準入力からの入力を受け付け、任意の行数分、任意の文字列を受け取るプログラムを作成しなさい。  

#### Exercise3_2クラス

* main()
  * Scannerをインスタンス化し、初めに何行分の文字列を入力させるかを入力させる
  * 指定された行数分入力を受け付け、それらの文字列をArrayListに追加しなさい
  * また、入力終了後、入力したすべての文字列を表示しなさい
  * ただし、表示は拡張for文を用いて行うものとする

__注意__

**数値を読み取る際、ストリームに改行コードが残ってしまうため、nextLine()で空読みすること。**

#### 実行結果


```java
何行分入力しますか？
> 2
1行目:
> これは1行目の文字列かもしれない
2行目:
> これは2行目の文字列だと思います
入力した文字列:
[0] これは1行目の文字列かもしれない
[1] これは2行目の文字列だと思います
```

### 課題3

Exercise3_3クラスを作成し、その中にmain()メソッドを作成すること。  
標準入力からの入力を2回分受け付けて、それを32bit整数値に変換した値を変数に代入し、それらの和を表示させなさい(実行結果を参照)  

#### Exercise3_3クラス

* main()
  * Scannerクラスを用いて標準入力から2回文字列を受け取り、その値を32bit整数に変換したのち、その和を表示させる
  * 受け取った文字列を32bit整数値に変換するには、Integerクラスのメソッドである`parseInt()`を用いること

#### 実行結果


```java
1つ目の整数を入力してください:
> 35
2つ目の整数を入力してください:
> 42
35 + 42 = 77
```

### 課題4

VegetableクラスとExercise3_4クラスを作成し、Exercise3_4クラスの中にmain()メソッドを作成すること。


#### Vegetable
* フィールド
  * 野菜の名前を格納するString型のnameと値段を格納するint型のvalueを持つようにすること。    
* コンストラクタ
  * コンストラクタの引数はString型のnameとint型のvalueとなるようにすること。
  * コンストラクタで引数のString型のnameとint型のvalueをフィールドのnameとvalueにセットできるようにすること。
* print()
  * 引数及び戻り値無しのprint()メソッドを作成すること。
  * このメソッドでは標準出力で、野菜の名前と値段を「～は～円」といったように表示すること。  

#### Exercise3_4

* main()
  * 型引数がVegetable型のArrayListを作成する。
  * 作成したArrayListの中に、Vegetableクラスのインスタンスを加えていくこと。
  * インスタンス化する際には、Vegetableクラスのコンストラクタに("にんじん",117)、("たまねぎ",120)、("じゃがいも",154)の3セットを渡すこと。
  * 繰り返し処理を用いて作成したリスト内のインスタンスからprint()メソッドを呼び出し、野菜の名前と値段をすべて表示すること。  

[目次へ](../README.md)
