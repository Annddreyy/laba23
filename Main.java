class Main {
    public static void main(String[] args) {
        Volt220 device220 = new Device220Volt();
        Volt380 device380 = new Device380Volt();

        Phone phone220 = new Phone(device220);
        PhoneAdapter phoneAdapter = new PhoneAdapter(device380);
        Phone phone380 = new Phone(phoneAdapter);

        phone220.chargePhone();
        phone380.chargePhone();
    }
}

interface Volt220{
    void charge();
}

interface Volt380{
    void work();
}

class Device220Volt implements Volt220{
    public final int volt = 220;
    public void charge(){
        System.out.println(volt);
    }
}

class Device380Volt implements Volt380{
    public final int volt = 380;
    public void work(){
        System.out.println(volt);
    }
}

class Phone{
    private Volt220 device;
    public Phone(Volt220 device){
        this.device = device;
    }
    public void chargePhone() {
        device.charge();
    }
}


class PhoneAdapter implements Volt220{
    private Volt380 device;
    public PhoneAdapter(Volt380 device){
        this.device = device;
    }
    public void charge(){
        device.work();
    }
}
