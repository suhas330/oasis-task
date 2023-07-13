import java.util.Scanner;

class User {
    private String username;
    private String password;
    // Other user details like name, email, etc.

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctOption;

    // Constructor
    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Getters

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Exam {
    private Question[] questions;
    private int totalMarks;
    private int marksObtained;

    // Constructor
    public Exam(Question[] questions, int totalMarks) {
        this.questions = questions;
        this.totalMarks = totalMarks;
        this.marksObtained = 0;
    }

    // Methods

    public void takeExam() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Enter your answer (1-" + options.length + "): ");
            int userChoice = scanner.nextInt();

            if (userChoice == question.getCorrectOption()) {
                marksObtained++;
            }
        }

        System.out.println("Exam completed!");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Obtained Marks: " + marksObtained);
    }
}

class Main {
    public static void main(String[] args) {
        // Sample data for testing

        // Questions
        Question question1 = new Question("What is the capital of France?", 
            new String[]{"London", "Paris", "Berlin", "Madrid"}, 2);

        Question question2 = new Question("Which planet is known as the Red Planet?", 
            new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 2);

        Question question3 = new Question("Who painted the Mona Lisa?", 
            new String[]{"Pablo Picasso", "Vincent van Gogh", "Leonardo da Vinci", "Claude Monet"}, 3);

        // Exam
        Question[] questions = {question1, question2, question3};
        Exam exam = new Exam(questions, 3); // Total marks: 3

        // User login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);

        // Perform exam if login is successful
        if (isValidUser(user)) {
            exam.takeExam();
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    private static boolean isValidUser(User user) {
        // Implement user authentication logic here
        // Compare the user credentials with the stored user data in the database or file system
        // Return true if valid, false otherwise
        // You can use a list of predefined valid users or fetch user data from a database

        // Sample logic (for testing only)
        return user.getUsername().equals("suhas") && user.getPassword().equals("123");
    }
}
