package com.zliio.l10nlite.loader;

import com.zliio.l10nlite.L10nConfigurerLoader;
import com.zliio.l10nlite.L10nValue;

import java.io.*;
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

    public ResourcesL10nConfigurerLoader(String fileName) {
        this(fileName, "/");
    }

    public ResourcesL10nConfigurerLoader(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
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
                    l10nValueList.addAll(readPropertiesFile(file));
                }
            }
        }
        return l10nValueList;
    }

    private List<L10nValue> readPropertiesFile(File file) {
        String fileName = file.getName();
        int startIndex = this.fileName.length();
        int endIndex = fileName.length() - ".l10nlite".length();
        String lang = fileName.substring(startIndex, endIndex);
        if (lang.startsWith("_")) {
            lang = lang.substring(1);
        }
        final String lang0 = lang;
        List<L10nValue> l10nValueList = new ArrayList<>();
        try (InputStream ins = Files.newInputStream(file.toPath())) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(ins))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    String[] values = inputLine.split("->");
                    if (values.length == 2) {
                        l10nValueList.add(L10nValue.build(values[0].trim(), lang0, values[1].trim()));
                    }
                }
            }
        } catch (IOException ignore) {
        }
        return l10nValueList;
    }
}
