package com.zliio.l10nlite;

import com.zliio.l10nlite.loader.ResourcesL10nConfigurerLoader;

/**
 * L10nLite.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
public class L10nLiteTest {
    public static void main(String[] args) {
        String message = "Hello World,Hello L10nLite";
        L10nLite demol10nLite = new L10nLite(new ResourcesL10nConfigurerLoader("l10nlite-demo"));
        System.out.println(demol10nLite.get(message, "ZH"));
        // 你好世界, 你好L10nLite
        System.out.println(demol10nLite.get(message, "DE"));
        // Hallo Welt，Hallo L10nLite
        System.out.println(demol10nLite.get(message, "ES"));
        // Hola Mundo，Hola L10nLite
        System.out.println(demol10nLite.get(message, "KO"));
        // 안녕, 세상아，안녕하세요 L10nLite
        System.out.println(demol10nLite.get(message, "XX"));
        // Hello World,Hello L10nLite
    }
}
