import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/01.
 */
public class Main {
    private int periodStart, periodEnd;

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            main.printResult(line);
        }
    }

    void printResult(String line) {
        System.out.println(calculateWorkExperience(line));
    }

    public int calculateWorkExperience(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        return convertMonthsToYears(countMonthsEmployed(buildEmploymentList(input)));
    }

    private boolean[] buildEmploymentList(String input) {
        boolean[] wasEmployed = new boolean[372]; // the amount of months from Jan 1990 - Dec 2020

        resetState();

        String period;
        while (periodEnd > -1) {
            period = getNextPeriod(input);

            updateEmploymentWithPeriod(period, wasEmployed);
        }

        return wasEmployed;
    }

    private void resetState() {
        periodStart = 0;
        periodEnd = 0;
    }

    private String getNextPeriod(String input) {
        String period;

        periodEnd = input.indexOf(';', periodStart);
        if (periodEnd == -1) {
            period = input.substring(periodStart).trim();
        } else {
            period = input.substring(periodStart, periodEnd).trim();
        }
        periodStart = periodEnd + 1;

        return period;
    }

    private void updateEmploymentWithPeriod(String period, boolean[] wasEmployed) {
        int periodStartIndex = getPeriodIndex(period.substring(0, 8));
        int periodEndIndex = getPeriodIndex(period.substring(9));

        for (int i = periodStartIndex; i <= periodEndIndex; i++) {
            wasEmployed[i] = true;
        }
    }

    private int getPeriodIndex(String dateString) {
        // Don't want to use Date, because of execution time knock?
        int year = Integer.valueOf(dateString.substring(4)) - 1990;
        int month = 0;
        switch (dateString.charAt(0)) {
            case 'A': // Apr, Aug
                month = dateString.charAt(1) == 'p' ? 3 : 7;
                break;
            case 'D': // Dec
                month = 11;
                break;
            case 'F': // Feb
                month = 1;
                break;
            case 'J': // Jan, Jun, Jul
                if (dateString.charAt(1) == 'a') {
                    month = 0;
                } else {
                    month = dateString.charAt(2) == 'n' ? 5 : 6;
                }
                break;
            case 'M': // Mar, May
                month = dateString.charAt(2) == 'r' ? 2 : 4;
                break;
            case 'N': // Nov
                month = 10;
                break;
            case 'O': // Oct
                month = 9;
                break;
            case 'S': // Sep
                month = 8;
                break;
        }

        return month + (year * 12);
    }

    private short countMonthsEmployed(boolean[] wasEmployed) {
        short employed = 0;

        for (boolean employedThatMonth : wasEmployed) {
            if (employedThatMonth) {
                employed++;
            }
        }

        return employed;
    }

    private int convertMonthsToYears(short monthsExperience) {
        return monthsExperience / 12;
    }
}
