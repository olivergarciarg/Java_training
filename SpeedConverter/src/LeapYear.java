public class LeapYear {
    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if (year >= 1 && year <= 9999) {
          if (year % 4 == 0) { // step 1
              if (year % 100 == 0) { // step 2
                  if (year % 400 == 0) { // step 3
                    isLeap = true; // step 4
                  }
              } else { // step 3
                  isLeap = true; // step 3
              }
          }
        }
        return isLeap;
    }
}
