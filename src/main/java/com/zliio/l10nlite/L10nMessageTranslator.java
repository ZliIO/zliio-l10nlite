package com.zliio.l10nlite;

/**
 * Message Translator.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
@FunctionalInterface
public interface L10nMessageTranslator {
    String translation(L10nKey l10nKey);
}
