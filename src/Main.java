
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Number of Teams: ");
        int teamNums = input.nextInt();


        List<String>teams = new ArrayList<>();
        System.out.println("Name of Teams: ");
        for(int i=1;i<=teamNums;i++){

            String teamNames= input.next();
            teams.add(teamNames);
        }
        if(teamNums%2 != 0){
            teams.add("Bay");
            teamNums +=1;
        }
        //Collections.shuffle(teams);
        System.out.println(teams);
        System.out.println(teams.size());

        List<String> tempTeams = new ArrayList<>();

        while (0 < teams.size()) {
            int index = (int)(Math.random()*teams.size());
            tempTeams.add(teams.get(index));
            teams.remove(teams.get(index));
        }

        teams = tempTeams;

        int totalRound = teamNums - 1;
        int numMatchPerRound = teamNums / 2;

        LinkedHashMap<String, ArrayList<ArrayList<String>>> rounds = new LinkedHashMap<>();

        for (int i=0; i<totalRound; i++) {
            String round = String.valueOf(i + 1);
            rounds.put(round, new ArrayList<ArrayList<String>>());
        }

        for (int i=0; i<totalRound; i++) {
            ArrayList<String> home = new ArrayList<>();
            ArrayList<String> away = new ArrayList<>();

            for (int j=0; j<numMatchPerRound; j++) {
                home.add(teams.get(j));
                away.add(teams.get((teamNums - 1) - j));
            }

            String round = String.valueOf(i + 1);
            rounds.get(round).add(home);
            rounds.get(round).add(away);

            List<String> newTeams = new ArrayList<>();

            newTeams.add(teams.get(0));
            newTeams.add(teams.get((teamNums - 1)));

            for (int k=1; k<teams.size() - 1; k++) {
                newTeams.add(teams.get(k));
            }

            teams = newTeams;
        }

        System.out.println();

        for (int i=0; i<2*totalRound; i++) {
            System.out.println((i + 1) + ". Week");
            for (int j=0; j<numMatchPerRound; j++) {
                if (i < totalRound) {
                    System.out.println(rounds.get(String.valueOf(i + 1)).get(0).get(j) + " vs " +  rounds.get(String.valueOf(i + 1)).get(1).get(j));
                } else {
                    System.out.println(rounds.get(String.valueOf(i + 1 - totalRound)).get(1).get(j) + " vs " +  rounds.get(String.valueOf(i + 1 - totalRound)).get(0).get(j));
                }
            }
            System.out.println();
        }
    }

}
