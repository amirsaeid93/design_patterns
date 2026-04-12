public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("Voice command received: " + command);

        switch (command.toLowerCase()) {
            case "volume up":
                volumeUp();
                break;
            case "volume down":
                volumeDown();
                break;
            case "power on":
                device.enable();
                break;
            case "power off":
                device.disable();
                break;
            case "open youtube":
                if (device instanceof SmartTV) {
                    ((SmartTV) device).browseInternet("https://www.youtube.com");
                } else {
                    System.out.println("This device does not support browsing.");
                }
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
