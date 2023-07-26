package com.zliio.l10nlite.core;

import java.util.List;

/**
 * Configure Loader.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
@FunctionalInterface
public interface L10nConfigurerLoader {
    List<L10nValue> getL10nValues();
}
