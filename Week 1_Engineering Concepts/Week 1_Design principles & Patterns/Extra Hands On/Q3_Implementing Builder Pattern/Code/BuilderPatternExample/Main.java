public class Main {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();
        System.out.println(gamingPC.getDetails());

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Windows 10")
                .build();
        System.out.println(officePC.getDetails());

        Computer basicPC = new Computer.Builder()
                .setCPU("AMD Ryzen 3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
        System.out.println(basicPC.getDetails());
    }
}