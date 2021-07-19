import java.awt.*;
import java.awt.event.*;
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
        System.out.print("| ( 5 ) Alarm          |\n");
        System.out.print("| ( 0 ) Exit           |\n");
        System.out.print("------------------------\n");
    }

    public void timeZones() {
        System.out.print("____---(TIME ZONE)---____\n");
        System.out.print("| Choose the Time Zone  |\n");
        System.out.print("| ( 1 ) Asia/Karachi    |\n");
        System.out.print("| ( 2 ) America/Cancun  |\n");
        System.out.print("| ( 3 ) Europe/Paris    |\n");
        System.out.print("| ( 4 ) Antarctica/Casey|\n");
        System.out.print("| ( 0 ) Exit            |\n");
        System.out.print("-------------------------\n");
    }

    public void dualTime() {
        System.out.print("____---(DUAL ZONES) ---____\n");
        System.out.print("| Choose the Time Zones   |\n");
        System.out.print("| ( 1 ) Karachi - Cancun  |\n");
        System.out.print("| ( 2 ) Casey - Paris     |\n");
        System.out.print("| ( 3 ) Berlin - Karachi  |\n");
        System.out.print("| ( 4 ) Cancun - Bucharest|\n");
        System.out.print("| ( 0 ) Exit              |\n");
        System.out.print("---------------------------\n");
    }

    public void setAlarm() {
        System.out.print("____----(SET ALARM)----____\n");
        System.out.print("| Set Alarm Type:         |\n");
        System.out.print("| ( 1 ) Alarm in CMD      |\n");
        System.out.print("| ( 2 ) Memento alarm     |\n");
        System.out.print("| ( 3 ) AWT Alarm         |\n");
        System.out.print("|                         |\n");
        System.out.print("| ( 0 ) Exit              |\n");
        System.out.print("---------------------------\n");
    }


    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {

        // Normal Time Zone
        Time bucharestTime = new Time("Europe/Bucharest", "no");
        Thread tBucharestTime = new Thread(bucharestTime);


        MainApp myObj = new MainApp();
        myObj.mainMenu();
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int command = keyboard.nextInt();
            if (command == 0) {
                clearConsole();
                System.out.println("See you soon!");
                System.exit(0);
            }
            clearConsole();
            switch (command) {





                // Bucharest Time
                case 1:
                    clearConsole();
                    tBucharestTime.start();
                    int command2 = keyboard.nextInt();
                    switch (command2) {
                        case 0:
                            clearConsole();
                            tBucharestTime.stop();
                            break;
                    }
                    break;





                // Time Zones
                case 2:
                    clearConsole();
                    myObj.timeZones();
                    String soloTimeZone = "Unknown";
                    int command3 = keyboard.nextInt();
                    clearConsole();
                    switch (command3) {
                        case 0:
                            break;

                        // Karachi Time
                        case 1:
                            soloTimeZone = "Asia/Karachi";
                            break;

                        // Cancun Time
                        case 2:
                            soloTimeZone = "America/Cancun";
                            break;

                        // Paris Time
                        case 3:
                            soloTimeZone = "Europe/Paris";
                            break;

                        // Casey Time
                        case 4:
                            soloTimeZone = "Antarctica/Casey";
                            break;
                    }

                    Time soloTime = new Time(soloTimeZone, "no");
                    Thread tSoloTime = new Thread(soloTime);
                    tSoloTime.start();
                    int command4 = keyboard.nextInt();
                    if (command4 == 0)
                        tSoloTime.stop();
                    clearConsole();

                    break;





                // Dual Time
                case 3:
                    clearConsole();
                    myObj.dualTime();
                    String dualTimeZone1 = "Unknown", dualTimeZone2 = "Unknown";
                    int dualTimeChoice = keyboard.nextInt();
                    clearConsole();
                    switch (dualTimeChoice) {
                        // Karachi - Cancun
                        case 1:
                            dualTimeZone1 = "Asia/Karachi";
                            dualTimeZone2 = "America/Cancun";
                            break;

                        // Casey - Paris
                        case 2:
                            dualTimeZone1 = "Antarctica/Casey";
                            dualTimeZone2 = "Europe/Paris";
                            break;

                        // Berlin - Karachi
                        case 3:
                            dualTimeZone1 = "Europe/Berlin";
                            dualTimeZone2 = "Asia/Karachi";
                            break;

                        // Cancun - Bucharest
                        case 4:
                            dualTimeZone1 = "America/Cancun";
                            dualTimeZone2 = "Europe/Bucharest";
                            break;
                    }

                    Time dualTime = new Time(dualTimeZone1, dualTimeZone2);
                    Thread tDualTime = new Thread(dualTime);
                    tDualTime.start();
                    int choice = keyboard.nextInt();
                    if(choice == 0)
                        tDualTime.stop();
                    clearConsole();

                    break;





                // Calendar
                case 4:
                    clearConsole();
                    //Calendar implementation
                    Calendar calendar = new Calendar();
                    calendar.execute();
                    int calendarChoice = keyboard.nextInt();
                    switch (calendarChoice) {
                        case 0:
                            break;
                    }
                    break;





                // Alarms
                case 5:
                    clearConsole();
                    myObj.setAlarm();
                    choice = keyboard.nextInt();
                    switch (choice) {

                        // CMD Alarm
                        case 1:
                            clearConsole();
                            System.out.println("Set the alarm ( EG: 00:00:00 ) :");
                            String alarm = keyboard.next();
                            String sendAlarm = "alarm + " + alarm;
                            Time alarmTime = new Time("Europe/Bucharest", sendAlarm);
                            Thread tAlarm = new Thread(alarmTime);
                            tAlarm.start();
                            break;

                        // Memento Alarm
                        case 2:
                            clearConsole();
                            System.out.println("Set the alarm ( EG: 00:00:00 ) :");
                            String mementoAlarm = keyboard.next();
                            System.out.println("Set the message for the memento :");
                            String mementoMessage = keyboard.next();
                            String sendMemento = "memento + " + mementoAlarm + " + " + mementoMessage;
                            Time mementoTime = new Time("Europe/Bucharest", sendMemento);
                            Thread tMemento = new Thread(mementoTime);
                            tMemento.start();
                            break;

                        // AWT Alarm
                        case 3:
                            clearConsole();
                            System.out.println("Set the alarm ( EG: 00:00:00 ) :");
                            String awtAlarm = keyboard.next();
                            System.out.println("Set the message for the AWT :");
                            String awtMessage = keyboard.next();
                            String sendAwt = "awt + " + awtAlarm + " + " + awtMessage;
                            Time awtTime = new Time("Europe/Bucharest", sendAwt);
                            Thread tAwt = new Thread(awtTime);
                            tAwt.start();
                            break;

                        case 0:
                            break;
                    }

            }
            myObj.mainMenu();
        }
    }
}

