package domaine.properties;

import java.util.Locale;

/**
 * The type Language.
 */
public class Language {
    private String name;
    private Locale language;

    /**
     * Instantiates a new Language.
     *
     * @param name     the name
     * @param language the language
     */
    public Language(String name, Locale language) {
        this.name = name;
        this.language = language;
    }

    /**
     * Gets language.
     *
     * @return language language
     */
    public Locale getLanguage() {
        return language;
    }

    /**
     *
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }
}
