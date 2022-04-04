package Pokemon;

public class Move {
	private static int tmCounter = 0;
	private int tmNumber;
	private String name;
	private String type;
	private double dmg;
	private double chance;
	
	
	
	public Move(String name, String type, double dmg, double chance) {
		tmCounter++;
		this.tmNumber = tmCounter;
		this.name = name;
		this.type = type;
		this.dmg = dmg;
		this.chance = chance;
	}
	
	public void printMove(){
		System.out.println("-----------");
		System.out.printf("%-12s | TM%-2d | <<%s>>\n", this.name, this.tmNumber, this.type);
		System.out.printf("DMG: %.2f\n", this.dmg);
		return;
	}
	
	
//	Setter Getter
	public int getTmNumber() {
		return tmNumber;
	}
	public void setTmNumber(int tmNumber) {
		this.tmNumber = tmNumber;
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
	public double getDmg() {
		return dmg;
	}
	public void setDmg(double dmg) {
		this.dmg = dmg;
	}
	public double getChance() {
		return chance;
	}
	public void setChance(double chance) {
		this.chance = chance;
	}
	
	
}
