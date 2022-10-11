public class Main {
    public static void main(String[] args) {
        // ITelephone timsPhone;
        // DeskPhone timsPhone;
        ITelephone timsPhone = new DeskPhone(12345);
        timsPhone.powerOn();
        timsPhone.callPhone(12345);
        timsPhone.answer();

        timsPhone = new MobilePhone(789);
        timsPhone.powerOn();
        timsPhone.callPhone(789);
        timsPhone.answer();
    }
}