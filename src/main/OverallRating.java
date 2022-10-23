package main;

public enum OverallRating {
    NO_DIFFERENT("No Different"), VERY_DIFFERENT("Very Different"), UNSURE("Unsure");

    private final String overallRating;

    OverallRating(String overallRating) {
        this.overallRating = overallRating;
    }
}
