# 継承

## はじめに

今回の内容「継承」は、Javaの基礎を学習する上での最大の壁です。  
読んでも分からない点はインターネットを活用してください。  

## 継承の概念

大規模な開発においては、コードの様々な場面で似たようなコードが使われている。  
コード量や変数の量、バグの量は比例関係にあるため、いかにコード量、変数量を減らすかがカギとなる。  
関数により一部のまとまった処理は1つの関数の呼び出しに置き換えることが出来るが、それだけでは限界がある。  
ここで用いるのが __継承__ という概念である  
オブジェクト指向言語では、オブジェクト間の関係を考えつつプログラムを構築する必要がある。  
プロジェクト中のクラスの数が数十、数百と増えてくると、似たような機能を持ったクラスが必ず出てくる。  
ここで、似たような機能を持つクラスの元となるクラスを作成し、その機能を引き継いだ(継承した)クラスに分割することで、コードの重複を減らし、コード量を減らすことが出来る。  

## Javaにおける継承

Javaにおいて、SubClassがSuperClassクラスを継承するとき、extendsキーワードを用いて、

```java
class SubClass extends SuperClass {  
/* フィールドやメソッド */  
}
```

と記述する。  
この時、SuperClassはスーパークラスといい、それを継承したSubClassはサブクラスという。  

ここではRPGを題材として継承を考えてみたい。
プレイヤーキャラクターはattackメソッドを用いてスライムに対して通常攻撃をすることができる。

```java
public class Player {
    // スライムへの攻撃メソッド
    public void attack(Slime slime){
        slime.setHitPoint(slime.getHitPoint() - 10);
    }
}
```

また、コウモリに対しても通常攻撃することができる。

```java
public class Player {
    // スライムへの攻撃メソッド
    public void attack(Slime slime){
        slime.setHitPoint(slime.getHitPoint() - 10);
    }
    
    // コウモリへの攻撃メソッド
    public void attack(Bat bat){
        bat.setHitPoint(bat.getHitPoint() - 10);
    }
}
```

ここで、引数の型が異なる同名のメソッドを定義しているが、これを **メソッドのオーバーロード** と呼ぶ。

さらに、トラやライオンに対しても通常攻撃できるとすると以下のようになる。

```java
public class Player {
    // スライムへの攻撃メソッド
    public void attack(Slime slime){
        slime.setHitPoint(slime.getHitPoint() - 10);
    }
    
    // コウモリへの攻撃メソッド
    public void attack(Bat bat){
        bat.setHitPoint(bat.getHitPoint() - 10);
    }
    
    // トラへの攻撃メソッド
    public void attack(Tiger tiger){
        tiger.setHitPoint(tiger.getHitPoint() - 10);
    }
    
    // ライオンへの攻撃メソッド
    public void attack(Lion lion){
        lion.setHitPoint(lion.getHitPoint() - 10);
    }
}
```

続いて、ダンジョンに潜むスケルトンや魔術師、最終階に待ち受ける魔王を...
そろそろ気づいたかと思われるが、この設計ではモンスターが増えるたびにPlayerクラスの持つattackメソッドが数十、数百と増えることになる。
ただ、それぞれのattackメソッドの処理を見てみると、どれも変数名は違えど体力をへらすという処理は同じである。
ここで用いるのが継承である。

継承を使うと、上の膨大なモンスター達は以下のようにまとめることができる。

```java
// モンスタークラス
public class Monster {
    // フィールドやアクセサは省略する
}

// スライムクラス
public class Slime extends Monster {
    // フィールドやアクセサは省略する
}

// プレイヤークラス
public class Player {
    public void attack(Monster monster){
        monster.setHitPoint(monster.getHitPoint() - 10);
    }
}
```

同じようなフィールド、メソッドを持つと分かっているクラスが設計段階で存在するのであれば、事前に抽象的なクラスとしてクラスを定義しておけば、これを継承したクラスを逐一作成することでコード量を削減することに繋がり、加えてバグの発生確率も減らすことができる。
今回の例の場合では、Playerのattackメソッドに3行程度消費しているため、モンスターの種類が100種類いるのであれば3行\*100種類の300行減らしたことになる。
実際には何でもかんでも継承を用いればすべてが解決するというわけではないため、場合によって使い分けることが必要である。どういった場合には継承を用いるべきなのかを判断できるようになれば、Java以外のその他のオブジェクト指向言語でもその知識が生かせるだろう。 

