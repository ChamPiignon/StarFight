package domaine.properties;

import java.util.Locale;

public class Language {
    private String name;
    private Locale language;

    public Language(String name, Locale language) {
        this.name = name;
        this.language = language;
    }

    public Locale getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return name;
    }
}
