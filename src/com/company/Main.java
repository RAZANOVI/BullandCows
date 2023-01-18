package com.company;

public class Main {
    public static void main(String[] args) throws Exception {
        GameRules rules = new SimpleGameRules(4);
        RandomPlayer p1 = new RandomPlayer("RandomPlayer");
        RandomPlayer p2 = new RandomPlayer("Player_A");
        Communcator c = new Communcator(p1, p2,rules);
        p1.initialize(rules);
        p2.initialize(rules);
        Communcator.GameStatus result = Communcator.GameStatus.GAME_CONTINUE;
        while(result== Communcator.GameStatus.GAME_CONTINUE) {
            result = c.GameCycle(rules);
        }
        System.out.println("Game result is: " + result);
    }
}
    //написать метод и от
