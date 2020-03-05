public class Player implements Comparable<Player> {
    private String firstName;
    private String lastName;
    private double score;

    public Player(String firstName, String lastName, double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getScore() {
        return score;
    }

    @Override
    public int compareTo(Player o) {
        if (this.score > o.score)
            return 1;
        else if (this.score < o.score)
            return -1;
        else {
            return this.firstName.compareTo(o.firstName);
        }
    }
}
