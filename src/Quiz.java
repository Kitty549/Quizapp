import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        Participants p = new Participants ();
       try {   
        System.out.println("Enter your name:");
        p.name = s.nextLine();
        System.out.println("Age:");
        p.age = s.nextLine();
        System.out.println("Email:");
        p.email = s.nextLine();
        System.out.println("mobile number:");
        p.number= s.nextLine();
        System.out.println("Place:");
        p.place= s.nextLine();
        System.out.println("Hi " + p.name + ", are you ready to take the quiz? (yes/no)");
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
       String response = s.nextLine();
        if (!response.equalsIgnoreCase("yes")) {
            System.out.println("Thank you! See you next time.");
            }

        System.out.println("\nQuiz Rules:");
        System.out.println("1. Each question has 4 options.");
        System.out.println("2. You have 2 lifelines to use, but they can be used only once.");
        System.out.println("3. Each correct answer earns you points.");
        System.out.println("4. You can quit anytime or continue until you finish the quiz.");
        System.out.println("------------------------------------------------------");

        String[][] quiz = {
        		{"Which animal likes honey?","A) Lion","B) Elephant","C) Bear","D) Monkey","C"},
            {"What is the capital of France?", "A) Berlin", "B) Madrid", "C) Paris", "D) Rome", "C"},
            {"Which ancient civilization built the Great Pyramid of Giza?","A) Egyptians","B) Greeks","C)Romans","D) Mesopotamians", "A"},
            {"Who is the all-time leading scorer in the NBA?","A) Michael Jordan","B) Kareem Abdul-Jabbar","C) LeBron James","D) Stephen Curry","B"},
            {"What is the largest planet in our solar system?","A) Earth","B) Saturn","C) Jupiter","D) Uranus","C"},
            {"What is the chemical symbol for gold?","A) Ag","B) Au","C) Hg","D) Pb","B"},     
            {"Which river is the longest in South America?","A) Amazon River","B) Paraná River","C) São Francisco River","D) Magdalena River","A"},
            {"What is the world's largest desert?","A) Sahara Desert","B) Gobi Desert"," C) Mojave Desert","D) Atacama Desert","A"},
            {"Which river is the longest in the world?","A) Nile River","B) Amazon River","C) Yangtze River","D) Mississippi River","A"},
            {"Who is the main character in the book 'The Wizard of Oz'?","A) Alice","B) Dorothy","C) Wendy","D) Tinker Bell","B"}
        };

        String[] lifelines = {"50-50", "Ask the Audience"};
        for (int i = 0; i < quiz.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + quiz[i][0]);
            System.out.println(quiz[i][1]);
            System.out.println(quiz[i][2]);
            System.out.println(quiz[i][3]);
            System.out.println(quiz[i][4]);
            System.out.println("Enter your answer (or type 'lifeline' to use one):");
            String answer = s.nextLine();

            if (answer.equalsIgnoreCase("lifeline")) {
            
                if (p.lifelineUsed1 && p.lifelineUsed2) {
                    System.out.println("Sorry, you have already used all lifelines.");
                } else {
                    System.out.println("Available lifelines:");
                    if (!p.lifelineUsed1) System.out.println("1. " + lifelines[0]);
                    if (!p.lifelineUsed2) System.out.println("2. " + lifelines[1]);

                    System.out.println("Choose a lifeline:");
                    int choice = s.nextInt();
                    s.nextLine();
                
                   
					if (choice == 1 && !p.lifelineUsed1) {
                        p.lifelineUsed1 = true;
                        System.out.println("50-50 lifeline used! Two options remain: ");
                        System.out.println(quiz[i][2] + " and " + quiz[i][3]);
                    } else if (choice == 2 && !p.lifelineUsed2) {
                        p.lifelineUsed2 = true;
                        System.out.println("Audience suggests option " + quiz[i][5]);
                    } else {
                        System.out.println("Invalid or already used lifeline. Choose another.");
                        i--;
                        continue;
               
                    }
                }

                System.out.println("Enter your answer:");
                answer = s.nextLine();
            }

            if (answer.equals(quiz[i][5])) {
                System.out.println("Correct answer!");
                p.score += 10;
            } else {
                System.out.println("Wrong answer. The correct answer was option " + quiz[i][5]);
                System.out.println("You have won " + p.score + " points.");
                break;
            }
        }

        System.out.println("\nThank you for playing, " + p.name + "!");
       
        System.out.println("Your final score is: " + p.score + "!");
}

}
