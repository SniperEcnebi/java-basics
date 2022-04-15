package ru.skillbox;
public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.print("Basket contains");
        basket.add("Milk", 40,5,1);
        System.out.println(Basket.getCount());
        System.out.println(Basket.averagePriceOfBasket());
        System.out.println(Basket.averagePriceInBaskets());

    }
}
