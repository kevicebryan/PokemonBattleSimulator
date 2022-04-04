import java.util.ArrayList;
import java.util.Scanner;

import Pokemon.*;

/*
Aggota Kelompok:
	Kevin Bryan 	2440038490
	Oliver Chico	
	Wendy Oei		
	Ryanto 			
*/

public class Game {
	
	static ArrayList<Pokemon> starterPokemons =  new ArrayList<Pokemon>();
	static ArrayList<Pokemon> enemyPokemons = new ArrayList<Pokemon>();
	
	static Trainer trainer;
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initGame();
		welcomeTrainer();
		trainerMenu();
	}
	
	
//	Trainer Menu
	public static void trainerMenu() {
		int choice;
		do {
			System.out.println("Pokemon Battle Simulator");
			System.out.println("===================================");
			System.out.printf("1. Inspect %s\n", trainer.getPokemon().getName());
			System.out.println("2. Battle!");
			System.out.println("3, Heal Pokemon");
			System.out.println("4. Exit");
			System.out.println("===================================");
			System.out.print(">> ");
			choice = sc.nextInt();
			
			if(choice ==1) {
				trainer.getPokemon().inspectPokemon();
			}
			if(choice ==2) {
				battleMenu();
			}
			if(choice ==3) {
				trainer.healPokemon(trainer.getPokemon());
			}
			if(choice ==4) {
				System.out.printf("Thanks for battling with us %s!\n", trainer.getName());
			}
			
		}while(choice != 4);
	}
	
	
	private static void battleMenu() {
		// TODO Auto-generated method stub
		printPokemonList(enemyPokemons);
		int choice = inputValidChoice(enemyPokemons) - 1;
		trainer.battlePokemon(enemyPokemons.get(choice));
	}


	public static void initGame() {
//		Trainer's available Pokemon
		PokemonFire charmander = new PokemonFire("Charmander", 250, 40, 60);
		PokemonWater squirtle = new PokemonWater("Squirtle", 300, 50, 30);
		PokemonGrass bulbasaur = new PokemonGrass("Bulbasaur", 280, 60, 40);
		
		starterPokemons.add(charmander); starterPokemons.add(squirtle); starterPokemons.add(bulbasaur);
		
//		Enemy Pokemon
		PokemonFire charizard = new PokemonFire("Charizard", 300, 40, 20);
		PokemonWater greninja = new PokemonWater("Greninja", 325, 50, 20);
		PokemonGrass oddish = new PokemonGrass("Oddish", 150, 60, 20);
		
		enemyPokemons.add(charizard);enemyPokemons.add(greninja);enemyPokemons.add(oddish);
	}
	
	public static void welcomeTrainer() {
		System.out.print("Hello fellow Pokemon Trainer, what's you name?\n>> ");
		String name = sc.nextLine();
//		System.out.println(name);
		System.out.printf("%s is it?\nOkay, which Pokemon do you want?\n", name);
		printPokemonList(starterPokemons);
		int choice = inputValidChoice(starterPokemons) - 1;
		trainer = new Trainer(name, starterPokemons.get(choice));
		System.out.printf("Wow you chose %s, thats a good choice.\n", trainer.getPokemon().getName());
		System.out.println("Take care of it for me okay, see ya!");
//		Clear screen here
	}
	
	private static int inputValidChoice(ArrayList<Pokemon> pokemons) {
		int choice = -1;
		do {
			System.out.print(">> ");
			choice = sc.nextInt();
		}while(!validChoice(choice, pokemons));
		return choice;
	}

	private static boolean validChoice(int choice, ArrayList<Pokemon> pokemons) {
		// TODO Auto-generated method stub
		if(choice >= 1 && choice <= pokemons.size())return true;
		return false;
	}

	private static void printPokemonList(ArrayList<Pokemon> pokemons) {
		// TODO Auto-generated method stub
		System.out.println("=================================");
		for(int i = 0; i < pokemons.size(); i++) {
			Pokemon currPokemon = pokemons.get(i);
			System.out.printf("%d | %-10s | %-10s\n", i+1, currPokemon.getName(), currPokemon.getType());
		}
		System.out.println("=================================");
	}

}