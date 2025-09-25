package task8;
//Task8:
//1: Create 3 simple unit tests for Task_2 (modify your code to have 3 different methods in Task_2 solving if needed).
//2. Create testng.xml which should execute your test class. Execute this file
//3. Add a Data provider for each test.
//4. Create a test with parameters loaded from testng.xml.

//In fact, we are not modifying the code, but rewriting it completely
public class task8 {
    public boolean areStringsEqual(String a, String b) {
        return a.equals(b);
    }
    public int compareStrings(String a, String b) {
        return a.compareTo(b);
    }
    public String compareAndDescribe(String a, String b) {
        if (a.equals(b)) {                         //Ok, this little part is same, but that's all
            return "a і b однакові";               //and yes this method is veeeery similar to the first one,
        } else {                                   //but it returns normal text and in first one returns True/False,
            return "a і b різні";                  //sooo technically they are different
        }
    }
}