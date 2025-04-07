package com.awe.salescoding.data;

public enum Goods {
    CD("music CD", "OTHER"),
    Parfume("bottle of perfume", "OTHER"),
    ChocolateBox("box of chocolates", "FOOD"),
    ChocolateBar("chocolate bar", "FOOD"),
    Pills("packet of headache pills", "MEDICAL"),
    Book("book", "BOOK");

    private final String name;
    private final String category;

    Goods(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public boolean isCategoryNotOther() {
        return !"OTHER".equals(this.category);
    }

    public static Goods fromName(String name) {
        for (Goods good : Goods.values()) {
            if (good.getName().equalsIgnoreCase(name)) {
                return good;
            }
        }
        throw new IllegalArgumentException("No enum constant with the name " + name);
    }
}
