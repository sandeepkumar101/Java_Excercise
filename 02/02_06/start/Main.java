public class Main {

    public static void main(String[] args) {

        int stage = 2;
        String season;
        switch(stage) {
            case 0:
                season = "Spring";
                break;
            case 1:
                season = "Summer";
                break;
            case 2:
                season = "Fall";
                break;
            case 3:
                season = "Winter";
                break;
            default:
                season = "Invalid stage";
        }

        System.out.println(season);
    }
}
