package Course;

public class Main {

    public static void main(String[] args) {
        Team team = new Team(new String[]{"Oleg", "Maksim", "Viktor", "Dmitriy"}, new int[]{5, 26, 47, 56});
        Course c = new Course();
        team.info();
        c.fillArray();
        c.dolt(team);
        team.showResult();
        team.info();

    }
}