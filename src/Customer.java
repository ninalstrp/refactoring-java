import java.util.List;

public class Customer {
    private final String name;
    private List<MovieRental> rentals;

    public Customer(String name, List<MovieRental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement() {

        double totalAmount = 0;
        int bonusPoints = 0;

        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

        for (MovieRental r : rentals) {

            double rentalAmount;
            int rentalBonus;

            try {
                rentalAmount = r.getAmount();
                rentalBonus = r.getBonusPoints();
            } catch (Exception ex) {
                return "Error message: " + ex.getMessage();
            }

            bonusPoints += rentalBonus;

            String title = r.getMovieTitle();

            //print figures for this rental
            result.append("\t").append(title).append("\t").append(rentalAmount).append("\n");
            totalAmount = totalAmount + rentalAmount;
        }
        // add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(bonusPoints).append(" frequent points\n");

        return result.toString();
    }
}