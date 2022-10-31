# チュートリアル

## はじめに

* 分からないときはすぐに担当のb3に聞く
  * 分からないことは次に持ち越さないこと
* 予習/復習は必ず行うこと。
  * 前回までの知識は全て習得しているものとして進行します
* **課題はGithub上にpushすること**
  * Githubの使い方を学びます
  * 課題の質問をするときなどにGithub上にあげておくと確認しやすいです
* 時間外の質問/相談はSlackまたはZoomで  
  * Zoomで聞いた方がいいこともあります
* 解答は確認程度に
  * 課題の解答がありますが、あくまで参考程度としコピペは極力しない。
* 連絡はこまめに
  * 既読通知機能がSlackにはないので...
  * メンションを付けて送信すると、相手に通知されますが緊急時以外は極力避けましょう。

### Githubの準備
以下はGithubアカウントがあることを想定して進めます
* Windowsの人は[GitBashのダウンロード](https://gitforwindows.org/)
Macの人はターミナルで git config でユーザ登録を行なっていない人は以下のコマンドから登録する
```
$ cd
$ git config --global user.name [GitHubに登録したユーザ名]
$ git config --global user.email [GitHubに登録したメールアドレス]
```
現在の登録を確認するコマンド
```
$ git config --global --list
```

* [Github](https://github.co.jp/)にアクセスし、サインインする
* Github上にリモートリポジトリを作成する
  * 以下のボタンをクリック
  	![image](https://user-images.githubusercontent.com/85465441/198194537-d6917bea-8d1d-482f-8fa7-bbf2cff19543.png)

  * 以下のように入力し、Create Repositoryをクリックする。ここまででリモートリポジトリは完成
  
	![image](https://user-images.githubusercontent.com/85465441/198837843-bdda13dc-eea0-480d-a158-0137176665b9.png)

  * リポジトリが作成されると以下のような画面が表示される。この画面のまま置いておく
  
	![image](https://user-images.githubusercontent.com/85465441/198196394-a332b98a-2c7a-4d8c-ac4d-f7792d9bb6b5.png)

* ローカルリポジトリの作成
以下はWindowsの人はGitBash、Macの人はターミナルで操作する
  * リポジトリを作成するディレクトリを作成する
  
  【Mac例】 MacintoshHD>ユーザ>ユーザ名>デスクトップ にディレクトリを作成する場合
  ```
  $ cd
  $ cd Desktop
  $ mkdir Prmn2022a
  $ cd Prmn2022a
  ```
  
  【Windows例】 Windows(C:)>Users にディレクトリを作成する場合
  ```
  $ cd
  $ cd c:
  $ cd Users
  $ mkdir Prmn2022a
  $ cd Prmn2022a
  ````
  
  先にファイルをファイルを作成する方法もある
  
  ローカルリポジトリを作成したいところで新規ファイルを保存してパスのコピーを行い、cdコマンドの後ろにつける
  
	【Windows】 
	![image](https://user-images.githubusercontent.com/85465441/198379464-4e54be20-1bec-4619-abbf-825b1b450152.png)

	【Mac】
	![image](https://user-images.githubusercontent.com/85465441/198379592-a4fcfaaa-351b-4e4e-b6f4-f5d12d8aed14.png)
 
  ```
  $ cd ファイルのパス
  ```
  
  
  

  * Githubの画面に戻り、表示されているコマンドを順番に進める
  
  ![image](https://user-images.githubusercontent.com/85465441/198198525-d11bcbef-9710-4d7d-a65b-f540c87aa9a5.png)
  【例】
  
  ```
  $ echo "# Prmn2022a" >> README.md
  $ git init
  $ git add README.md
  $ git commit -m "first commit"
  $ git branch -M main
  $ git remote add origin https://github.com/fujiitomoko/Prmn2022a.git
  $ git push -u origin main
  ```
* Githubのリポジトリ上にREADE.mdというファイルが上がっていることを確認する

### プロジェクトの作成
* Githubにpushを行うローカルリポジトリを作成したディレクトリ下に ”prmn2022a” フォルダを作る


* IntelliJを起動後、Create New Project を選択する
* 左側のメニューから Java を選択
* 上部の Project SDK で 11 （この数字は異なるかも） を選択し、Nextを押す
* もう一度Nextを押す
* Project locationに ”prmn2022a” フォルダへのパスを入れる
* Finishを押す

![image](https://user-images.githubusercontent.com/85465441/197342066-9804f7bb-5231-478d-8bb0-3844b0614481.png)

### パッケージの作成

* 左側のメニューの “prmn2022a” を開く
* ”src” フォルダを右クリックし、New > Packageを選択
* package nameには、”lecture01”と記入しOKを押す

今後特に指示が無い場合は ”lectureXX” の形式で作成する。

例: 第3回講義では、 prmn2022a/lecture03/

![image](https://user-images.githubusercontent.com/85465441/198200330-18ced012-4f97-4718-b2b9-4b20a36f1e9a.png)

### Githubにプロジェクトをpushする

* IntelliJのターミナルを開く

![image](https://user-images.githubusercontent.com/85465441/198525531-5e61a929-75da-40c4-bdc8-24b7b7523d0d.png)

* 現在いる場所がプロジェクトになっていることを確認する

![image](https://user-images.githubusercontent.com/85465441/198528268-70986441-812b-4a24-b6f6-f5d30be65c8e.png)

* 以下のコマンドを入力する
```
$ git add .
$ git commit -m "Github上に表示するコメント文(例:プロジェクト作成)"
$ git push origin main
```

Githubのリポジトリを更新して、プロジェクがpush出来ていたらOK

GitBashやターミナルでも同じコマンドでpushを行えるが、**ディレクトリをプロジェクトまで移動するのを忘れないように**
pushはできるだけ細かく行い、コメント文は簡潔に([パッケージ](https://github.com/fujiitomoko/ProjectMember2022Document/edit/main/Lecture/Lecture1.md#パッケージ)・[クラス](https://github.com/fujiitomoko/ProjectMember2022Document/edit/main/Lecture/Lecture1.md#クラス)・[メソッド](https://github.com/fujiitomoko/ProjectMember2022Document/edit/main/Lecture/Lecture1.md#メソッド)を作ったときなど)



### クラスの作成

* 左側のメニューのsrc > lecture01を 右クリックする
* New > Java Class を選択する
* Nameには "Main" と記入しOKを押す

今後クラス作成をするときは、各lectureXXパッケージ内に作成すること

![image](https://user-images.githubusercontent.com/85465441/197342085-f66a8e15-0e1c-4740-9587-8f7ab9c17a33.png)

## 何もしないプログラム

* Mainクラスの {} の中にカーソルを合わせる
* `psvm` とタイプしTabキーを押す
  * 生成されたコード部分
  ```
  public static void main (String[] args){
	  //本来ならここに処理を書く
	  //スラッシュを2つ打つと、コメント文として認識される。
	  //コードの可読性の向上につながるので、書く癖をつけよう
	  //行を選択して「ctrl+/ (command+/)」で選択行をコメント文に変更できる(複数行可)
  }
  ```
  をmainメソッドと呼ぶ。

* コード入力スペース上で右クリックをする
* Run ‘Main.main()’ をクリック

画面下部に `Process finished with exit code 0` と表示されることを確認する


## 標準出力
`System.out.println(String str)`

この関数を用いることで標準出力に改行付きで文字列を表示させる事ができる  
(soutでショートカット入力することもできる)  
引用strには、`"`(Shift + 2キー)で囲った文字列を渡す  

例:

```java
System.out.println("We are Project Member.");
//コンソールに、We are Project Member と表示されるはず
```


## 四則演算
演算記号 `+`, `-`, `*`, `/`, `%` を用いることで四則演算ができる

例:</br>
```java
int sum = 5 + 3;	//sumには8が入る
int sub = 5 - 3;	//subには2が入る
int mul = 5 * 3;	//mulには15が入る
int div = 5 / 3;	//divには1が入る(小数点以下は切り捨て)
int mod = 5 % 3;	//modには2が入る(余りの導出)
```

## 文字列連結

Javaでは`+`演算子を用いることで文字列(もしくは数値を文字列へ変換したもの)を連結する事ができる
`+`演算子は連結部分に用いる

例：

```java
double temp = 18.7;
System.out.println("The temperature is " + temp + " degrees");	//"The tempareture is 18.7 degrees"と表示
```

## 条件分岐 if

処理を分岐させたい場合には `if`, `else if`, `else` を用いる

```java
if(条件式1) {
	/* 条件式1がtrueの時実行 */
}
else if(条件分岐2) {
	/* 条件式1がfalseかつ条件式2がtrueの時実行 */
}
else {
	/* 条件式1も2もfalseだった時実行 */
}
```

比較には以下の記号を用いる<br>
==(等値), !=(等値でない), >, >=, <, <=, &&(かつ), <br>
||（または）, !（条件を逆にする＝falseの時に実行されるようにする） , ....


## 配列

Javaにおいて配列を定義するには以下のように記述する  
`型名[] 変数名 = new 型名[要素数];`

例：
`int[] array = new int[10];	//int型の配列を10要素分確保`

アクセスするには以下のように記述する  

```java
array[4] = 3;	//arrayの5番目に3を代入する
```

宣言と同時に代入する場合には以下のような記述も可能である

```java
int[] array={ 1,2,3,4 };

//以下と同じ
int[] array = new int[4];
array[0] = 1;
array[1] = 2;
array[2] = 3;
array[3] = 4;
```

## 繰り返し文 for
指定回数同じ処理をさせる場合にはfor文を用いる

```java
for(初期化式; 条件式; 変動値) {
	/*条件式が真の繰り返しを処理する内容*/
}
```

例：

```java
for(int i = 0; i < 10; i++){
	/* 処理が終わるたびにiが+1され, i<10でなくなった時にfor文を抜ける */
}
```


## 繰り返し文 while
繰り返し処理をする回数が定かでない場合にwhile文を用いる  
```java
while(条件式) {
	/* 条件式が真の間繰り返される */
}
```

例：
```java
int count = 0;
while(count < 100) {
	count++;	//count=100になると抜ける
}
```


## 条件分岐 switch

条件式により処理を複数分岐にしたい場合,それぞれの条件が独立している場合にswitch文を使う事ができる

```java
switch(分岐の処理である変数){
case 条件1: 
	/*処理内容*/ 
	break;
case 条件2: 
	/*処理内容*/ 
	break;
    ・・・
default: 
	/*上記に当てはまらなかったときの処理*/ 
	break;
}
```

例：

```java
String series = "XS";  //Java SE 7より文字列のswitchが可能に
switch(series){
case "X": //文字列の場合条件の""を忘れないように
	System.out.println("Face IDに対応");
	break;
case "11":
	System.out.println("Dolby Atmosに対応");
	break;
case "11　pro":
	System.out.println("タピオカメラ");
	break;
case "SE":
	System.out.println("8の上位互換");
	break;
default:
	System.out.println("古き良き時代");
	break;
}
```

各ケースの末尾のbreakは忘れずに記述する  
記述しなくてもエラーとはならないが、大抵が記述者の意図と異なる挙動となる  
breakを書かない場合は下のcaseの処理内でbreakされるもしくはswitchのスコープから出るまで次々に行う  
これをFall throughという

    
## メソッド
処理を分割する際に用いるメソッドは以下のように記述する  
```
[修飾子] [戻り値の型] [メソッド名](引数1,引数2,...){
	/*処理内容*/
}
```

* 修飾子については後の講義で解説する。
* mainメソッド内で使いたいメソッドには、以下のprintメソッドのようにstatic修飾子を付ける。
	* 付けない場合コンパイルエラーが発生するため注意

例：
```java
public class Main {
	public static void main(String[] args) {
		print("Project Member");
  	}
	
	static void print(String str) {
		//引数に与えられた文字列を表示するprintメソッド
		System.out.println(str);
	}
}
```

## Java仮想マシン

* Javaは専用の動作環境であるJava仮想マシン(JVM  : Java Virtual Machine)がプログラムを実行する
  * JVM用実行コード(バイトコード)にし、JVMがOSや実行状況に最適な形でバイトコードを処理する
  * JVMの環境は共通なので、どのOSでも全く同じバイトコードが動作する(**クロスプラットフォーム**)
  * また、JVMがメモリの利用・管理も自動で行う(**ガーベージコレクション**)

# 演習課題

## 課題1-1

System.out.println()関数を用いて自分の情報を表示させる</br>
実行結果:`B21xxxxx Tomoko Fujii`

[Githubにcommit/pushする](https://github.com/fujiitomoko/ProjectMember2022Document/blob/main/Lecture/Lecture1.md#Githubにプロジェクトをpushする)

## 課題1-2

**int型変数studentNumberに学籍番号の数値の部分を代入**し、自分の情報を表示させる</br>
ただし,**studentNumberを文字列連結させて表示させること**</br>
実行結果:`B21xxxxx Tomoko Fujii`

Githubにcommit/pushする

## 課題1-3

int型変数ageに任意の値を代入し、ageの値によって処理を分岐させ、実行結果のようになるようにしなさい</br>
また、文字列連結を用いて、ageを使って年齢を表示させること</br>
実行結果:
```
// ageが20未満の時
I am XX years old so I cannot drink liquor. //XXにageを表示
// ageが20以上の時
I am XX years old so I can drink liquor.  //XXにageを表示
```
Githubにcommit/pushする

## 課題1-4

要素数100のint型の配列arrayを用意する。
それぞれに要素番号+1の値を代入していくことにする。 *(0番目の要素には、「１」が入るように)*
<br>配列arrayの数値を用いて配列番号が偶数の値の総和を求めよ。<br>
ただし、代入処理及び総和を求める処理には繰り返し文を用いて、総和をint型変数sumに代入して結果を出すこと<br> 
for, whileのどちらの繰り返し文を用いるかは各自考え。
なぜその繰り返し分を記述したのかの理由を答えよ。

Githubにcommit/pushする

## 課題1-5

小松川高校の1年生は5人います。</br>
1年生全員を対象として算数のテストを行い,成績をつけることになりました.</br>
int型の1次元配列(テストの点数表)を引数にとる関数min(), max(), average()を作成し、各クラスのそれぞれの最低点をint型,最高点をint型,平均点をdouble型で返すようにせよ.

また、条件分岐を用いて60点未満を不可、60\~70点未満を可、70\~80点未満を良、80\~90点未満を優、90\~100点を秀とし表示例のように表示せよ。</br>
※テストの点数表はこちらが用意するものを用いること

表示例:

```
 0番 41点 不可
 1番 85点 優
.....
最高点:85点
最低点:38点
平均点 63.2点
.....
```
Githubにcommit/pushする

#### テストの点数表

以下のコードを適切な箇所に挿入してください

```java
int[] score = {41,85,72,38,80};
```

Githubにcommit/pushする

[目次へ](../README.md)
