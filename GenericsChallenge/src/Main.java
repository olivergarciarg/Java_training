public class Main {
    public static void main(String[] args) {
        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago cubs");

        footballLeague.add(adelaideCrows);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);
        footballLeague.add(melbourne);

        hawthorn.matchResults(fremantle, 1, 0);
        hawthorn.matchResults(adelaideCrows, 3, 8);
        adelaideCrows.matchResults(fremantle,2,1);

        footballLeague.showLeagueTable();

    }
}