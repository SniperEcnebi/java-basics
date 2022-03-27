public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.print("Basket contains");
        basket.add("Milk", 40,5,1);
        System.out.println("Общая стоимость товаров:" + basket.getTotalPrice());
        System.out.println("Общий вес товаров:" + basket.getTotalWeight());
        basket.clear();
        System.out.println();
        basket.print("Basket contains");
        System.out.println("Общая стоимость товаров:" + basket.getTotalPrice());
        System.out.println("Общий вес товаров:" + basket.getTotalWeight());
    }
}