矢印の先が向いているクラスがスーパークラスである。  
![](http://www.plantuml.com/plantuml/png/SoWkIImgAStDuKhEIImkLl3DpoikIIs2ye9pCdDJeModn18eAoGp7Qx29pC_ZuiBgal1faPN5w89HGYa5qK0OWIA4CGaXzIy5A1Z0000)

## オーバーライド

サブクラスでは、スーパークラスのメソッドを再定義(上書き)することが出来る。  
このメソッドの処理内容を上書きすることをオーバーライドという。  
また、メソッドをオーバーライドするときには、@Overrideアノテーションを用いる。  

```java
@Override
```

"@" から始まる特別な記述はアノテーションと言い、プログラムに対してメタデータを付加することが出来る。  

```java
public class Animal {
	public void bark(){	  }
}

public class Dog extends Animal {
	// @Overrideをメソッドの定義の前に書き、bark()をOverrideする
	@Override
	public void bark(){
		System.out.println(“わんわん！”);
	}
}
```


## superキーワード

サブクラスの中からスーパークラスで定義したフィールドやメソッド(コンストラクタは除く)には、superキーワードとドット演算子を用いてアクセスすることが出来る。  

```java
public class SmartPhone extends CellPhone {
	public void showPhoneNumber(){
		System.out.println(super.phoneNumber);
	}	// CellPhoneで定義されているphoneNumber
}
```

サブクラスからスーパークラスのコンストラクタを明示的に呼び出したい場合、super()を用いる。  
super()は、サブクラスのコンストラクタの引数として受け取った値をスーパークラスに渡したい場合に用いる。  

```java
public SmartPhone(long phoneNumber){
	super(phoneNumber);
}	// CellPhoneのコンストラクタを呼び出している
```


## 抽象クラス

Javaではnewによるインスタンス化が出来ないクラスを定義することが出来る。</br>
このクラスを抽象クラスといい、classの前に abstract修飾子 を付けることで定義することが出来る。

```java
abstract class AbstractAnimal {
	public AbstractAnimal(){	}
}
```

`AbstractAnimal abstractAnimal = new AbstractAnimal();`とするとエラーが出る。


## 抽象メソッド

メソッドにabstract修飾子を付けることで、メソッドの定義を省くことができる。  
ただし、abstract修飾子の付いたメソッドを持つクラスは抽象クラスとなるため、インスタンス化できなくなる。  
また、abstract修飾子の付いたメソッドを持つクラスを継承したサブクラスは、そのメソッドを必ずOverrideしなければならない。  
C言語のプロトタイプ宣言と同じような記述が可能である。

```java
public 	abstract class AbstractClass {
	public abstract void execute();		// {} は必要ない
}

public class SubClass extends AbstractClass {
	@Override
	public void execute(){
		// 処理
	}
}
```

## インタフェース

クラス、抽象クラスの更に上位となる定義で、必ず実装しなければならないメソッドの名前や型のみを記述する。  
以下の課題には出さないので、詳細は省くが、非常に重要な概念であるため余裕のある人は調べてみよう。


## 演習課題

### 課題1

Exercise5_1クラスを作成し、mainメソッドを作成せよ。  
Insectクラスを作成せよ。  
moveメソッドを作成せよ。  
moveメソッドでは"歩いたよ"とコンソールに出力せよ。  

mainメソッドにてInsectクラスをインスタンス化し、moveメソッドを呼び出せ。  

### 課題2

Exercise5_2クラスを作成し、mainメソッドを作成せよ。  
Butterfly(チョウチョウ)クラスを作成しなさい。  
ButterflyはInsectを継承する.</br>
Butterflyのmoveメソッドでは"飛んだよ"とコンソールに出力せよ。  

mainメソッドにてButterflyクラスをインスタンス化し、moveメソッドを呼び出せ。  

### 課題3

Exercise5_3クラスを作成し、mainメソッドを作成せよ。  
mainメソッドにてButterflyクラスのインスタンスを、Insect型の変数に代入せよ。  
また、インスタンス化したButterflyのmoveメソッドを呼び出せ。  

### 課題4

Exercise5_4クラスを作成し、mainメソッドを作成せよ。  

Locust(バッタ)クラスを作成しなさい。  
LocustはInsectを継承する。  
Locustのmoveメソッドでは"跳んだよ"とコンソールに出力せよ。  

mainメソッドにてLocustクラスをインスタンス化し、moveメソッドを呼び出せ。  

### 課題5

Exercise5_5クラスを作成し、mainメソッドを作成せよ。  

mainメソッドにてLocustクラスのインスタンスを、Insect型の変数に代入せよ。  
また、インスタンス化したLocustのmoveメソッドを呼び出せ。  

### 課題6

Exercise5_6クラスを作成し、mainメソッドを作成せよ。  

SwallowtailButterfly(アゲハチョウ)クラスを作成しなさい。  
SwallowtailButterflyはButterflyを継承する。  
SwallowtailButterflyのmoveメソッドでは"綺麗に飛んだよ"とコンソールに出力せよ。  

mainメソッドにてSwallowtailButterflyクラスのインスタンスを、Insect型の変数に代入せよ。  
また、インスタンス化したSwallowtailButterflyのmoveメソッドを呼び出せ。  

### 課題7

Exercise5_7クラスを作成し、mainメソッドを作成せよ.  

mainメソッドにてInsect,Butterfly,Locust,SwallowButterflyクラスのインスタンスをListに格納せよ。
また、格納した４つのインスタンスからmoveメソッドを呼び出せ。

[目次へ](../README.md)
