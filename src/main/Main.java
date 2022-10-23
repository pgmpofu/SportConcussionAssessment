package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static boolean hasCompletedAssessment = false;

    public static void main(String[] args) {

        System.out.println("Welcome to Sport Concussion Assessment System");
        displayOptions();
        Scanner scanner = new Scanner(System.in);

        List<Summary> history = new ArrayList<>();
        Athlete athlete = new Athlete();

        while (scanner.hasNextInt()) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> enterSymptoms(athlete, scanner);
                case 2 -> displaySymptomsSummary(athlete, history);
                case 3 -> {
                    if (history.isEmpty()) {
                        System.out.println("No information available. Please take at least 1 assessment");
                    } else {
                        displayRisk(history.get(history.size() - 1));
                    }
                }
                case 4 -> exitSystem();
                default -> System.out.println("Please enter a number between 1 and 4");
            }
            displayOptions();
        }
    }

    public static void displayOptions() {
        System.out.println("Please select one of the following options");
        System.out.println("1. Enter Symptoms");
        System.out.println("2. Display Symptoms Summary");
        System.out.println("3. Am I at Risk?");
        System.out.println("4. Exit");
        System.out.println("Enter your choice (1-4):");
    }

    public static void displayRisk(Summary summary) {
        final String ANSI_GREEN = "\u001b[32m";
        final String ANSI_YELLOW = "\u001b[33m";
        final String ANSI_RED = "\u001b[31m";
        final String ANSI_RESET = "\u001b[0m";

        switch (summary.getOverallRating()) {
            case NO_DIFFERENT -> System.out.println(ANSI_GREEN + summary.getOverallRating().name() + ANSI_RESET);
            case UNSURE -> System.out.println(ANSI_YELLOW + summary.getOverallRating().name() + ANSI_RESET);
            default -> System.out.println(ANSI_RED + summary.getOverallRating().name() + ANSI_RESET);
        }
    }

    public static void exitSystem() {
        System.out.println("Goodbye!");
        System.exit(4);
    }

    public static void enterSymptoms(Athlete athlete, Scanner scanner) {
        athlete.getSymptoms().forEach(s -> {
            System.out.println("Please enter your " + s.getName() + " score: none (0), mild (1-2), moderate (3-4), & severe (5 - 6)");
            if (scanner.hasNextInt()) {
                s.setSeverity(scanner.nextInt());
            } else {
                System.out.println("Please enter a numeric score between 1 and 6");
                System.exit(1);
            }
        });
        hasCompletedAssessment = true;
    }

    public static void displaySymptomsSummary(Athlete athlete, List<Summary> history) {
        int severityScore = athlete.getSymptoms().stream().mapToInt(Symptom::getSeverity).sum();
        int total = athlete.getSymptoms().size();
        if (!history.isEmpty()) {
            Summary lastSavedSummary = history.get(history.size() - 1);
            if (Math.abs(lastSavedSummary.getSeverityScore() - severityScore) < 3 && severityScore < 10 && hasCompletedAssessment) {
                history.add(new Summary(OverallRating.NO_DIFFERENT, total, severityScore));
            } else if (Math.abs(lastSavedSummary.getSeverityScore() - severityScore) < 3 && severityScore >= 10 && hasCompletedAssessment) {
                history.add(new Summary(OverallRating.UNSURE, total, severityScore));
            } else if ((Math.abs(lastSavedSummary.getSeverityScore() - severityScore) > 3 && hasCompletedAssessment) || (severityScore >= 15 && hasCompletedAssessment)) {
                history.add(new Summary(OverallRating.VERY_DIFFERENT, total, severityScore));
            }
        } else {
            history.add(new Summary(null, total, severityScore));
        }

        Summary finalSummary = history.get(history.size() - 1);
        System.out.println("Total Symptoms " + finalSummary.getTotal());
        System.out.println("Severity Score " + finalSummary.getSeverityScore());
        System.out.println("Overall Rating " + (finalSummary.getOverallRating() == null ? null : finalSummary.getOverallRating().name()));
    }
}
