package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
    
        private int score;
        private Round round;
        

	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            this.score = 0;
            this.round = new Round(0,0,0);
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            
            int turnScore = nombreDeQuillesAbattues;
            
                  
            switch (this.round.getState()){
                case SPARE:
                    turnScore *= 2;
                    this.round.setState(State.NORMAL);
                    break;
                case STRIKE:
                    turnScore *=2;
                    if (this.round.getBowl() == 1)
                        this.round.setState(State.NORMAL);
                    break;

                default:
                    break;
            }
            
            this.round.updateState(nombreDeQuillesAbattues);
            
            this.score += turnScore;
            
            if (this.round.getBowl() == 0 && this.round.getState()!= State.STRIKE)
                this.round.nextBowl();
            else
                this.round.nextTurn();
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
		return this.score;
	}
}