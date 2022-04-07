package Pokemon;

public class PokemonGrass extends Pokemon {

	public PokemonGrass(String name, double hp, double def, double att) {
		super(name, hp, def, att);
		this.type = "grass";
		this.weakAgainst = "fire";
		this.strongAgainst = "water";
		
		this.moves.add(new Move("Leaf Blade", "grass", 25.0, 0.75));
		this.moves.add(new Move("Scratch", "normal", 5.0, 1.0));
		this.moves.add(new Move("Taunt", "normal", 0.0, 1.0));
		this.moves.add(new Move("Solar Beam", "grass", 125.0, 0.33));
	}
	
	public PokemonGrass(String name, double hp, double def, double att, int level) {
		super(name, hp, def, att, level);
		this.type = "grass";
		this.weakAgainst = "fire";
		this.strongAgainst = "water";
		
		this.moves.add(new Move("Leaf Blade", "grass", 25.0, 0.75));
		this.moves.add(new Move("Scratch", "normal", 5.0, 1.0));
		this.moves.add(new Move("Taunt", "normal", 0.0, 1.0));
		this.moves.add(new Move("Solar Beam", "grass", 125.0, 0.33));
	}
}
