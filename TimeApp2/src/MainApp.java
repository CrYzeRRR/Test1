
import java.io.IOException;
import java.util.*;
import java.time.*;


public class MainApp {

    public void mainMenu() {
        System.out.print("_____----(TIME)----_____\n");
        System.out.print("| ( 1 ) Show time      |\n");
        System.out.print("| ( 2 ) Time zones     |\n");
        System.out.print("| ( 3 ) Dual Time      |\n");
        System.out.print("| ( 4 ) Set Alarm      |\n");
        System.out.print("| ( 5 ) Calendar       |\n");
        System.out.print("| ( 0 ) Exit           |\n");
        System.out.print("------------------------\n");
    }

    public void timeZones() {
        System.out.print("____---(TIME ZONE)---____\n");
        System.out.print("| Choose the Time Zone  |\n");
        System.out.print("| ( 1 ) GMT (Greenwich) |\n");
        System.out.print("| ( 2 ) EST             |\n");
        System.out.print("| ( 3 ) New York        |\n");
        System.out.print("| ( 4 ) London          |\n");
        System.out.print("| ( 0 ) Exit            |\n");
        System.out.print("-------------------------\n");
    }

    public void dualTime() {
        System.out.print("____---(DUAL ZONES)---____\n");
        System.out.print("| Choose the Time Zones  |\n");
        System.out.print("| ( 1 ) Time zones 1     |\n");
        System.out.print("| ( 2 ) Time zones 2     |\n");
        System.out.print("| ( 3 ) Time zones 3     |\n");
        System.out.print("| ( 4 ) Time zones 4     |\n");
        System.out.print("| ( 0 ) Exit             |\n");
        System.out.print("--------------------------\n");
    }

    public void setAlarm() {
        System.out.print("____----(SET ALARM)----____\n");
        System.out.print("| Set Alarm Type:         |\n");
        System.out.print("| ( 1 ) Alarm 1           |\n");
        System.out.print("| ( 2 ) Alarm 2           |\n");
        System.out.print("| ( 3 ) Alarm 3           |\n");
        System.out.print("| ( 4 ) Alarm 4           |\n");
        System.out.print("| ( 0 ) Exit              |\n");
        System.out.print("---------------------------\n");
    }

    public void showCalendar() {
        System.out.print("____----(CALENDAR)----____\n");
        System.out.print("| days ....              |\n");
        System.out.print("|                        |\n");
        System.out.print("|                        |\n");
        System.out.print("|                        |\n");
        System.out.print("|                        |\n");
        System.out.print("|                        |\n");
        System.out.print("--------------------------\n");
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

    public static void main(String[] args) {
        Time time = new Time("Asia/Karachi");
        Thread t1 = new Thread(time);
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
                    t1.start();
                    clearConsole();
                    int command2 = keyboard.nextInt();
                    switch (command2) {
                        case 0:
                            t1.interrupt();
                            break;
                    }
                    break;
                case 2:
                    myObj.timeZones();
                    int command3 = keyboard.nextInt();
                    switch (command3) {
                        case 0:
                            break;
                    }
                    break;
                case 3:
                    myObj.dualTime();
                    break;
                case 4:
                    myObj.setAlarm();
                    break;
                case 5:
                    myObj.showCalendar();
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
    public Time(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public void run() {
        boolean flag = true;
        LocalTime localTime = LocalTime.now();
        while(flag) {
            LocalTime localTime1 = LocalTime.now();
            try {
                zonedDataTimeExample(timezone);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
            clearConsole();
        }
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

/*
TIME ZONES:
	Asia/Karachi
	Europe/Berlin
	Europe/Paris
	America/Cancun
 */
