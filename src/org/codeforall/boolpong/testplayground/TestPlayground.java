package org.codeforall.boolpong.testplayground;
/*
    test your code snippets here
 */

import org.codeforall.boolpong.MyKeyboardHandler;
import org.codeforall.boolpong.Player;

public class TestPlayground {
    public static void main(String[] args) {

        Player p1 = new Player();
        MyKeyboardHandler keys = new MyKeyboardHandler(p1); //testing if key_space works (it does!)

    }
}
