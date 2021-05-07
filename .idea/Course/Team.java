package Course;

public class Team {
    private String name[];
    private int distance[];
    private String[] result = new String[4];


    public Team(String[] name, int[] distance) {
        this.name = name;
        this.distance = distance;
    }

    public String[] getName() {
        return name;
    }

    public int[] getDistance() {
        return distance;
    }

    public void setResult(String[] result) {
        this.result = result;
    }
    public void showResult(){
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public void info(){
        for (int i = 0; i < name.length; i++) {
            System.out.printf("Имя: %s возможности: %s m.%n", name[i], distance[i]);

        }
    }
}