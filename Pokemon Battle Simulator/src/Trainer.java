import java.util.Scanner;

import Pokemon.*;

public class Trainer {
	private String name;
	private Pokemon pokemon;
	private static Scanner sc = new Scanner(System.in);
	// Gender boleh juga sih :__)

	public void healPokemon(Pokemon pokemon) {
		System.out.println("++++++++++++++++++++++++++");
		System.out.printf("%s healed to full HP\n", pokemon.getName());
		System.out.println("++++++++++++++++++++++++++");
		pokemon.setCurrHp(pokemon.getBaseHp());
	}

	public void battlePokemon(Pokemon enemy) {
		System.out.printf("Battling against %s!\n", enemy.getName());

		do {
			if(enemy.getCurrHp() <= 0){
				enemy.setCurrHp(0);	
			}
			if(this.getPokemon().getCurrHp() <= 0){
				this.getPokemon().setCurrHp(0);
			}
			System.out.println("======================================");
			System.out.printf("Your %12s %.2f/%.2f\n", this.pokemon.getName(), this.pokemon.getCurrHp(),
					this.pokemon.getBaseHp());
			System.out.printf("Enemy %12s %.2f/%.2f\n", enemy.getName(), enemy.getCurrHp(), enemy.getBaseHp());
			System.out.println("======================================");
			Move move = this.chooseAttack();
			Util.clearConsole();
			this.pokemon.attack(enemy, move);
			System.out.print("Press enter to continue..");
			sc.nextLine();

			if(!(this.getPokemon().getCurrHp() > 0 && enemy.getCurrHp() > 0))
				break;
			
			Util.clearConsole();
			System.out.println("Enemy's turn!");
			enemy.randomAttack(this.pokemon);
			System.out.print("Press enter to continue..");
			sc.nextLine();
			
			
		} while (this.getPokemon().getCurrHp() > 0 && enemy.getCurrHp() > 0);

		Util.clearConsole();

		if (enemy.getCurrHp() <= 0) {
			System.out.println(enemy.getName() + " fainted...\n"
					+ "You Win!");
			pokemon.gainExp(enemy.getPokemonWorth());
		} else {
			System.out.println(this.pokemon.getName() + " fainted...\n"
					+ "You Lose...");
			this.pokemon.setCurrHp(0);
		}
		System.out.print("Press enter to continue..");
		sc.nextLine();
		// Reset enemy HP back to full for next battle!
		enemy.setCurrHp(enemy.getBaseHp());
		return;
	}

	private Move chooseAttack() {
		Move move;
		this.pokemon.printMoves();
		System.out.println("Choose a move");
		int choice = -1;
		do {
			System.out.print(">> ");
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
			}
		} while (!(choice >= 1 && choice <= 4));
		choice--;
		move = this.pokemon.getMoves().get(choice);
		return move;
	}

	// Constructor
	public Trainer(String name, Pokemon pokemon) {
		this.name = name;
		this.pokemon = pokemon;
	}

	// SetterGetter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
}
