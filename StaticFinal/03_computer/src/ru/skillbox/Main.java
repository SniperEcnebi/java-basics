package ru.skillbox;

public class Main {

    public double totalWeight;

    public static void main(String[] args) {
        CPU cpu = new CPU(8, 10, "COre-i5 9900", 0.0123);
        RAM ram = new RAM("DDR4",32, 0.123);
        HardDrive hardDrive = new HardDrive("SSD", 400, 0.345);
        Screen screen = new Screen(32.5, "IPS", 2.5);
        KeyBoard keyBoard = new KeyBoard("MECHANICAL", true, 0.5);

        Computer computer = new Computer(cpu, ram, hardDrive, screen, keyBoard,"msi", "ASUS");
        System.out.println(computer);
        System.out.println(computer.getTotalWeight());

        }


}


