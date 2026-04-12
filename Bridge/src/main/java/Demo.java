public class Demo {
    public static void main(String[] args) {
        Device smartTV = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTV);


        smartRemote.power();
        smartRemote.volumeUp();
        smartRemote.channelUp();
        smartTV.printStatus();


        smartRemote.voiceControl("open youtube");
        smartRemote.voiceControl("volume up");
        smartRemote.voiceControl("power off");
    }
}
