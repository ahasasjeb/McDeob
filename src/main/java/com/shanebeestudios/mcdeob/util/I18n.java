package com.shanebeestudios.mcdeob.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class I18n {

    private static final Locale APP_LOCALE = resolveLocale();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("messages", APP_LOCALE);
    private static final ResourceBundle FALLBACK = ResourceBundle.getBundle("messages", Locale.ENGLISH);

    private I18n() {
    }

    public static String tr(String key, Object... args) {
        String pattern = getString(key);
        if (args.length == 0) return pattern;
        return MessageFormat.format(pattern, args);
    }

    public static Locale getLocale() {
        return APP_LOCALE;
    }

    private static String getString(String key) {
        try {
            return BUNDLE.getString(key);
        } catch (MissingResourceException ex) {
            try {
                return FALLBACK.getString(key);
            } catch (MissingResourceException ignored) {
                return key;
            }
        }
    }

    private static Locale resolveLocale() {
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale.getLanguage().equalsIgnoreCase(Locale.CHINESE.getLanguage())) {
            return Locale.SIMPLIFIED_CHINESE;
        }
        return Locale.ENGLISH;
    }
}
