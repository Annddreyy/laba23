import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Volt220 device220 = new Device220Volt();
        Volt380 device380 = new Device380Volt();

        device220.printVolt220();
        device380.printVolt380();

        Phone phone220 = new Phone(device220);
        PhoneAdapter phone380 = new PhoneAdapter(device380);

        phone220.charge();
        phone380.charge();
    }
}

interface Volt220{
    void printVolt220();
}

interface Volt380{
    void printVolt380();
}

class Device220Volt implements Volt220{
    public void printVolt220(){
        System.out.println(220);
    }
}

class Device380Volt implements Volt380{
    public void printVolt380(){
        System.out.println(380);
    }
}

class Phone{
    private Volt220 device;
    public Phone(Volt220 device){
        this.device = device;
    }

    public void charge(){
        device.printVolt220();
    }
}


class PhoneAdapter{
    private Volt380 device;
    public PhoneAdapter(Volt380 device){
        this.device = device;
    }

    public void charge(){
        device.printVolt380();
    }
}