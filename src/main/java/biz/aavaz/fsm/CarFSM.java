package biz.aavaz.fsm;

enum Car {

    PARKED {
        @Override
        public Car shiftGear(int input) {

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
        public Car shiftGear(int input) {

            switch (input) {
                case 0:
                    System.out.println("Going to park");
                    return Car.PARKED;
                case 1:
                    System.out.println("Continuing on moving");
                    return Car.MOVING;
                default:
                    System.out.println("Breakdown");
                    return Car.BROKEN;
            }
        }
    },
    BROKEN {
        
        @Override
        public Car shiftGear(int input) {
            this.price = 0;
            System.out.println("Still broken");
            return Car.BROKEN;
        }
    };

    //Other variables
    private int price;
    
    
    private void setPrice() {

    // this will refer to the object SMALL
    switch(this) {
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
        System.out.println("Constructor Called for " + this.name());
        price = 10;
    }

    public int getPrice() {
        this.setPrice();
        return price;
    }

    //Abstract methods
    public abstract Car shiftGear(int input);

}
