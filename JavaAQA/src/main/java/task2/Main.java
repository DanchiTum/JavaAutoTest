package task2;
//Instructions:
//Declare two String variables.
//Use the equals method to compare the two Strings.
//Use the compareTo method to compare the two Strings.
//Print the results of both comparisons to the console.
public class Main {
    public static void main(String[] args) {
        String a = "Java";
        String b = "Java";
        if (a.equals(b)) {
            System.out.println("a і b однакові");
        } else {
            System.out.println("a і b різні");
        }
        int result = a.compareTo(b);
        System.out.println(result);
        // просто уточню я розумію, що при методі compareTo він повертає 0, якщо рядки однакові, від’ємне число, якщо перший рядок менший,
        // і повертає додатнє число, якщо перший рядок більший, в завданні було написано просто вивести результат,
        // тому я вивів без тексту другий результат
    }
}