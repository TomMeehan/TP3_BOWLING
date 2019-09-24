/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedago
 */
public class OwnTests {
    
    private SinglePlayerGame game;
  
    @Before
    public void setUp() {
        game = new SinglePlayerGame();
    }
    

    @After
    public void tearDown() {
    }

    @Test
    public void testOneStrike()  {
            rollStrike(); // 10 + 7
            assertEquals(10,game.score());
            game.lancer(3);
            assertEquals(16,game.score());
            game.lancer(4);
            rollMany(16, 0);
            assertEquals(24, game.score());
    }
    
    // Quelques methodes utilitaires pour faciliter l'écriture des tests
    private void rollMany(int n, int pins) {
            for (int i = 0; i < n; i++) {
                    game.lancer(pins);
            }
    }

    private void rollSpare() {
            game.lancer(7);
            game.lancer(3);
    }

    private void rollStrike() {
            game.lancer(10);
    }
}
