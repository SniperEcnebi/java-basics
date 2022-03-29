package ru.skillbox;
public class Elevator {
    public int  currentFloor = 0;
    public int minFloor;
    public int maxFloor;

    public Elevator(int minFloor , int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }


    public void moveDown(){
        currentFloor = (currentFloor > minFloor) ? currentFloor - 1 :currentFloor ;
    }

    public void moveUp(){
        currentFloor = (currentFloor < maxFloor) ? currentFloor + 1 :currentFloor ;

    }


    public int getCurrentFloor(){
        return currentFloor;
    }

    public void move(int floor){
        if(floor > minFloor && floor < maxFloor){
            if (currentFloor < floor){
                while (currentFloor < floor){
                    moveUp();
                    System.out.println(currentFloor);
                }
            } else {
                while (currentFloor > floor) {
                    moveDown();
                    System.out.println(currentFloor);
                }
            }

        }else{
            System.out.println("Error out of range");
        }
    }



}
