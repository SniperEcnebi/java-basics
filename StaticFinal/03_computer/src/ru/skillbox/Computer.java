package ru.skillbox;

public class Computer {



    public final CPU cpu;
    public final RAM ram;
    public final HardDrive hardDrive;
    public final Screen screen;
    public final KeyBoard keyBoard;
    public final String vendor;
    public final String name;
    public double totalWeight;

    @Override
    public String toString() {
        return "Computer: " +
                "cpu" + cpu +
                ", ram" + ram +
                ", hardDrive=" + hardDrive +
                ", screen=" + screen +
                ", keyBoard=" + keyBoard +
                ", vendor='" + vendor + '\'' +
                ", name='" + name + '\'';
    }

    public double getTotalWeight(){
        totalWeight = totalWeight + CPU.getWeight() + RAM.getWeight() + HardDrive.getWeight() + Screen.getWeight() + KeyBoard.getWeight();
        return totalWeight;
    }

    public Computer(CPU cpu, RAM ram, HardDrive hardDrive, Screen screen, KeyBoard keyBoard, String vendor, String name) {
        this.cpu = cpu;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.screen = screen;
        this.keyBoard = keyBoard;
        this.vendor = vendor;
        this.name = name;
    }

    public Computer setCpu(CPU cpu) {
        return new Computer(cpu, ram, hardDrive, screen, keyBoard, vendor, name);
    }

    public Computer setRam(RAM ram) {
        return new Computer(cpu, ram, hardDrive, screen, keyBoard, vendor, name);
    }

    public Computer setHardDrive(HardDrive hardDrive) {
        return new Computer(cpu, ram, hardDrive, screen, keyBoard, vendor, name);
    }

    public Computer setScreen(Screen screen) {
        return new Computer(cpu, ram, hardDrive, screen, keyBoard, vendor, name);
    }

    public Computer setKeyBoard(KeyBoard keyBoard) {
        return new Computer(cpu, ram, hardDrive, screen, keyBoard, vendor, name);
    }

    public Computer setVendor(String vendor) {
        return new Computer(cpu, ram, hardDrive, screen, keyBoard, vendor, name);
    }

    public Computer setName(String name) {
        return new Computer(cpu, ram, hardDrive, screen, keyBoard, vendor, name);
    }

    public CPU getCpu() {
        return cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public Screen getScreen() {
        return screen;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }
}
