import java.util.ArrayList;
import java.util.List;

/**
 /**
 * Represents a Course with multiple Students.
 * This class allows adding students, retrieving them by seat number,
 * and displaying the list of enrolled students.
 *
 * @author navlok01
 * @since 2025.02.26
 * @version 1.0 beta
 * @see <a href="https://https://github.com/vlokkie082/Attendence_App1.git">GitHub Repository</a>
 */


public class course {

    /** The name of the course. */

    private String courseName;

    /** List of students enrolled in the course. */
    private final List<Students> students;

    /**
     * Default constructor that initializes the course with an "Unknown" name
     * and an empty student list.
     */
    public Course() {
        courseName = "Unknown";
        students = new ArrayList<>();
    }

    /**
     * Overloaded constructor that sets the course name.
     *
     * @param courseName The name of the course.
     * @throws Exception If the course name is blank.
     */

    public Course(String courseName) throws Exception {
        this();
        setCourseName(courseName);
    }

    /**
     * Gets the team's name.
     * @return The team's name.
     */
    public String getName() { return name; }

    /**
     * Set the teams's name.
     * @param name the teams's name
     * @throws Exception if the team's name is blank (whitespace or empty)<br>
     * Error Example: Student name can not be blank.
     */
    public void setName(String name) throws Exception {
        name = name.trim(); // remove leading and trailing whitespace

        //isBlank checks for both empty or whitespace
        if (name.isBlank())
            throw new Exception("Student name can not be blank.");

        this.name = name;
    } // end of setName method

    /**
     * Get a Player by their jersey number using the ArrayList.indexOf method<br>
     * If the indexOf method returns -1 then this method returns null otherwise,<br>
     * it returns the Player object associated with the jersey number.
     * @param jersey The Player's jersey number.
     * @return If a Player is found, it will return the Player object otherwise a null value.
     * @throws Exception Creating a player with a invalid jersey number could throw an error
     */
    public Player getPlayer(int jersey) throws Exception {

        int index = players.indexOf(new Player(jersey));

        if (index == -1)
            return null;
        else
            return players.get(index);

    }

    /**
     * Add a player to the Team, by using the overload constructor that allows setting their name and jersey number too.<br>
     * This method will verify that the jersey number is not already used by another player by calling the Team.getPlayer method.<br>
     * and if it is, then it will throw an exception back to the calling method
     * @param name The Player's name.
     * @param jersey The Player's jersey number.
     * @throws Exception Jersey number # already assigned.
     */
    public void addPlayer(String name, int jersey) throws Exception {
        Player player = getPlayer(jersey);
        if(player == null) {
            players.add(new Player(jersey, name));
        } else {
            throw new Exception("Jersey #" + jersey + " already assigned to " + player.getName() + "!");
        }
    }


    /**
     * Get the total number of points for the entire Team by calling the Player.getPoints method.
     * Uses a for loop to sum all the team's players points by calling the player's getPoints
     * method.
     * @return The Teams's points.
     */
    public int getTeamPoints() {
        int totalPoints = 0;

        for (Player player : players) {
            totalPoints += player.getPoints();
        }

        return totalPoints;
    }

    /**
     * Get the total number of fouls for the entire Team using the Player.getFouls method.
     * Uses a for loop to sum all the team's players fouls by calling the player's getFouls
     * method.
     * @return The total number of fouls for the Team.
     */
    public int getTeamFouls() {
        int totalFouls = 0;

        for (Player player : players) {
            totalFouls += player.getFouls();
        }

        return totalFouls;
    }

    /**
     * Display the Team's summary stats using the Team.getTeamFouls and getTeamPoints methods.<br>
     * Example: <br>
     * <pre>Team Wildcats Fouls=4 Points=23</pre>
     */
    public void displayTeamStats() {
        System.out.println("Team " + name + " Fouls=" + getTeamFouls() + " Points=" + getTeamPoints());
    }

    /**
     * Displays each Player's detail stats for the entire Team using the Player's getter methods.<br>
     * This method uses the printf method for proper stats alignment. Example:<br>
     * <pre>
     * Jersey Name            Fouls 1pt 2pt 3pt Total
     * ====== =============== ===== === === === =====
     *    10  Billy               1   2   3   1    10
     *    24  Tammy               0   0   2   0     4
     * </pre>
     */
    public void displayDetailStats() {

        Player player;

        displayTeamStats();

        System.out.println("Jersey Name            Fouls 1pt 2pt 3pt Total");
        System.out.println("====== =============== ===== === === === =====");

        for (Player value : players) {

            player = value;

            System.out.printf("%6d %-15s %5d %3d %3d %3d %5d\n",
                    player.getJersey(),
                    player.getName(),
                    player.getFouls(),
                    player.getFieldGoals_1pt(),
                    player.getFieldGoals_2pt(),
                    player.getFieldGoals_3pt(),
                    player.getPoints());
        }

        System.out.println();
    }

    /**
     * Returns the team's name.
     * @return Team name.
     */
    @Override
    public String toString(){
        return name;
    }
}

