class Bicycle {
    String define_me() {
        return "a cycle who is a vehicle with pedals.";
    }
}

class Motorcycle extends Bicycle {
    String define_me() {
        return "a cycle with an engine.";
    }

    Motorcycle() {
        System.out.println("Hello I am a motorcycle, I am " + define_me());
        System.out.println("My ancestor is " + super.define_me());
    }
}

public class w7s1tk2 {
    public static void main(String[] args) {
        Motorcycle M = new Motorcycle();
    }
}
