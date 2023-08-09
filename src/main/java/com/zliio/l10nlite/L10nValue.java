package com.zliio.l10nlite;

/**
 * L10nValue.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
public class L10nValue {
    private final L10nKey key;

    private final String value;

    private L10nValue(String key, String lang, String value) {
        this.key = L10nKey.build(key, lang);
        this.value = value;
    }

    public static L10nValue build(String originMessage, String lang, String targetMessage) {
        return new L10nValue(originMessage, lang, targetMessage);
    }

    public L10nKey getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
