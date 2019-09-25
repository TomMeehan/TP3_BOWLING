/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;


/**
 *
 * @author pedago
 */
public class Round {

    private int bowl1;
    private int bowl2;
    private int roundScore;
    private State state;
    
    public Round(){
        this.bowl1 = -1;
        this.bowl2 = -1;
        this.roundScore = -1;
        this.state = State.TBD;
    }
    
    public int getBowl1() {
        return bowl1;
    }

    public void setBowl1(int bowl1) {
        this.bowl1 = bowl1;
    }

    public int getBowl2() {
        return bowl2;
    }

    public void setBowl2(int bowl2) {
        this.bowl2 = bowl2;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public int getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }
    
    
}
