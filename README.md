# 🔗🗺📦 L10NLite

**_A lightweight [L10n ↗ ](https://en.wikipedia.org/wiki/Language_localisation) tool suitable for backend use_**

This is a lightweight localization method designed to simplify the localization process for backend programs and improve
localization efficiency. It provides a streamlined server-side localization solution.

**What is L10n?**

"L10n" is the abbreviation of "Localization", which refers to the
process of adapting an application or product to different languages, cultures, and regions so that it can be used in
different language and cultural environments. Localization typically includes translating text, adjusting date, time,
and currency formats, adapting icons and colors, modifying layout and typography, and so on. Localization is done to
improve user experience, expand market share, and increase revenue.

## Why?

There are a few reasons why you may need L10nLite:

1. Support for multiple languages - L10nLite helps you manage multiple language text resources in a simple way so you
   can easily translate your app into different languages.
2. Separation of code and text - L10nLite separates your code and text resources, making your code more maintainable and
   reusable. The text can be changed without modifying the code.
3. Small size - L10nLite has a small footprint, so it does not bloat your app with a large internationalization library.
4. Easy to configure - L10nLite is configured by simply adding text resources files for each language. It does not
   require complex XML configurations.
5. Strong extensibility. It provides L10nMessageTranslator and L10nConfigurerLoader, which allows you to freely choose
   the handling scheme for unknown fields, and supports multiple configuration acquisition schemes from various sources.

## Usage

~~~xml
<!-- ADD Maven Dependency -->
<dependencies>
    <groupId>com.zliio.l10nlite</groupId>
    <artifactId>l10nlite</artifactId>
    <version>1.0</version>
</dependencies>
~~~

Prepare multilingual configuration files under the resources directory in English, for example, the following contents
are configured under the resources:

~~~shell
-rw-r--r--@ 1 leo  staff    57B Jul 26 22:00 l10nlite-demo_DE.l10nlite
-rw-r--r--@ 1 leo  staff    56B Jul 26 22:00 l10nlite-demo_ES.l10nlite
-rw-r--r--@ 1 leo  staff    74B Jul 26 22:08 l10nlite-demo_KO.l10nlite
-rw-r--r--@ 1 leo  staff    58B Jul 26 22:00 l10nlite-demo_ZH.l10nlite
~~~

~~~shell
l10nlite-demo_DE.l10nlite
Hello World,Hello L10nLite -> Hallo Welt，Hallo L10nLite
~~~

~~~shell
l10nlite-demo_ES.l10nlite
Hello World,Hello L10nLite -> Hola Mundo，Hola L10nLite
~~~

~~~shell
l10nlite-demo_KO.l10nlite
Hello World,Hello L10nLite -> 안녕, 세상아，안녕하세요 L10nLite
~~~

~~~shell
l10nlite-demo_ZH.l10nlite
Hello World,Hello L10nLite -> 你好世界, 你好L10nLite
~~~

You can achieve the multilingual translation through the following code:

~~~java
public class L10nLiteTest {
    public static void main(String[] args) {
        String message = "Hello World,Hello L10nLite";
        L10nLite demol10nLite = new L10nLite(new ResourcesL10nConfigurerLoader("l10nlite-demo"));
        System.out.println(demol10nLite.get(message, "ZH"));
        // 你好世界, 你好L10nLite
        System.out.println(demol10nLite.get(message, "DE"));
        // Hallo Welt，Hallo L10nLite
        System.out.println(demol10nLite.get(message, "ES"));
        // Hola Mundo，Hola L10nLite
        System.out.println(demol10nLite.get(message, "KO"));
        // 안녕, 세상아，안녕하세요 L10nLite
        System.out.println(demol10nLite.get(message, "XX"));
        // Hello World,Hello L10nLite
    }
}
~~~



