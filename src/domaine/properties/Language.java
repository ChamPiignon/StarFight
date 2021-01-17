package domaine.properties;

import java.util.Locale;

public class Language {
    private String name;
    private Locale language;

    /**
     *
     * @param name
     * @param language
     */
    public Language(String name, Locale language) {
        this.name = name;
        this.language = language;
    }

    /**
     *
     * @return language
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
