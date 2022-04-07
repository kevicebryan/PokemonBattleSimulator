package Pokemon;

public class PokemonWater extends Pokemon {

	public PokemonWater(String name, double hp, double def, double att) {
		super(name, hp, def, att);
		// TODO Auto-generated constructor stub
		this.type = "water";
		this.weakAgainst = "grass";
		this.strongAgainst = "fire";
		
		this.moves.add(new Move("Splash", "water", 0.0, 1.0));
		this.moves.add(new Move("Punch", "normal", 10.0, 1.0));
		this.moves.add(new Move("Water Beam", "water", 20.0, 0.5));
		this.moves.add(new Move("Bubble", "water", 15.0, 0.7));
	}
	
	public PokemonWater(String name, double hp, double def, double att, int level) {
		super(name, hp, def, att, level);
		// TODO Auto-generated constructor stub
		this.type = "water";
		this.weakAgainst = "grass";
		this.strongAgainst = "fire";
		
		this.moves.add(new Move("Splash", "water", 0.0, 1.0));
		this.moves.add(new Move("Punch", "normal", 10.0, 1.0));
		this.moves.add(new Move("Water Beam", "water", 20.0, 0.5));
		this.moves.add(new Move("Bubble", "water", 15.0, 0.7));
	}
}
