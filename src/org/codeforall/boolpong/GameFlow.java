package org.codeforall.boolpong;


import org.academiadecodigo.simplegraphics.delete.Player;

public class GameFlow {

    private Player player1, player2;
    private NormalCups[] redCups;
    private NormalCups[] blueCups;
    private boolean isPlayer1Turn; //Track turn

    public GameFlow(){
        initializeGame();
    }

    private void initializeGame(){
        player1 = new Player();

        redCups = new NormalCups[5];
        blueCups = new NormalCups[5];

        isPlayer1Turn = true;
    }

    private void switchTurn(){
        isPlayer1Turn = !isPlayer1Turn;
    }


}
