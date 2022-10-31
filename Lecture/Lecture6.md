# 例外

## 例外とは

プログラムの実行中に何らかの異常が発生し、動作を続けられなくなった場合に特別なクラスが自動的にインスタンス化される。  
この特別なクラスの事を例外(Exception, エクセプション)と言い、基本的に例外が発生するとプログラムがエラー終了する。  
例外クラスは数十種類あり、それぞれ例外が発生する(例外が発生することを一般に “例外が投げられる” とも言う。  
　理由は後述)箇所、場面によってその例外は異なる。  
例えば、ファイル読込に使うFileInputStreamクラスを用いてファイルの操作をする場合、仮に指定したファイルが存在しなかった時に、FileNotFoundExceptionという例外が発生する。

## 例外処理

仮に例外が発生した場合でも、何らかの処理により正常な状態に復帰できる場合がある。  
例えば、特定のファイルが見つからず、FileNotFoundExceptionが発生した場合に、「ファイルが見つかりませんでした。もう一度パスを入力してください」と表示して再入力させるなど。  

このように、プログラムがエラーや異常によって正しく動作しない場合に通常の処理と区別して行う特別な処理を例外処理という。
例外処理を行うことで、エラーが発生してもプログラムを安全に継続、終了することができる。
例外および例外を処理する機構はオブジェクト指向を取り入れた様々な言語で使われている。

## Javaにおける例外ハンドラ

例外処理を実現するプログラム上の仕組みや文法を例外ハンドラと呼ぶ。
Javaにおいて、例外処理をするには try-catch文 を用いる。  
try{}の{}内のことをtry句、catch{}の{}内のことをcatch句と呼ぶ。
try句には例外が発生する可能性のある処理を記述し、もし実際に例外が投げられた場合はcatch句に処理が移行する。  
catch句への処理の移行は、try句の処理が残っていたとしても例外が発生すれば強制的に移行し、catch句の処理が終わった後でも続きから再開することは無い。

```java
try {
	/* 例外(Exception)が発生する可能性のある処理 */
} catch (Exception e){
	// 例外処理
}
```

例として、このような文をmain()中に書くとする。

```java
FileInputStream fis = new FileInputStream(“hogehoge.err”);
```

“ハンドルされていない例外FileNotFoundException” と表示されてコンパイルが通らないはずである。  
FileInputStreamはファイル読込に関わるクラスだが、ファイルが存在しないとFileNotFoundExceptionを発生させる。  
次に、このプログラムのコンパイルを通し、エラー終了させない方法について解説する。  
先ほどのコードを以下のように編集したとする。

```java
try {
	FileInputStream fis = new FileInputStream(“hogehoge.err”);
	System.out.println(“ファイル読込に成功しました。”);
} catch (Exception e) {
	System.out.println(“エラー！”);
}
```

実行すると、「ファイル読み込みに成功しました」と表示されずに、「エラー！」と表示される。

ここで、catchキーワードの直後にある丸括弧()の中に注目すると、Exceptionという記述がある。  
これは、どの例外が発生したときに、そのcatchブロックの処理を行うかを表すものである。

また、全ての例外クラスはExceptionクラスを継承しているため、以下のように記述するとどのような例外が発生した場合でもそのcatch句に処理が移行する。

```java
try{
	// 例外が発生する処理
}
catch (Exception e){
	e.printStackTrace();
}
```

例外が発生し、例外クラスをインスタンス化することをthrowといい(厳密には異なる)、例外が発生することを “例外が投げられる” もしくは”throwされる” という。  
また、一つのtry句につきcatch句の数はいくつでもよいため、一つのtry句の中で複数種類のExceptionが投げられる可能性がある場合、以下のように記述することで、投げられた例外に応じた例外処理が可能である。

```java
try{
	//複数種類の例外が投げられる可能性のある処理
}
catch(FileNotFoundException e){
	// ファイルが見つからなかった
}
catch(IOException e){
	// IOで問題発生
}
catch(IllegalArgumentException e){
	// 引数がおかしい
}
```


## 例外の種類

Javaにおける例外には大きく分けて以下の2種類がある。  
* 検査例外
  * 処理を行うプログラムをコンパイルする段階で起こりうることが想定される例外に対して用いる。
  * 検査例外の発生する処理は必ずtry句で囲い、適切なcatch句を記述して例外を捕捉しなければならない
