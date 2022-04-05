package Pokemon;
import java.util.ArrayList;

public class Pokemon {
	protected static int pokedexCounter = 0;
	protected int pokedexNumber;
	protected String name;
	protected String type;
	protected double baseHp;  // 1 - 1000
	protected double currHp;
	protected double def; // 1 - 100
	protected double att; // 1 - 100
	protected String weakAgainst;
	protected String strongAgainst;
	protected ArrayList<Move> moves = new ArrayList<Move>();
	
	public Pokemon(String name, double hp, double def, double att) {
		pokedexCounter++;
		this.pokedexNumber = pokedexCounter;
		this.name = name;
		this.baseHp = hp;
		this.currHp = hp;
		this.def = def;
		this.att = att;
	}
	
	public void addMove(Move move){
		this.moves.add(move);
	}
	
	
//	Attack and Defence
	public void attack(Pokemon enemy, Move move) {
		
		double luck = Math.random();
		if(luck > move.getChance()) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.printf("%s Missed!\n", this.getName());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			return;
		}
		
		double totalDmg = move.getDmg() + (this.getAtt()*0.3);
		enemy.defence(move, totalDmg);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.printf("%s attacked using %s!\n", this.getName(), move.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		enemy.defence(move, totalDmg);
		return;
	}
	
	public void randomAttack(Pokemon enemy) {
		int choice = (int) (Math.random()*3);
		this.attack(enemy, this.getMoves().get(choice));
	}
	
	public void defence(Move move, double damage) {
		double totalDefence = this.def * 0.2;
		if(this.getStrongAgainst().equals(move.getType())) {
			System.out.println("Attack super effective!");
			totalDefence *= 2;
		}
		if(this.getWeakAgainst().equals(move.getType())) {
			System.out.println("Attack is not effective!");
			totalDefence /= 2;
		}
		damage -= totalDefence;
		this.setCurrHp(this.getCurrHp()- damage);
		return;
	}
	
	
//	Setter Getter

	public static int getPokedexCounter() {
		return pokedexCounter;
	}

	public static void setPokedexCounter(int pokedexCounter) {
		Pokemon.pokedexCounter = pokedexCounter;
	}

	public int getPokedexNumber() {
		return pokedexNumber;
	}

	public void setPokedexNumber(int pokedexNumber) {
		this.pokedexNumber = pokedexNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBaseHp() {
		return baseHp;
	}

	public void setBaseHp(double hp) {
		this.baseHp = hp;
	}

	public double getCurrHp() {
		return currHp;
	}

	public void setCurrHp(double currHp) {
		this.currHp = currHp;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}

	public double getAtt() {
		return att;
	}

	public void setAtt(double att) {
		this.att = att;
	}

	public String getWeakAgainst() {
		return weakAgainst;
	}

	public void setWeakAgainst(String weakAgainst) {
		this.weakAgainst = weakAgainst;
	}

	public String getStrongAgainst() {
		return strongAgainst;
	}

	public void setStrongAgainst(String strongAgainst) {
		this.strongAgainst = strongAgainst;
	}

	public ArrayList<Move> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<Move> moves) {
		this.moves = moves;
	}

	public void inspectPokemon() {
		System.out.println("=======================================");
		System.out.printf("[%d] Name: %s   ", this.pokedexNumber, this.name);
		System.out.printf("Type: %s\n", this.type);
		System.out.printf("HP: %.2f/%.2f   ", this.currHp, this.baseHp);
		System.out.printf("ATT: %.2f   ", this.getAtt());
		System.out.printf("DEF: %.2f\n", this.def);
		System.out.println("--------------  Move List  -----------");
		this.printMoves();
		System.out.println("======================================");
		
	}
	public void printMoves() {
		for(int i = 0; i < moves.size(); i++) {
			System.out.printf("Move[%d]", i+1);
			moves.get(i).printMove();
		}
	}
	
	
	
}
