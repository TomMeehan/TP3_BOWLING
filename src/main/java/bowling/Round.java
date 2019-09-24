/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author pedago
 */
public class Round {
    
    private final int TURNS = 10;
    private State state;
    
    private int turn;
    private int bowl;
    private int pins;
    
    private int[] scores;
    
    public Round(int turn, int bowl, int pins){
        this.turn = turn;
        this.bowl = bowl;
        this.pins = pins;
        this.state = State.NORMAL;
        this.scores = new int[this.TURNS];
    }
    
    //T0DO
    public State updateState(int nbQ){
        this.pins += nbQ;
        if (this.bowl == 1 && this.pins == 10)
            this.state = State.SPARE;
        else if (this.bowl == 0 && nbQ == 10)
            this.state = State.STRIKE;
        else 
            this.state = State.NORMAL;
        return this.state;
    }
    
    public void nextTurn(){
        this.turn ++;
        this.pins = 0;
        nextBowl();
    }
    public void nextBowl(){
        this.bowl = 1 - this.bowl;
    }
    
     public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getBowl() {
        return bowl;
    }

    public void setBowl(int bowl) {
        this.bowl = bowl;
    }

    public int getPins() {
        return pins;
    }

    public void setPins(int pins) {
        this.pins = pins;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
