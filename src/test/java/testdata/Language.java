package testdata;

public enum Language {
    RU("Компания", "Покупателю", "Пресс-центр", "Карьера"),
    EN("Company", "Consumer", "For Partners");

    public final String[] descriptions;

    Language(String... descriptions) {
        this.descriptions = descriptions;
    }
}