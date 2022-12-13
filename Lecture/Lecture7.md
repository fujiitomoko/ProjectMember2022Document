# Javaまとめ

lecture07は今までの知識をフル活用かつ講習では教えていないlambdaなどを使用する超応用問題となってしまいました  
おそらく三年生でも答えられない部分もあると思うので、各自頑張って調べながらやってください！  
省略できる処理は省略してしまいましょう。(無駄に長いコードを ”冗長なコード” とも呼ぶ)  


## 演習課題

### 演習課題に取り組む前に

これまで通り、prmn2021sプロジェクト内にlecture07パッケージを作成してください。  
これより後の演習ではすべてのクラスをこのパッケージ内に作成してください。  

### 課題1

以下のクラスを作成しなさい。クラス図においてコンストラクタは省略可能ですので、省略されていることを念頭に置いて進めてください。(クラス図を複数枚に分けています)

![](/out/skill/Exercise7.png)
![](/out/monster/Exercise7.png)
![](/out/battle/Exercise7.png)
![](/out/etc/Exercise7.png)

* Exercise7_1クラスを作成し、mainメソッドを作成しなさい。  
* クラス図で分からない部分があれば[ここ](https://plantuml.com/ja/class-diagram)を参照し、各自調べなさい。
* Turtle、Monkey、Penguinの中から気に入った1匹を選択しインスタンス化しなさい。  
* name(名前),hitpoint(体力),attack(攻撃力),block(防御力),speed(素早さ)は引数付きコンストラクタにて初期化しなさい。  
* Monsterのコンストラクタに入れる値は下記のモンスターリスト①を参照しなさい。  
* moveListには下記の技リストを参照しname,powerの要素を持つ技を追加しなさい。 
* 各モンスターが持つ技はモンスターリスト②を参照しなさい。
* どのモンスターをインスタンス化したのかを分かるように表示させなさい。  

モンスターリスト①

|Turtle|Monkey|Penguin|
|:-------:|:------:|:------:|
|HP:55|HP:44|HP:53|
|attack:17|attack:14|attack:12|
|block:16|block:11|block:13|
|speed:15|speed:31|speed:20|

技リスト  

|name|power|
|:-------:|:------:|
|tackle(たいあたり)|10|
|scratch(ひっかく)|10|
|Peck(つつく)|15|
|razorLeaf(はっぱカッター)|12|
|ember(ひのこ)|10|
|bubble(あわ)|10|


モンスターリスト②

|Turtle|Monkey|Penguin|
|:-------:|:------:|:------:|
|tackle|scratch|Peck|
|razorLeaf|tackle|tackle|
||ember|bubble|  
  
  
### 課題2

* 課題1でインスタンス化したモンスターとは別に野生のモンスターを新たにインスタンス化しなさい。  
* FieldクラスのbattleStartメソッドでは素早さの判定、技の選択、Monsterの生死を判定する。
* MoveメソッドではmoveListの中に入っている3つの技の中から1つ選択する。 
* 野生のモンスターは3つの技の中からランダムに1つを選択する。
* バトルを行う際には、speedが高いモンスターから行動を開始しなさい。
* whileを用いて、どちらかのMonsterが倒れるまで攻撃を繰り返しなさい。  
* ダメージが発生するごとに残りHPを表示させなさい。
* ここでは、attack+power-block=ダメージとする。

## 実行例

```shell
1 -> MONKEY
2 -> PENGUIN
3 -> TURTLE
オー○ド博士「ここに三匹のMonsterがおるじゃろ？好きなのを一匹選ぶんじゃ」 >  1
あ! 野生の Monkey が飛び出してきた！
ゆけっ！ Monkey！

-------------
プレイヤーのMonkeyのHP: 44
野生のMonkeyのHP: 44

0 -> scratch (power: 10)
1 -> tackle (power: 10)
2 -> ember (power: 10)
技を選べ > 2


プレイヤーの Monkey の攻撃！
Monkey は ember を繰り出した
Monkey に 13 のダメージ！ (HP 44 -> 31)


野生の Monkey の攻撃！
Monkey は tackle を繰り出した
Monkey に 13 のダメージ！ (HP 44 -> 31)


-------------
プレイヤーのMonkeyのHP: 31
野生のMonkeyのHP: 31

0 -> scratch (power: 10)
1 -> tackle (power: 10)
2 -> ember (power: 10)
技を選べ > 2


プレイヤーの Monkey の攻撃！
Monkey は ember を繰り出した
Monkey に 13 のダメージ！ (HP 31 -> 18)


野生の Monkey の攻撃！
Monkey は scratch を繰り出した
Monkey に 13 のダメージ！ (HP 31 -> 18)


-------------
プレイヤーのMonkeyのHP: 18
野生のMonkeyのHP: 18

0 -> scratch (power: 10)
1 -> tackle (power: 10)
2 -> ember (power: 10)
技を選べ > 2


プレイヤーの Monkey の攻撃！
Monkey は ember を繰り出した
Monkey に 13 のダメージ！ (HP 18 -> 5)


野生の Monkey の攻撃！
Monkey は ember を繰り出した
Monkey に 13 のダメージ！ (HP 18 -> 5)


-------------
プレイヤーのMonkeyのHP: 5
野生のMonkeyのHP: 5

0 -> scratch (power: 10)
1 -> tackle (power: 10)
2 -> ember (power: 10)
技を選べ > 2


プレイヤーの Monkey の攻撃！
Monkey は ember を繰り出した
Monkey に 13 のダメージ！ (HP 5 -> 0)


野生の Monkey は倒れた！
プレイヤーの Monkey の勝ち！
```

[目次へ](../README.md)
