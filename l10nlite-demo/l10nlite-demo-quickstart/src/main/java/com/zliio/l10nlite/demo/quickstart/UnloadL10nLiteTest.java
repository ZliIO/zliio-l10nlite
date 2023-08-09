package com.zliio.l10nlite.demo.quickstart;


import com.zliio.l10nlite.core.L10nLite;
import com.zliio.l10nlite.loader.UnloadL10nConfigurerLoader;

/**
 * L10nLite.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
public class UnloadL10nLiteTest {
    public static void main(String[] args) {
        L10nLite demol10nLite = new L10nLite(new UnloadL10nConfigurerLoader());
        L10nLitePrint.print(demol10nLite);
    }
}
