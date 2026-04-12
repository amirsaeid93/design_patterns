public class SmartTV implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("The SmartTV is now ON.");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("The SmartTV is now OFF.");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(volume, 100));
        System.out.println("SmartTVs volume is set to " + this.volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("The SmartTVs channel is set to " + this.channel);
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("SmartTVs statuses are:");
        System.out.println("Power: " + (on ? "ON" : "OFF"));
        System.out.println("Volume: " + volume);
        System.out.println("Channel: " + channel);
        System.out.println("------------------------------------");
    }


    public void browseInternet(String url) {
        if (on) {
            System.out.println("Browsing to: " + url);
        } else {
            System.out.println("Turning on the SmartTV to browse the internet.");
        }
    }
}
