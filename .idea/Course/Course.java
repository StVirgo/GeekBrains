package Course;

import java.util.Random;

public class Course {
    private int[] arrayCourse = new int[6];



    public void dolt(Team team){
        int[] distance = team.getDistance();
        String[] name = team.getName();
        String[] result = new String[name.length];
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < arrayCourse.length; j++) {
                if (arrayCourse[j] < distance[i]) {
                    distance[i] = distance[i] - arrayCourse[j];
                } else {
                    result[i] = name[i] + " не смог пройти препятствие " + (j + 1);
                    distance[i] = -1;
                    break;
                }
                if (j == (arrayCourse.length - 1)){
                    result[i] = name[i] + " смог пройти всю полосу препятствий!";
                }
            }

        }
        team.setResult(result);
    }

    public void fillArray() {
        Random random = new Random();
        for (int i = 0; i < arrayCourse.length; i++) {
            arrayCourse[i] = random.nextInt(10);

        }
    }
}