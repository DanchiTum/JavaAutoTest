package task8;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Task8Test {
    task8 task = new task8();
    @DataProvider(name = "equals")
    public Object[][] equalsData() {
        return new Object[][] {
                {"Java", "Java", true},
                {"Java", "java", false},
                {"Absolutely", "not same", false}
        };
    }
    @Test(dataProvider = "equals")
    public void testEquals(String a, String b, boolean expected) {
        Assert.assertEquals(task.areStringsEqual(a, b), expected);
    }
    @DataProvider(name = "compare")
    public Object[][] compareData() {
        return new Object[][] {
                {"Kyiv", "Lviv", -1},
                {"City", "City", 0},
                {"Lviv", "Kyiv", 1}
        };
    }
    @Test(dataProvider = "compare")
    public void testCompareTo(String a, String b, int expectedSign) {
        int result = task.compareStrings(a, b);
        Assert.assertEquals(Integer.signum(result), Integer.signum(expectedSign));
    }
    @Test
    @Parameters({"paramA", "paramB", "expected"})
    public void testWithParameters(String a, String b, String expected) {
        Assert.assertEquals(task.compareAndDescribe(a, b), expected);
    }
}
