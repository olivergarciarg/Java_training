import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        FootballPlayer joe =  new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);
        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago cubs");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> soccerTeam = new Team<>("manchester united");
        soccerTeam.addPlayer(beckham);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResults(fremantle, 1, 0);
        hawthorn.matchResults(adelaideCrows, 3, 8);

        adelaideCrows.matchResults(fremantle,2,1);
//        adelaideCrows.matchResults(baseballTeam,1,1);

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(adelaideCrows.compareTo(fremantle));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(hawthorn.compareTo(hawthorn));

        ArrayList<Team> teams = new ArrayList<>();
        teams.add(adelaideCrows);
        teams.add(hawthorn);
        Collections.sort(teams);
    }
}