package com.example.helpers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Options;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// HandlebarsHelpers.javaは、Handlebarsテンプレートで利用するためのカスタムモデルヘルパーなどを定義したclassである。

@Configuration
public class HandlebarsHelpers {

    private static final Logger logger = LoggerFactory.getLogger(HandlebarsHelpers.class);

    @Bean
    public Handlebars handlebars() {
        Handlebars handlebars = new Handlebars();
        
        // eqヘルパーを定義
        handlebars.registerHelper("eq", (context, options) -> {
            // デバッグ出力
            logger.info("eq helper called with context: {}, param: {}", context, options.param(0));
            if (context != null && context.equals(options.param(0))) {
                return options.fn(); // 条件が一致すれば処理を実行
            } else {
                return options.inverse(); // 一致しなければ逆の処理
            }
        });
        
        return handlebars;
    }
}
