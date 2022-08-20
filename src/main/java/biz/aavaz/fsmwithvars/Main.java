package biz.aavaz.fsmwithvars;

enum Car {

    PARKED {
        @Override
        public Car transition(int input) {

            switch (input) {
                case 0:
                    return Car.PARKED;
                case 1:
                    System.out.println("Transitioning to moving");
                    Car newCar = Car.MOVING;
                    newCar.price = 100;
                    return newCar;
                default:
                    System.out.println("Broke down");
                    return Car.BROKEN;
            }
        }
    },
    MOVING {
        @Override
        public Car transition(int input) {

            switch (input) {
                case 0:
                    System.out.println("Going to park");
                    return Car.PARKED;
                default:
                    System.out.println("Breakdown");
                    return Car.BROKEN;
            }
        }
    },
    BROKEN {
        @Override
        public Car transition(int input) {
            this.price = 0;
            System.out.println("Still broken");
            return Car.BROKEN;
        }
    };

    public int price;

    Car() {
        System.out.println("Constructor Called");
        price = 10;
    }

    public abstract Car transition(int input);

    int getPrice() {
        return price;
    }
}

public class Main {

    public static void main(String args[]) {

        Car aCar = Car.valueOf("PARKED");
        System.out.println("aCar.price: " + aCar.price);
        aCar = aCar.transition(1);
        System.out.println(aCar.getPrice());
        aCar = aCar.transition(1);
        System.out.println(aCar.getPrice());

    }
}
