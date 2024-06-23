
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TASK4 {
    static int score = 0;
    static int questionNum = 0;
    static String[][] quizData = {
            {"What is the capital of France?", "A. London", "B. Paris", "C. Rome", "B"},
            {"Which planet is known as the Red Planet?", "A. Mars", "B. Jupiter", "C. Venus", "A"},
            {"What is the powerhouse of the cell?", "A. Nucleus", "B. Mitochondria", "C. Ribosome", "B"}
    };

    public static void main(String[] args) {
        startQuiz();
    }

    public static void startQuiz() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Time's up! Moving to the next question.");
                displayNextQuestion();
            }
        };

        timer.schedule(task, 15000); // 15 seconds per question

        displayNextQuestion();
    }

    public static void displayNextQuestion() {
        if (questionNum < quizData.length) {
            String[] question = quizData[questionNum];
            System.out.println("Question " + (questionNum + 1) + ": " + question[0]);
            for (int i = 1; i < 4; i++) {
                System.out.println(question[i]);
            }

            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine().toUpperCase();
            checkAnswer(answer, question[4]);
        } else {
            endQuiz();
        }
    }

    public static void checkAnswer(String userAnswer, String correctAnswer) {
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }

        questionNum++;
        displayNextQuestion();
    }

    public static void endQuiz() {
        System.out.println("Quiz ended. Here is your result:");
        System.out.println("Score: " + score + "/" + quizData.length);

       
        for (int i = 0; i < quizData.length; i++) {
            String[] question = quizData[i];
            String status = question[4].equals("B") ? "Correct" : "Incorrect";
            System.out.println("Question " + (i + 1) + ": " + status);
        }
    }
}


