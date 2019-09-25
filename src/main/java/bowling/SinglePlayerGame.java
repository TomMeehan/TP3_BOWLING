package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
    
        private final int TURNS = 10;
        private final int EXTRA_TURNS = 1;
        
        private int score;
        private Round[] rounds;
        private int currentTurn;
        private int currentBowl;

	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            this.score = 0;
            this.rounds = new Round[TURNS + EXTRA_TURNS];
            this.currentTurn = 0;
            this.currentBowl = 0;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            Round currentRound;
            
            if(this.currentBowl == 0){ 
                currentRound = new Round();
                
                currentRound.setBowl1(nombreDeQuillesAbattues);
                
                if (nombreDeQuillesAbattues == 10 && currentTurn < this.TURNS){
                    
                    currentRound.setState(State.STRIKE);
                    currentRound.setFinished(true);
                }
                else 
                    this.currentBowl ++;
                
                currentRound.setRoundScore(currentRound.getBowl1());

            }
            else{
                currentRound = this.rounds[this.currentTurn];
                currentRound.setBowl2(nombreDeQuillesAbattues);
                
                if (nombreDeQuillesAbattues + currentRound.getBowl1() == 10)
                    currentRound.setState(State.SPARE);
                else
                    currentRound.setState(State.NORMAL);
                
                currentRound.setRoundScore(currentRound.getRoundScore() + currentRound.getBowl2());
                
                currentRound.setFinished(true);
                
            }
            if (currentTurn == this.TURNS) currentRound.setState(State.EXTRA);
            
            
            
            this.rounds[this.currentTurn] = currentRound;
            
            if(currentRound.isFinished() && currentTurn < this.TURNS){
                currentTurn ++;
                this.currentBowl = 0;
            }
                   
            
            
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            
            int tempScore = 0;
            
            for( int i = 0; i < this.TURNS; i++){
                
                Round currRound = this.rounds[i];
                tempScore += currRound.getRoundScore();
                
                if (currRound.getState() == State.SPARE)
                    tempScore += this.rounds[i+1].getBowl1();
                else if (currRound.getState() == State.STRIKE){
                    tempScore += this.rounds[i+1].getRoundScore();
                    if (this.rounds[i+1].getState() == State.STRIKE){   
                        tempScore += this.rounds[i+2].getBowl1();
                    }
                }
            }
            
            return tempScore;
	}
}