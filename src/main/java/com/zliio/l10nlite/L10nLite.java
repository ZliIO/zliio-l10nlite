package com.zliio.l10nlite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * L10nLite.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
public class L10nLite {

    private final Map<L10nKey, String> l10nLiteBook;

    private final L10nMessageTranslator messageTranslator;

    public L10nLite(L10nConfigurerLoader configurerLoader) {
        this(configurerLoader, L10nKey::getMessage);
    }

    public L10nLite(L10nConfigurerLoader configurerLoader, L10nMessageTranslator messageTranslator) {
        this.messageTranslator = messageTranslator;
        List<L10nValue> l10nValueList = configurerLoader.getL10nValues();
        this.l10nLiteBook = new HashMap<>(l10nValueList.size() << 1);
        for (L10nValue l10nValue : l10nValueList) {
            this.l10nLiteBook.put(l10nValue.getKey(), l10nValue.getValue());
        }
    }

    public String get(String message, String lang) {
        L10nKey l10nKey = L10nKey.build(message, lang);
        if (this.l10nLiteBook.containsKey(l10nKey)) {
            return this.l10nLiteBook.get(l10nKey);
        } else {
            String targetMessage = messageTranslator.translation(l10nKey);
            this.l10nLiteBook.put(l10nKey, targetMessage);
            return targetMessage;
        }
    }

    public String get(L10nKey key) {
        if (this.l10nLiteBook.containsKey(key)) {
            return this.l10nLiteBook.get(key);
        } else {
            String targetMessage = messageTranslator.translation(key);
            this.l10nLiteBook.put(key, targetMessage);
            return targetMessage;
        }
    }

    public void put(String originMessage, String lang, String targetMessage) {
        this.l10nLiteBook.put(L10nKey.build(originMessage, lang), targetMessage);
    }

    public boolean isEmpty() {
        return this.l10nLiteBook.isEmpty();
    }
}
