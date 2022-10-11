public class MobilePhone implements ITelephone{
    private int myNumber;
    private boolean isRinging;
    private  boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("turning on");
    }

    @Override
    public void dial(int phoneNumber) {
        if (isOn) {
            System.out.println("ringing " + phoneNumber);
        } else {
            System.out.println("phone is off");
        }
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("answering");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn) {
            isRinging = true;
            System.out.println("ringing...");
        } else {
            isRinging = false;
            System.out.println("phone off");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
