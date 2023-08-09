package com.zliio.l10nlite.demo.quickstart;

import com.zliio.l10nlite.core.L10nLite;

/**
 * L10nLite Print.
 *
 * @author Leo
 * @since 1.0 (2023-08-09)
 **/
public class L10nLitePrint {
    public static void print(L10nLite l10nLite) {
        String message = "Hello World,Hello L10nLite";
        System.out.println(l10nLite.get(message, "ZH"));
        // 你好世界, 你好L10nLite
        System.out.println(l10nLite.get(message, "DE"));
        // Hallo Welt，Hallo L10nLite
        System.out.println(l10nLite.get(message, "ES"));
        // Hola Mundo，Hola L10nLite
        System.out.println(l10nLite.get(message, "KO"));
        // 안녕, 세상아，안녕하세요 L10nLite
        System.out.println(l10nLite.get(message, "XX"));
        // Hello World,Hello L10nLite
    }
}
