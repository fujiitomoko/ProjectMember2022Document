# Javaまとめ

lecture07は今までの知識をフル活用かつ講習では教えていないlambdaなどを使用する超応用問題となってしまいました  
おそらく三年生でも答えられない部分もあると思うので、各自頑張って調べながらやってください！  
省略できる処理は省略してしまいましょう。(無駄に長いコードを ”冗長なコード” とも呼ぶ)  


## 演習課題

### 演習課題に取り組む前に

これまで通り、prmn2021sプロジェクト内にlecture07パッケージを作成してください。  
これより後の演習ではすべてのクラスをこのパッケージ内に作成してください。  

### 課題1

以下のクラスを作成しなさい。

![](http://www.plantuml.com/plantuml/png/RLFR2jim37ttLvZi9UcQifOzXL7QFOmDrZ785pYDQ4qTEyHkkyiA_TVzo6J5Tb8Oj44-biwHZfATTM9mrqunUv6w5uFe-549Q_VE3RAvElXoDBgMlu2_O-nWj7Kmy6oJyR9Sy6oTyKyIL1jl25cKWpoTNOc7rUfznW_c1hpw-toc7qDsSRpGHNdjopzRIcACf7aa-yrugKK7LOszw1EUpj9zDrAx2lzu54GJ3eqoAROzG1lY3fc_Ikig__ZWTRQCyRT199y9B3dozv5_oSSkn_YZCZ5Cv0NIYBRrbBbNgNnKL3SZMtz3rJbew7vMGMt9fMxX1nN7F7isTw98YBHx9GbeZ54WD68dSDz4XrWqWw3FmG-4yUd9PjXaLbAZed6iL898xISA07kmk0TQBMsX6zkVsqW0EKbfUKXPJwC6P1CHRrU3hYYe_KiNvtrCQxy1YhsPhnnBo9iPLlpFZGTBNK_l5hNUcpiCD1dMJNUlUqz9HLfS76YQvsMJeNaKte5kyGFw1m00)

* Exercise7_1クラスを作成し、mainメソッドを作成しなさい。  
* 上記のクラス図に従ってMonsterクラス、AttackMoveクラス、Fieldクラス、Moveクラスを作成しなさい。
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
* battleStartメソッドではlambdaも使用するため、調べてみてください。
* MoveメソッドではmoveListの中に入っている3つの技の中から1つ選択する。 
* 野生のモンスターは3つの技の中からランダムに1つを選択する。
* バトルを行う際には、speedが高いモンスターから行動を開始しなさい。
* whileを用いて、どちらかのMonsterが倒れるまで攻撃を繰り返しなさい。  
* ダメージが発生するごとに残りHPを表示させなさい。  
* ここでは、attack+power-block=ダメージとする。 
* ifを用いて勝敗を表示しなさい。

[目次へ](../README.md)
