package Pokemon;

import java.util.ArrayList;
import java.util.Random;

public abstract class Pokemon {
	protected final static int BASE_MAX_EXP = 10;
	protected static int pokedexCounter = 0;
	protected int pokedexNumber;
	protected String name;
	protected String type;
	protected double baseHp; // 1 - 1000
	protected double currHp;
	protected double def; // 1 - 100
	protected double att; // 1 - 100
	protected int level;
	protected int exp;
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
		this.level = this.exp = 1;
	}
	
// overload constructor Pokemon w/ specific level
	public Pokemon(String name, double hp, double def, double att, int level) {
		pokedexCounter++;
		this.pokedexNumber = pokedexCounter;
		this.name = name;
		this.baseHp = hp;
		this.currHp = hp;
		this.def = def;
		this.att = att;
		this.level = level;
		this.exp = 0;
		for(int i = 0; i < level; i++) {
			increaseAttribute();
		}
	}

	public void addMove(Move move) {
		this.moves.add(move);
	}

	// Level and Exp handler
	// tambah exp
	public void gainExp(int exp) {
		this.exp += exp;
		if (this.exp >= getNextLevelExp()) {
			levelUp();
		}
	}

	// buat dapetin max exp setiap tergantung level
	public int getNextLevelExp() {
		// level = 0, max_exp = 11
		// level = 1, max_exp = 18
		// level = 2, max_exp = 30
		// level = 3, max_exp = 44
		return (BASE_MAX_EXP + (level + 1)) * (level + 1) - (level * 3);
	}

	private void levelUp() {
		exp = exp - getNextLevelExp();
		level++;
		increaseAttribute();
	}

	private void increaseAttribute() {
		Random rand = new Random();
		baseHp += rand.nextInt(50) + 20;
		baseHp = baseHp > 1000 ? 1000 : baseHp;
		setCurrHp(getBaseHp());
		def += rand.nextInt(3) + 2;
		def = def > 100 ? 100 : def;
		att += rand.nextInt(3) + 2;
		att = att > 100 ? 100 : att;
	}

	// dapetin exp yang bakal didapetin kalo kalahin pokemon
	public int getPokemonWorth() {
		Random rand = new Random();
		return level + 2 + rand.nextInt((level + 2) * 2);
	}

	// Attack and Defence
	public void attack(Pokemon enemy, Move move) {

		double luck = Math.random();
		if (luck > move.getChance()) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.printf("%s Missed!\n", this.getName());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			return;
		}

		double totalDmg = move.getDmg() + (this.getAtt() * 0.3);
		enemy.defence(move, totalDmg);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.printf("%s attacked using %s!\n", this.getName(), move.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		enemy.defence(move, totalDmg);
		return;
	}

//	For enemy Pokemon
	public void randomAttack(Pokemon enemy) {
		int choice = (int) (Math.random() * 3);
		this.attack(enemy, this.getMoves().get(choice));
	}

	public void defence(Move move, double damage) {
		double totalDefence = this.def * 0.2;
		if (this.getWeakAgainst().equals(move.getType())) {
			System.out.println("Attack super effective!");
			totalDefence *= 2;
		}
		if (this.getStrongAgainst().equals(move.getType())) {
			System.out.println("Attack is not effective!");
			totalDefence /= 2;
		}
		damage -= totalDefence;
		if(damage <= 0) {
			damage = 0;
		}
		this.setCurrHp(this.getCurrHp() - damage);
		return;
	}

	// Setter Getter
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

	public abstract void setMoves();


	public void inspectPokemon() {
		System.out.printf("================[ %02d ]=================\n", pokedexNumber);
		System.out.printf("%-23s %-12s\n", String.format("Name: %s", name), String.format("Type: %s", type));
		System.out.printf("%-23s %-12s %-12s\n", String.format("HP: %.2f/%.2f", currHp, baseHp), String.format("ATT: %.2f", att), String.format("DEF: %.2f", def));
		System.out.printf("%-23s %-12s\n", String.format("Level: %d", level), String.format("EXP: %d/%d", exp, getNextLevelExp()));
		System.out.println("--------------  Move List  -----------");
		printMoves();
		System.out.println("========================================");

	}

	public void printMoves() {
		for (int i = 0; i < moves.size(); i++) {
			System.out.printf("Move[%d]", i + 1);
			moves.get(i).printMove();
		}
	}

	public int getLevel() {
		// TODO Auto-generated method stub
		return this.level;
	}

}
