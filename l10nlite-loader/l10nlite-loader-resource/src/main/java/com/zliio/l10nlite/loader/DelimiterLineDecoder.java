package com.zliio.l10nlite.loader;

import com.zliio.l10nlite.core.L10nValue;

/**
 * DelimiterLineDecoder.
 *
 * @author Leo
 * @since 1.0 (2023-08-09)
 **/
public interface DelimiterLineDecoder {
    L10nValue decoderLine(String l10nValueLine, String lang);
}
