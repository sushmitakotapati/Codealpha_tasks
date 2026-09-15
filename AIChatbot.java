import java.util.Scanner;

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String question;

        System.out.println("AI CHATBOT");
        System.out.println("Hello! I am your chatbot.");
        System.out.println("Ask me simple questions.");
        System.out.println("Type bye to exit.");

        while (true) {

            System.out.print("\nYou: ");
            question = sc.nextLine();

            question = question.toLowerCase();

            if (question.equals("hello") || question.equals("hi")) {

                System.out.println("Bot: Hello! How can I help you?");

            }

            else if (question.contains("name")) {

                System.out.println("Bot: I am an AI Chatbot.");

            }

            else if (question.contains("how are you")) {

                System.out.println("Bot: I am fine. Thank you!");

            }

            else if (question.contains("what are you doing")) {

                System.out.println("Bot: I am here to answer your questions.");

            }

            else if (question.contains("help")) {

                System.out.println("Bot: You can ask me simple questions.");

            }

            else if (question.contains("java")) {

                System.out.println("Bot: Java is a popular programming language.");

            }

            else if (question.contains("ai") || question.contains("artificial intelligence")) {

                System.out.println("Bot: AI means Artificial Intelligence.");

            }

            else if (question.contains("thank")) {

                System.out.println("Bot: You are welcome!");

            }

            else if (question.equals("bye")) {

                System.out.println("Bot: Goodbye! Have a nice day.");
                break;

            }

            else {

                System.out.println("Bot: Sorry, I do not understand your question.");

            }
        }

        sc.close();
    }
}