package com.zliio.l10nlite.translator;


import com.zliio.l10nlite.core.L10nKey;
import com.zliio.l10nlite.core.L10nMessageTranslator;

/**
 * No Operation Translator.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
public class DefaultL10nMessageTranslator implements L10nMessageTranslator {
    @Override
    public String translation(L10nKey l10nKey) {
        return l10nKey.getMessage();
    }
}
