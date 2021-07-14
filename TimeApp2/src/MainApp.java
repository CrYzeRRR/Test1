
import java.io.IOException;
import java.util.*;
import java.time.*;


public class MainApp {

    public void mainMenu() {
        System.out.print("_____----(TIME)----_____\n");
        System.out.print("| ( 1 ) Show time      |\n");
        System.out.print("| ( 2 ) Time zones     |\n");
        System.out.print("| ( 3 ) Dual Time      |\n");
        System.out.print("| ( 4 ) Calendar       |\n");
        System.out.print("| ( 0 ) Exit           |\n");
        System.out.print("------------------------\n");
    }

    public void timeZones() {
        System.out.print("____---(TIME ZONE)---____\n");
        System.out.print("| Choose the Time Zone  |\n");
        System.out.print("| ( 1 ) Asia/Karachi    |\n");
        System.out.print("| ( 2 ) America/Cancun  |\n");
        System.out.print("| ( 3 ) Europe/Paris    |\n");
        System.out.print("| ( 4 )                 |\n");
        System.out.print("| ( 0 ) Exit            |\n");
        System.out.print("-------------------------\n");
    }

    public void dualTime() {
        System.out.print("____---(DUAL ZONES)---____\n");
        System.out.print("| Choose the Time Zones  |\n");
        System.out.print("| ( 1 ) Karachi - Cancun |\n");
        System.out.print("| ( 2 ) Cancun - Paris   |\n");
        System.out.print("| ( 3 ) Paris - Bucharest|\n");
        System.out.print("| ( 4 ) Cancun - Berlin  |\n");
        System.out.print("| ( 0 ) Exit             |\n");
        System.out.print("--------------------------\n");
    }

//    public void setAlarm() {
//        System.out.print("____----(SET ALARM)----____\n");
//        System.out.print("| Set Alarm Type:         |\n");
//        System.out.print("| ( 1 ) Alarm 1           |\n");
//        System.out.print("| ( 2 ) Alarm 2           |\n");
//        System.out.print("| ( 3 ) Alarm 3           |\n");
//        System.out.print("| ( 4 ) Alarm 4           |\n");
//        System.out.print("| ( 0 ) Exit              |\n");
//        System.out.print("---------------------------\n");
//    }


    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch(IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {

        // Normal Time Zone
        Time time = new Time("Europe/Bucharest");
        Thread t1 = new Thread(time);

        // Asia/Karachi Time Zone
        Time karachiTime = new Time("Asia/Karachi");
        Thread tKarachi = new Thread(karachiTime);

        // America/Cancun Time Zone
        Time cancunTime = new Time("America/Cancun");
        Thread tCancun = new Thread(cancunTime);

        // Europe/Berlin Time Zone
        Time berlinTime = new Time("Europe/Paris");
        Thread tBerlin = new Thread(berlinTime);

        // Europe/Paris Time Zone
        Time parisTime = new Time("Europe/Paris");
        Thread tParis = new Thread(parisTime);

        // Europe/Bucharest Time Zone
        Time buchTime = new Time("Europe/Bucharest");
        Thread tBucharest = new Thread(buchTime);

        MainApp myObj = new MainApp();
        myObj.mainMenu();
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            int command = keyboard.nextInt();
            if (command == 0) {
                System.out.println("See you soon!");
                System.exit(0);
            }
            switch(command) {
                case 1:
                    clearConsole();
                    t1.start();
                    int command2 = keyboard.nextInt();
                    switch (command2) {
                        case 0:
                            clearConsole();
                            t1.stop();
                            break;
                    }
                    break;
                case 2:
                    myObj.timeZones();
                    int command3 = keyboard.nextInt();
                    switch (command3) {
                        case 0:
                            break;

                        // Karachi Time
                        case 1:
                            clearConsole();
                            tKarachi.start();
                            int karachiChoice = keyboard.nextInt();
                            switch (karachiChoice) {
                                case 0:
                                    clearConsole();
                                    tKarachi.stop();
                                    break;
                            }
                            break;

                        // Berlin Time
                        case 2:
                            clearConsole();
                            tBerlin.start();
                            int berlinChoice = keyboard.nextInt();
                            switch (berlinChoice) {
                                case 0:
                                    clearConsole();
                                    tBerlin.stop();
                                    break;
                            }
                            break;

                        // Cancun Time
                        case 3:
                            clearConsole();
                            tCancun.start();
                            int cancunChoice = keyboard.nextInt();
                            switch (cancunChoice) {
                                case 0:
                                    clearConsole();
                                    tCancun.stop();
                                    break;
                            }
                            break;
                    }
                    break;

                // Dual Time
                case 3:
                    myObj.dualTime();
                    int dualTimeChoice = keyboard.nextInt();
                    boolean flag3;
                    int ch1;
                    switch(dualTimeChoice) {

                        // Karachi - Cancun
                        case 1:
                            clearConsole();
                            flag3 = true;
                            tKarachi.start();
                            tCancun.start();
                            ch1 = keyboard.nextInt();
                            switch (ch1) {
                                case 0:
                                    clearConsole();
                                    flag3 = false;
                                    tKarachi.stop();
                                    tCancun.stop();
                                    break;
                            }
                            break;

                        // Cancun - Paris
                        case 2:
                            clearConsole();
                            flag3 = true;
                            tCancun.start();
                            tParis.start();
                            ch1 = keyboard.nextInt();
                            switch (ch1) {
                                case 0:
                                    clearConsole();
                                    flag3 = false;
                                    tCancun.stop();
                                    tParis.stop();
                                    break;
                            }
                            break;

                        // Paris - Bucharest
                        case 3:
                            clearConsole();
                            flag3 = true;
                            tParis.start();
                            tBucharest.start();
                            ch1 = keyboard.nextInt();
                            switch (ch1) {
                                case 0:
                                    clearConsole();
                                    flag3 = false;
                                    tParis.stop();
                                    tBucharest.stop();
                                    break;
                            }
                            break;

                        // Cancun - Paris
                        case 4:
                            clearConsole();
                            flag3 = true;
                            tCancun.start();
                            tParis.start();
                            ch1 = keyboard.nextInt();
                            switch (ch1) {
                                case 0:
                                    clearConsole();
                                    flag3 = false;
                                    tCancun.stop();
                                    tParis.stop();
                                    break;
                            }
                            break;
                    }
                    break;

//                case 4:
//                    clearConsole();
//                    System.out.println("Set the the time you want to set the alarm to :");
//                    String alarm = keyboard.next();
//                    System.out.println(alarm);
//                    LocalTime localTime = LocalTime.now();
//                    String localAlarm = localTime.toString();
//                    boolean flag2 = true;
//                    while(flag2) {
//                        if (localAlarm == alarm) {
//                            System.out.println("ALAAARM");
//                            flag = false;
//                        }
//                    }
//                    System.out.println(localTime);
//                    break;

                case 4:
                    clearConsole();
                    //Calendar implementation
                    Calendar calendar = new Calendar();
                    calendar.execute(7,2021);
                    int calendarChoice = keyboard.nextInt();
                    switch (calendarChoice) {
                        case 0:
                            break;
                    }
                    break;
            }
            myObj.mainMenu();
        }
    }
}

