package main;

public class Summary {

    private OverallRating overallRating;
    private int total;
    private int severityScore;

    public Summary(OverallRating overallRating, int total, int severityScore) {
        this.overallRating = overallRating;
        this.total = total;
        this.severityScore = severityScore;
    }

    public OverallRating getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(OverallRating overallRating) {
        this.overallRating = overallRating;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSeverityScore() {
        return severityScore;
    }

    public void setSeverityScore(int severityScore) {
        this.severityScore = severityScore;
    }
}