* 非検査例外
  * プログラムを実行した際に状況によって起こるかもしれない例外。
  * 非検査例外の発生する処理は必ずしもtry句で囲う必要はない  

基本的に、検査例外はプログラマーが回避しようのない場合に用いられる。　　
また、プログラムが正確に構築できていれば非検査例外が発生することは基本的に無い。
検査例外は必ず、非検査例外は必要に応じて例外処理を準備する。

## 例外クラスの例

代表的な例外クラスを以下に示す。

### 検査例外クラス

```java

IOException		//何らかの入出力に異常があった
NoSuchFileException	//入出力先のファイルが見つからなかった
SQLException		//入出力先のデータベースに異常があった

```

### 非検査例外クラス

```java

NullPointerException		//メソッドを利用しようとしたオブジェクトや変数がnull(空)だった
IndexOutOfBoundsException	//配列(要素数の宣言必要)やCollections(要素数の宣言不要)のサイズを超えた
IllegalArgumentException	//メソッドに不適切な引数を渡した
ClassCastException		//キャストできないクラスに変換しようとした

```

## 演習課題

### 課題1

Exercise6_1クラスを作成し、その中にmain()メソッドを追加する。  
Scannerクラスのnext〇〇()系のメソッドは、標準入力からの入力を〇〇に変換できなかった場合にInputMismatchExceptionを投げる。  

#### Exercise6_1クラス

* main()
  * ScannerのnextDouble()メソッドを用いて64bit浮動小数点数を入力させ、入力後その値を表示させなさい
  * ただし、浮動小数点数以外の値を入力したときにはInputMismatchExceptionが投げられるため、これをcatchし ”エラー.” と出力しなさい

#### 実行結果


```java
小数値を入力してください:
> hogehoge
エラー.

小数値を入力してください:
> 42.195
入力した値:  42.195
```
[Githubにcommit/pushする](https://github.com/fujiitomoko/ProjectMember2022Document/blob/main/Lecture/Lecture1.md#Githubにプロジェクトをpushする)

### 課題2

Randomクラスは乱数を提供するクラスである。  
Randomクラスのインスタンスメソッド、
`int nextInt(int max)`
を用いることで、 0以上max未満の値をランダムに返す。

```java
Random random = new Random();
System.out.println(random.nextInt(100));		// 0~99の値を表示
```
[Githubにcommit/pushする](https://github.com/fujiitomoko/ProjectMember2022Document/blob/main/Lecture/Lecture1.md#Githubにプロジェクトをpushする)


#### Exercise6_2クラス

* main()
  * ArrayList<Integer>の中に1~6のランダムな値を持つIntegerクラスのインスタンスを5個追加しなさい
  * その後Scannerを用いて標準入力に入力された整数値を取得しint型のindexに代入し、上で作ったArrayList<Integer>のindex番目の値を表示させなさい
  * ただし、ArrayListの範囲外の要素にアクセスしようとしたときに投げられるExceptionをcatchし、適切に処理せよ(Exception自体をcatchせず、具体的な〇〇Exceptionをcatchしなさい)

#### 実行結果


```java
さいころを5つ振りました.
何番目のさいころの値を確認しますか？
> 12
ArrayListの範囲外アクセスを確認しました.
プログラムを終了します.
```
[Githubにcommit/pushする](https://github.com/fujiitomoko/ProjectMember2022Document/blob/main/Lecture/Lecture1.md#Githubにプロジェクトをpushする)


### 課題3

Exercise6_2クラスを改良し、標準入力で32bit符号付整数以外が入力されたときにcatchブロックで例外処理を行うようにする。

#### Exercise6_2クラス

* main()
  * 課題2で作成したプログラムに、標準入力で32bit符号付整数以外が入力されたときに例外処理を行うためのcatch()句を追加する。
  * ただし、Exception自体をcatchせず、具体的な〇〇Exceptionをcatchすること。
  
#### 実行結果の例

```java
さいころを５つ振りました。
何番目のさいころの値を確認しますか？
> hogehoge
整数以外の値が入力されました。
プログラムを終了します。
```
[Githubにcommit/pushする](https://github.com/fujiitomoko/ProjectMember2022Document/blob/main/Lecture/Lecture1.md#Githubにプロジェクトをpushする)

上の例では、「整数以外の値が入力されました。」としているが、厳密にはint型は整数であっても-2147483648 ~ 2147483647の間の値しか扱うことができないことに注意。

[目次へ](../README.md)
