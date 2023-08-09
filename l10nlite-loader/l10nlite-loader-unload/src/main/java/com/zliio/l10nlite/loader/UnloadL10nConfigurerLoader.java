package com.zliio.l10nlite.loader;


import com.zliio.l10nlite.core.L10nConfigurerLoader;
import com.zliio.l10nlite.core.L10nValue;

import java.util.ArrayList;
import java.util.List;

/**
 * UnloadL10nConfigurerLoader.
 *
 * @author Leo
 * @since 1.0 (2023-07-26)
 **/
public class UnloadL10nConfigurerLoader implements L10nConfigurerLoader {

    @Override
    public List<L10nValue> getL10nValues() {
        return new ArrayList<>();
    }
}