// AWT Frame
class Awt extends Frame {
    Awt(String message) {
        Label l1 = new Label(message);
        l1.setBounds(50,100,300,90);
        add(l1);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }
}


class Time implements Runnable {

    String timezone1, timezone2;
    boolean exit;

    public Time(String timezone1, String timezone2) {
        this.timezone1 = timezone1;
        this.timezone2 = timezone2;
        exit = false;
    }

    @Override
    public void run() {
        LocalTime localTime = LocalTime.now();
        while (!exit) {
            try {
                zonedDataTimeExample(timezone1, timezone2);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        exit = true;
    }

    public void zonedDataTimeExample(String zone1, String zone2) {

        String noDualTime = "no";

        Hashtable timeZones = new Hashtable();
        timeZones.put("Europe/Bucharest", 0);
        timeZones.put("Europe/Paris", -1);
        timeZones.put("Europe/Berlin", -1);
        timeZones.put("Asia/Karachi", 2);
        timeZones.put("America/Cancun", -8);
        timeZones.put("Antarctica/Casey", 8);

        LocalTime localTime1 = LocalTime.now();

        // Normal time or Time zones
        if(zone2.equals(noDualTime)) {
            LocalTime soloTime = localTime1.plusHours((int)timeZones.get(zone1));
            clearConsole();
            System.out.println(zone1 +": " + soloTime);
        }

        // Alarm in CMD Code
        else if (zone2.contains("alarm")) {
            // alarm + 00:00:00
            LocalTime soloTime = localTime1.plusHours((int) timeZones.get(zone1));
            String alarm2 = soloTime.toString().substring(0, soloTime.toString().length() - 4);
            String alarm = zone2.substring(8, zone2.length());
            if (alarm2.equals(alarm)) {
                System.out.println("Alarm set off!");
                stop();
            }
        }

        // Memento Code
        else if (zone2.contains("memento")) {
            // memento + 00:00:00 + message
            LocalTime soloTime = localTime1.plusHours((int)timeZones.get(zone1));
            String alarm2 = soloTime.toString().substring(0, soloTime.toString().length() - 4);
            String alarm = zone2.substring(10, 18);
            String message = zone2.substring(21, zone2.length());
            if(alarm2.equals(alarm)) {
                System.out.println(message);
                stop();
            }
        }

        //AWT Code
        else if (zone2.contains("awt")) {
            // awt + 00:00:00 + message
            LocalTime soloTime = localTime1.plusHours((int) timeZones.get(zone1));
            String alarm2 = soloTime.toString().substring(0, soloTime.toString().length() - 4);
            String alarm = zone2.substring(6, 14);
            String message = zone2.substring(17, zone2.length());
            if (alarm2.equals(alarm)) {
                Awt a = new Awt(message);
                stop();
            }
        }

        // Dual Time Zones Code
        else {
            LocalTime zonedTime1 = localTime1.plusHours((int)timeZones.get(zone1));
            LocalTime zonedTime2 = localTime1.plusHours((int)timeZones.get(zone2));
            clearConsole();
            System.out.println(zone1 + ": " + zonedTime1 + "             " + zone2 + ": " + zonedTime2);
        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

}


class Calendar {

    public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;
        return d;
    }

    // An bisect
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0)) return true;
        if (year % 400 == 0) return true;
        return false;
    }

    public static void execute() {

        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();


        int month = currentMonth;   // month (Jan = 1, Dec = 12)
        int year = currentYear;    // year

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
            if(i == currentDay) {
                System.out.printf("\033[0;1m" + "<%d>" + "\033[0;0m", i);
            }
            else if (i == currentDay - 1)
                System.out.printf("%d", i);
            else if (i == currentDay + 1)
                System.out.printf("%d ", i);
            else
                System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
        }

    }
}

