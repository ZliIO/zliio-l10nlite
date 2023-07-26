package com.zliio.l10nlite.core;

import java.util.Objects;

/**
 * L10nKey.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
public final class L10nKey {
    private final String message;
    private final String lang;
    private final Integer hashCode;

    private L10nKey(String message, String lang) {
        this.message = message;
        this.lang = lang;
        this.hashCode = (this.message + this.lang).hashCode();
    }

    public static L10nKey build(String message, String lang) {
        return new L10nKey(message, lang);
    }

    public String getMessage() {
        return message;
    }

    public String getLang() {
        return lang;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof L10nKey) {
            L10nKey l10nKey = (L10nKey) obj;
            return l10nKey.getMessage().equals(this.message)
                    && l10nKey.getLang().equals(this.lang);
        }
        return false;
    }
}
