DROP TABLE IF EXISTS food;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS totalcalories;
DROP TABLE IF EXISTS calories_detail;

CREATE TABLE food
(
  code SERIAL PRIMARY KEY,
  category_code INTEGER,
  name TEXT,
  calorie INTEGER
);
CREATE TABLE category
(
  code SERIAL PRIMARY KEY,
  name TEXT
);
CREATE TABLE customer
(
  code SERIAL PRIMARY KEY,
  name TEXT,
  address TEXT,
  tel TEXT,
  email TEXT
);
CREATE TABLE totalcalories
(
  code SERIAL PRIMARY KEY,
  customer_code INTEGER,
  ordered_date DATE,
  total_calorie INTEGER
);
CREATE TABLE calories_detail
(
  ordered_code INTEGER,
  food_code INTEGER,
  num INTEGER
);

INSERT INTO category(name) VALUES('穀類');
INSERT INTO category(name) VALUES('イモ類');
INSERT INTO category(name) VALUES('肉類');
INSERT INTO category(name) VALUES('魚類');
INSERT INTO category(name) VALUES('乳製品');
INSERT INTO category(name) VALUES('飲み物');
INSERT INTO category(name) VALUES('お菓子');
INSERT INTO category(name) VALUES('果物');

INSERT INTO food(category_code, name, calorie) VALUES(1, 'クロワッサン', 120);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'ラーメン', 480);
INSERT INTO food(category_code, name, calorie) VALUES(1, '焼きそば', 350);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'コーンフレーク', 250);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'スパゲティ', 400);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'そうめん', 120);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'トウモロコシ', 8-);
INSERT INTO food(category_code, name, calorie) VALUES(1, '食パン', 90);
INSERT INTO food(category_code, name, calorie) VALUES(1, '白米', 160);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'ピザ', 720);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'ホットケーキ', 600);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'うどん', 300);
INSERT INTO food(category_code, name, calorie) VALUES(1, 'チャーハン', 620);

INSERT INTO food(category_code, name, calorie) VALUES(2, 'フライドポテトS', 388);
INSERT INTO food(category_code, name, calorie) VALUES(2, 'フライドポテトM', 450);
INSERT INTO food(category_code, name, calorie) VALUES(2, 'フライドポテトL', 600);
INSERT INTO food(category_code, name, calorie) VALUES(2, 'マッシュポテト', 357);
INSERT INTO food(category_code, name, calorie) VALUES(2, 'タピオカ', 351);
INSERT INTO food(category_code, name, calorie) VALUES(2, 'ジャガイモ', 123);
INSERT INTO food(category_code, name, calorie) VALUES(2, 'ながいも', 89);
INSERT INTO food(category_code, name, calorie) VALUES(2, 'こんにゃく', 25);


INSERT INTO food(category_code, name, calorie) VALUES(3, '和牛', 517);
INSERT INTO food(category_code, name, calorie) VALUES(3, 'フォアグラ', 519);
INSERT INTO food(category_code, name, calorie) VALUES(3, 'サラミ', 320);
INSERT INTO food(category_code, name, calorie) VALUES(3, 'レバー', 250);
INSERT INTO food(category_code, name, calorie) VALUES(3, 'ウィンナー', 220);
INSERT INTO food(category_code, name, calorie) VALUES(3, '豚肉', 450);
INSERT INTO food(category_code, name, calorie) VALUES(3, '手羽先', 427);
INSERT INTO food(category_code, name, calorie) VALUES(3, 'ベーコン', 260);
INSERT INTO food(category_code, name, calorie) VALUES(3, 'ハム', 200);
INSERT INTO food(category_code, name, calorie) VALUES(3, 'ささみ', 105);

INSERT INTO food(category_code, name, calorie) VALUES(4, 'するめ', 50);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'すじこ', 60);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'いくら', 90);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'えび', 67);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'ほたて', 100);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'ししゃも', 120);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'アジ', 150);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'さんま', 230);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'まぐろ', 150);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'サーモン', 170);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'うに', 120);
INSERT INTO food(category_code, name, calorie) VALUES(4, 'いか', 190);

INSERT INTO food(category_code, name, calorie) VALUES(5, '生クリーム', 492);
INSERT INTO food(category_code, name, calorie) VALUES(5, 'ヨーグルト', 200);
INSERT INTO food(category_code, name, calorie) VALUES(5, 'カマンベールチーズ', 346);
INSERT INTO food(category_code, name, calorie) VALUES(5, 'プロセスチーズ', 340);
INSERT INTO food(category_code, name, calorie) VALUES(5, 'チェダーチーズ', 320);
INSERT INTO food(category_code, name, calorie) VALUES(5, 'コーダチーズ', 290);
INSERT INTO food(category_code, name, calorie) VALUES(5, 'カッテチーズ', 305);
INSERT INTO food(category_code, name, calorie) VALUES(5, 'アイスクリーム（バニラ）', 160);
INSERT INTO food(category_code, name, calorie) VALUES(5, 'アイスクリーム（チョコ）', 155);

INSERT INTO food(category_code, name, calorie) VALUES(6, '水', 0);
INSERT INTO food(category_code, name, calorie) VALUES(6, '麦茶', 0);
INSERT INTO food(category_code, name, calorie) VALUES(6, '緑茶', 0);
INSERT INTO food(category_code, name, calorie) VALUES(6, 'コーヒー', 4);
INSERT INTO food(category_code, name, calorie) VALUES(6, 'オレンジジュース', 100);
INSERT INTO food(category_code, name, calorie) VALUES(6, 'コーラ', 120);
INSERT INTO food(category_code, name, calorie) VALUES(6, '日本酒', 107);
INSERT INTO food(category_code, name, calorie) VALUES(6, 'ワイン', 77);
INSERT INTO food(category_code, name, calorie) VALUES(6, 'ウィスキー', 87);
INSERT INTO food(category_code, name, calorie) VALUES(6, 'ビール', 120);
INSERT INTO food(category_code, name, calorie) VALUES(6, '梅酒', 79);

INSERT INTO food(category_code, name, calorie) VALUES(7, 'せんべい', 75);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'ビスケット', 120);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'ポテトチップス', 398);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'きのこの山', 389);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'たけのこの山', 341);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'うまい棒', 23);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'ポッキー', 180);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'プリッツ（サラダ味）', 150);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'コアラのマーチ', 278);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'チョコパイ', 160);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'キャラメル', 20);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'かりんとう', 560);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'ようかん', 300);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'アップルパイ', 340);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'ショートケーキ', 350);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'モンブラン', 320);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'シュークリーム', 130);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'タルト', 280);
INSERT INTO food(category_code, name, calorie) VALUES(7, '大福', 190);
INSERT INTO food(category_code, name, calorie) VALUES(7, 'アメ', 10);

INSERT INTO food(category_code, name, calorie) VALUES(8, 'バナナ', 85);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'みかん', 60);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'キウイ', 59);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'ぶどう', 70);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'なし', 80);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'もも', 75);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'かき', 50);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'さくらんぼ', 78);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'メロン', 89);
INSERT INTO food(category_code, name, calorie) VALUES(8, '柿', 66);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'すいか', 85);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'すもも', 40);
INSERT INTO food(category_code, name, calorie) VALUES(8, 'いちご', 88);
