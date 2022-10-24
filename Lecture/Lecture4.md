# アクセス修飾子とカプセル化

## アクセス範囲/アクセス修飾子

全てのクラス、[フィールド、メソッド](https://github.com/KazukiOtomo/ProjectMemberDocument/blob/main/Lectures/Lecture2.md)にはアクセス範囲が定められており、各クラス、フィールド、メソッドの宣言の前に以下のようなキーワード(アクセス修飾子と呼ぶ)を記述することでアクセス範囲を指定することが出来る。  

|修飾子|公開範囲|
|:-|:-|
|public|全てのクラスから参照可能|
|private|同一クラスのみ参照可能|
|protected|同一クラス/同一パッケージ/サブクラスのみ参照可能|
|(なし/package private)|同一クラス/同一パッケージのみ参照可能|

理解し辛い人は、とりあえず全ての[フィールド/メソッド](https://github.com/KazukiOtomo/ProjectMemberDocument/blob/main/Lectures/Lecture2.md)をprivateとして定義し、必要に応じてprotectedやpublicにすると良い。  

```java
public class Television {
	private boolean power; 
    // Televisionクラスの中でのみアクセス可能
	private double volume;
	private int channel;

	public Television() { // 全てのクラスからアクセス可能
		this.power = false;
		this.volume = 0.0;
		this.channel = 0;
	}	
	
	public void turnPower() {
		this.power = !this.power;
	}
}
```


## アクセサ(セッター, ゲッター)

どのクラスにおいても、全てのフィールドは基本的にprivateもしくはprotected修飾子が付加されているため、外部からアクセスすることが出来ない。そこで、外部からアクセスする必要がある[フィールド](https://github.com/Cist-ProjectMember/ProjectMemberDocuments/blob/master/2020s/course/lectures/lecture02.md#%E3%83%95%E3%82%A3%E3%83%BC%E3%83%AB%E3%83%89%E3%81%A8%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89)にのみ、setter(セッター)、getter(ゲッター)という[メソッド](https://github.com/Cist-ProjectMember/ProjectMemberDocuments/blob/master/2020s/course/lectures/lecture02.md#%E3%83%95%E3%82%A3%E3%83%BC%E3%83%AB%E3%83%89%E3%81%A8%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89)をpublicで定義する。セッターとゲッターをまとめてアクセサと呼ぶ。アクセサはメソッド名の命名に規則があり、それぞれ  

```java
public void setChannel(int channel) {
	this.channel = channel;
}

public int getChannel() {
	return channel;
}
```

と記述する。  


## カプセル化

アクセス修飾子により外部からのアクセス範囲を制限し、アクセサにより利用してもらいたいフィールド/メソッドへのアクセスを禁止することで人為的なバグを減らすことが出来る
現実的な例 :  
テレビのチャンネルは直接ではなく、テレビに付属するチャンネル変更ボタンやリモコンのチャンネル変更ボタンにより変更してほしい。  

カプセル化されていないと以下のようなことができてしまう。

```java
//class
class Student {
	String id;
	String name;
	
	Student(String id, String name) {
		this.id = id;
		this.name = name;
	}
}

//main
public static void main(String[] args) {
	Student student = new Student("b2190999", "大友一樹");
		
	student.id = "aiueo";
	
	System.out.println(student.id);
}

//実行結果
//学籍番号がなのに変な値になってる...
id=aiueo
```

このようなことを防ぐために、正しくカプセル化を行い、アクセサにより[フィールド](https://github.com/Cist-ProjectMember/ProjectMemberDocuments/blob/master/2020s/course/lectures/lecture02.md#%E3%83%95%E3%82%A3%E3%83%BC%E3%83%AB%E3%83%89%E3%81%A8%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89)の値の取りうる範囲を制限する

```java
//class
public class Student {
	private String id;
	private String name;
	
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		if (id.startWith("b2") && id.length <= 8){
			//idが"b2"で始まる かつ ８文字以下である。
			this.id = id;
		} else {
			//error処理をする
		}
	}
}

//main
public static void main(String[] args) {
	Student student = new Student("b2190999", "大友一樹");
		
	//error処理をされて変更されない。
	student.setId("aiueo");
	System.out.println(student.getId());
}

//実行結果
id=b2190999
```

上記のアクセサを利用することで正しく制限することができるようになる。

## クラス図について

クラス図は基本的に以下のように構成される。  
![](http://www.plantuml.com/plantuml/png/SoWkIImgAStDuIhEpimhI2nAp5L8paaiBdOiAIdAJ2ejIVLCpiyBpgnALJ3WuWBBA3nkMl-uUUNZffrF9_HMSt4fFErV_sBPj6SDonM00ayxUnMi59xEwqQHU3QvzydUEK1f1OsdUwO-cxhXSUCwk6Au252N9anpBPT3QbuAq640)

|可視性|意味|
|:--|:--|
|+|public|
|-|private|
|#|protected|
|~|修飾子なし|

## 演習課題

### 課題1

以下のクラスを作成せよ。  

![](http://www.plantuml.com/plantuml/png/JOx1JiOW48JlF0L7Y9fuvjHUZ5wCIPzWssxQJM5fO5kZndUN-fC_723Bp7p3TbaWoH6yoXln3Wc2dZpat8ia6W_1jodoGD-edzM_eLzeMGNJZz9FAyb791PNJddkyHDJdHa2ka4IyQAKVgYGQOb7NO5hRFAsv444fiqWO_Xo5RRkZ3GNatBlwKHZtHYZH-2YBIYljTlSWxaHsv_jTTsWTmXNKTtqLtN8yn7y7m00)
* Exercise4_1クラスを作成しmainメソッドを作成せよ。
* クラス図を見ながらFighterクラスを作成せよ。
* attack()では引数で受け取ったFighterのHPを自分のpower分減らし、与えたダメージ量と、ダメージを与えたということを表示する。
* isAlive()では自分のhitPointを比較し、生きているかををbooleanで返す。
* hitPoint, power, nameは引数付きコンストラクタにて初期化せよ。
* Fighterを2つインスタンス化し、互いに戦わせる。
* Fighterのコンストラクタに各自適当に値を見繕いインスタンス化し、main内に保持せよ。
* whileを用いて、どちらかのFighterが倒れるまで攻撃を繰り返す。
* ダメージが発生するごとに残りhitPointを表示する。
* ifを用いて勝敗を表示する。

#### 実行結果

```
Fighter1 は Fighter2 に 100 ダメージを与えた。
Fighter2 の残り hitPoint : 80
Fighter2 は Fighter1 に 150 ダメージを与えた。
Fighter1 の残り hitPoint : 60
Fighter1 は Fighter2 に 100 ダメージを与えた。
Fighter2 の残り hitPoint : -20
Fighter2 は倒れた。
```

### 課題2

以下のクラスを作成せよ。 

![](http://www.plantuml.com/plantuml/png/ZP11ImCn48Nlyok6FRNYbYgU5f7kmOEWfteJaTdii1tS92MPjTNI_sxMHbelqaC6ClDUvdjPHAMWW-qXlejRKo2BfgSOQzKWpQ3yOBnRoXVZ77u6M3y_xG3963yuVPIerLXkwqFZ3aR1P0eOk4jz3damSMIvMceGrrsY6sp38L-drOUN5f2toH3FqJVUzqmEiEMrZvB4UPxbrZl-h7f_V7iZkce3RVvJZXNsa7DcZfJrX0J-aW0sr9CpVF3Y6Up71VTR3aOYtxnTfoMxgAHYzcX9t8H25xFZvJLdICOJ2vP1kfMMutT3EbXS5UZB4elvR7PH_AB0WbqxsFuR)

* 作成したクラスをカプセル化し、必要に応じてアクセサを新たに追加せよ。
* 可視性は省略されているから自分で判断せよ。 
* mainの中でATMをインスタンス化する。
* Accountのコンストラクタはbalanceの初期化を０で行う。
* ATMのコンストラクタでaccountListを初期化する。Listについてはlecture03の[外部ライブラリの利用](https://github.com/KazukiOtomo/ProjectMemberDocument/blob/main/Lectures/Lecture3.md)を参照。
* registerAccount()はアカウントを登録する。
* existsAccount()は引数のnameとnumberからaccountListに存在するかどうかをbooleanで返す。
* deposit()とwithdraw()は引数のnumberがaccountListに存在するとき、引数のmoneyを利用して入金と引出を行う。
* withdraw()は残高が足りないときは行えないようにする。
* それぞれ何か行うたびに、何をしたかわかるように標準出力で表示するようにせよ。

#### 実行結果

```
名前:大友一樹 口座番号:12345 は存在しません。
大友一樹 さんのアカウントを口座番号:12345 で登録しました。
名前:大友一樹 口座番号:12345 は存在します。
口座番号:12345 に 1000 円入金しました。
口座番号:12345 から 2000 円引き出せませんでした。残高:1000円です。
口座番号:12345 から 500 円引き出しました。残高:500円です。
```

[目次へ](../README.md)
