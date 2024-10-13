/*initiates and configures the Spring framework to launch the web application.*/

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication /*SpringBootApplicationアノテーション　これが付いているクラスがSpring Bootアプリケーションの起動ポイントとなる。このアノテーション、アプリケーションの設定、コンポーネントスキャン、Spring Boot の自動設定機能を有効にします。*/
public class MyApp { /*MyAppクラスはアプリケーションをサーバーとして起動センサさせ、ブラウザからのリクエストに応答できる状態にする役割を果たす*/
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args); /*このメソッドが呼ばれることで。アプリケーションが起動し、内部的に組み込まれたサーバーが起動する。*/
    }
}
