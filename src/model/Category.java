package model;

public enum Category {
    FOOD,
    TRANSPORTATION,
    UTILITIES,
    ENTERTAINMENT,
    CLOTHING,
    HEALTH,
    OTHER;

    public static Category fromString(String text) {
        for (Category b : Category.values()) {
            if (b.name().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return OTHER;
    }
}