import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class Team {
    private String teamName;
    private int wins;
    private int losses;
    private int tie;
    Team(final String name,
         final int won, final int loss, final int draw) {
        teamName = name;
        wins = won;
        losses = loss;
        tie = draw;
    }
    public String getName() {
        return teamName;
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    public int getDraw() {
        return tie;
    }
}
class LeaderBoard {
    private ArrayList<Team> list;
    LeaderBoard() {
        list = new ArrayList<Team>();
    }
    public int compareTo(
        final Team teamOne, final Team teamTwo) {
        if (teamOne.getWins() < teamTwo.getWins()) {
            return  -1;
        } else if (teamOne.getWins() > teamTwo.getWins()) {
            return 1;
        } else {
            if (teamOne.getLosses() < teamTwo.getLosses()) {
                return 1;
            } else if (teamOne.getLosses() > teamTwo.getLosses()) {
                return -1;
            } else {
                if (teamOne.getDraw() < teamTwo.getDraw()) {
                    return -1;
                } else if (teamOne.getDraw() > teamTwo.getDraw()) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public void addTo(final Team obj) {
        list.add(obj);
    }
    public void sorting() {
        int max = 0;
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            max = i;
            for (int j = i + 1; j < list.size(); j++) {
                flag = compareTo(list.get(max), list.get(j));
                if (flag == -1) {
                    max = j;
                }
            }
            Collections.swap(list, i, max);
        }
    }
    public String print() {
        String str = "";
        for (int i = 0; i < list.size() - 1; i++) {
            str += list.get(i).getName() + ",";
        }
        str += list.get(list.size() - 1).getName();
        return str;
    }
}
final class Solution {
    private Solution() {
    }
    public static void main(final String[] args) {
        Team obj;
        final int three = 3;
        LeaderBoard object = new LeaderBoard();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            obj = new Team(tokens[0],
                           Integer.parseInt(tokens[1]),
                           Integer.parseInt(tokens[2]),
                           Integer.parseInt(tokens[three]));
            object.addTo(obj);
        }
        object.sorting();
        System.out.println(object.print());
    }
}