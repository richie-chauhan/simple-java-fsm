package biz.aavaz.fsm;

enum Car {

    PARKED {
        @Override
        public Car shiftGear(int input) {

            switch (input) {
                case 0:
                    return this;
                case 1:
                    System.out.println("Transitioning to moving");
                    return Car.MOVING;
                default:
                    System.out.println("Broke down");
                    return Car.BROKEN;
            }
        }
    },
    MOVING {
        @Override
        public Car shiftGear(int input) {

            switch (input) {
                case 0:
                    System.out.println("Going to park");
                    return Car.PARKED;
                case 1:
                    System.out.println("Continuing on moving");
                    return this;
                default:
                    System.out.println("Breakdown");
                    return Car.BROKEN;
            }
        }
    },
    BROKEN(0) { //Not using the default constructor here
        @Override
        public Car shiftGear(int input) {
            System.out.println("Still broken");
            return this;
        }
    };

    //https://www.programiz.com/java-programming/enum-string
    //https://www.programiz.com/java-programming/enum-constructor
    //Other variables
    private int price;

    private void setPrice() {

        // this will refer to the object SMALL
        switch (this) {
            case PARKED:
                this.price = 10;
                break;

            case MOVING:
                this.price = 100;
                break;

            case BROKEN:
                this.price = 0;
                break;

            default:
                this.price = 0;
                break;
        }
    }

    Car() {
        System.out.println("Default Constructor Called for " + this.name());
        this.price = 0;

        switch (this.name()) { //Note this is different than setPrice - because the object is not yet initialized here
            case "PARKED":
                this.price = 10;
                break;

            case "MOVING":
                this.price = 100;
                break;

            case "BROKEN":
                this.price = 0;
                break;

            default:
                this.price = 0;
                break;
        }
    }
    
    Car(int price){
        System.out.println("NOT Default Constructor Called for " + this.name());
        this.price = price;
    }

    public int getPrice() {
        this.setPrice();
        return price;
    }

    //Abstract methods
    public abstract Car shiftGear(int input);

}
