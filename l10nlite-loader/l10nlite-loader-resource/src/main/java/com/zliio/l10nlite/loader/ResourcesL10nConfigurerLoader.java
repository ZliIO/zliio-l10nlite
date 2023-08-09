package com.zliio.l10nlite.loader;


import com.zliio.l10nlite.core.L10nConfigurerLoader;
import com.zliio.l10nlite.core.L10nValue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * ResourcesL10nConfigurerLoader.
 * {scenario}.properties.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
public class ResourcesL10nConfigurerLoader implements L10nConfigurerLoader {

    private final String fileName;

    private final String filePath;

    private final DelimiterLineDecoder delimiterLineDecoder;

    public ResourcesL10nConfigurerLoader(String fileName) {
        this(fileName, new ArrowDelimiterLineDecoder());
    }

    public ResourcesL10nConfigurerLoader(String fileName, DelimiterLineDecoder delimiterLineDecoder) {
        this(fileName, "/", delimiterLineDecoder);
    }

    public ResourcesL10nConfigurerLoader(
            String fileName,
            String filePath,
            DelimiterLineDecoder delimiterLineDecoder) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.delimiterLineDecoder = delimiterLineDecoder;
    }

    @Override
    public List<L10nValue> getL10nValues() {
        List<L10nValue> l10nValueList = new ArrayList<>();
        URL url = getClass().getResource(this.filePath);
        if (url != null) {
            File folder = new File(url.getFile());
            File[] files = folder.listFiles(
                    (dir, name) -> name.startsWith(this.fileName) && name.endsWith(".l10nlite"));
            if (files != null) {
                for (File file : files) {
                    l10nValueList.addAll(readL10nValueMapper(file));
                }
            }
        }
        return l10nValueList;
    }

    private List<L10nValue> readL10nValueMapper(File file) {
        String fileName = file.getName();
        int startIndex = this.fileName.length();
        int endIndex = fileName.length() - ".l10nlite".length();
        String lang = fileName.substring(startIndex, endIndex);
        if (lang.startsWith("_")) {
            lang = lang.substring(1);
        }
        final String lang0 = lang.toLowerCase();
        List<L10nValue> l10nValueList = new ArrayList<>();
        try (InputStream ins = Files.newInputStream(file.toPath())) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(ins))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    l10nValueList.add(delimiterLineDecoder.decoderLine(inputLine, lang0));
                }
            }
        } catch (IOException ignore) {
        }
        return l10nValueList;
    }
}
