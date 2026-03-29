public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
    }

    @Override
    public void buildRAM() {
        computer.setRamSize(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA GeForce RTX 5090");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
    }

    @Override
    public void buildAccessories() {
        computer.addAccessory("Mechanical Keyboard");
        computer.addAccessory("Gaming Mouse");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
