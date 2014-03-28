import java.util.Scanner;

public class BitwiseOperationsAndBaseConversions {

	public static void main(String args[]){
        int targetBase = 16;
		boolean correctlyAnswered = false;
		ConversionQuestion question;
		do{
			question = new ConversionQuestion( targetBase,10,  (int)(Math.random()*Math.pow(targetBase, 2)) );
			question.displayQuestion();
            do{
			   correctlyAnswered = question.isAnswerCorrect(readString());
            }
            while (!correctlyAnswered);
            correctlyAnswered = false;
		}
		while(true);

	}
	public static String readString() {
		Scanner in = new Scanner(System.in);
		return in.next();
	}

}
abstract class Question{
	abstract void displayQuestion();
	abstract boolean isAnswerCorrect(String answer);
}
class ConversionQuestion extends Question{
	Integer value;
	int initialBase;
	int targetBase;
    ConversionQuestion(int initialBase, int targetBase, int decimalValue){
        this.initialBase = initialBase;
        this.targetBase = targetBase;
        this.value = decimalValue;
    }
	void displayQuestion() {
		System.out.println("What is " + Integer.toString(this.value, this.initialBase) + "(b" + this.initialBase + ") in base " + this.targetBase +"?");
	}
    boolean isAnswerCorrect(String answer){
        String correctAnswer = Integer.toString(this.value, this.targetBase);
        return answer.equals(correctAnswer);
    }

}
