package Pokemon;

public class PokemonFire extends Pokemon {

	public PokemonFire(String name, double hp, double def, double att) {
		super(name, hp, def, att);
		this.type = "fire";
		this.weakAgainst = "water";
		this.strongAgainst = "fire";
		
		setMoves();
	}
	
	public PokemonFire(String name, double hp, double def, double att, int level) {
		super(name, hp, def, att, level);
		this.type = "fire";
		this.weakAgainst = "water";
		this.strongAgainst = "fire";
		
		setMoves();
	}

	@Override
	public void setMoves() {
		this.moves.add(new Move("Ember", "fire", 15.0, 0.95));
		this.moves.add(new Move("Scratch", "normal", 5.0, 1.0));
		this.moves.add(new Move("Taunt", "normal", 0.0, 1.0));
		this.moves.add(new Move("Flamethrower", "fire", 35.0, 0.7));
	}
}