class Time implements Runnable {

    String timezone;
    boolean exit;
    public Time(String timezone) {
        this.timezone = timezone;
        exit = false;
    }

    @Override
    public void run() {
        LocalTime localTime = LocalTime.now();
        while(!exit) {
            try {
                zonedDataTimeExample(timezone);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearConsole();
        }
    }

    public void stop() {
        exit = true;
    }

    /*
        TODO: Cu enum
     */
    public void zonedDataTimeExample(String zone) {
        final ZoneId zoneId = ZoneId.of(zone);
        final ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), zoneId);
        LocalTime localTime = zonedDateTime.toLocalTime();
        System.out.println(localTime);
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch(IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

}

class Calendar {

    public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

    // An bisect
    public static boolean isLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
        if  (year % 400 == 0) return true;
        return false;
    }

    public static void execute(int month1, int year1){
        int month = month1;   // month (Jan = 1, Dec = 12)
        int year = year1;    // year

        // months[i] = luna i
        String[] months = {
                "",
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };

        // days[i] = cate zile in luna i
        int[] days = {
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        // verifica an bisect
        if (month == 2 && isLeapYear(year)) days[month] = 29;


        // header
        System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");

        int d = day(month, 1, year);

        // print calendar
        for (int i = 0; i < d; i++)
            System.out.print("   ");
        for (int i = 1; i <= days[month]; i++) {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
        }

    }
}

/*
TIME ZONES:
	Asia/Karachi
	Europe/Berlin
	Europe/Paris
	America/Cancun
 */
