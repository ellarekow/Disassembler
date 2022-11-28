import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the disassmbler"); 

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a binary instruction");
        String instruction = input.nextLine();

        Instruction result = new Instruction(instruction);

        System.out.println(result.getCommand());
    }
}