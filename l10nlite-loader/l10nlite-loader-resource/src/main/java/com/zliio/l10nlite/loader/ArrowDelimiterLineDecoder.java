package com.zliio.l10nlite.loader;

import com.zliio.l10nlite.core.L10nValue;

/**
 * Arrow Delimiter Line Decoder.
 *
 * @author Leo
 * @since 1.0 (2023-08-09)
 **/
public class ArrowDelimiterLineDecoder implements DelimiterLineDecoder {
    private final static String DELIMITER = "->";

    @Override
    public L10nValue decoderLine(String l10nValueLine, String lang) {
        String[] values = l10nValueLine.split(DELIMITER);
        if (values.length == 2) {
            return L10nValue.build(values[0].trim(), lang, values[1].trim());
        }
        return null;
    }
}
