package com.zliio.l10nlite.loader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zliio.l10nlite.core.L10nValue;

/**
 * Arrow Delimiter Line Decoder.
 *
 * @author Leo
 * @since 1.0 (2023-08-09)
 **/
public class JsonDelimiterLineDecoder implements DelimiterLineDecoder {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public L10nValue decoderLine(String l10nValueLine, String lang) {
        try {
            Mapper mapper = objectMapper.readValue(l10nValueLine,Mapper.class);
            return L10nValue.build(mapper.getKey(), lang, mapper.getValue());
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    private static class Mapper {
        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
