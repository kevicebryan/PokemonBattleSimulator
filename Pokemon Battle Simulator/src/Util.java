import java.io.IOException;

public class Util {
  public static void clearConsole() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (InterruptedException | IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void tryCls() {
	  final String ESC = "\033[";
	  System.out.print(ESC + "2J"); 
  }
  
}
