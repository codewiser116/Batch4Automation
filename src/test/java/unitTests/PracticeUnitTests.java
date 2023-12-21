package unitTests;

import org.junit.*;

public class PracticeUnitTests {

   /*
   if score >= 90, return 5
   if score < 90 and score >= 70, return 4
   if score < 70 and score >= 50, return 3
   else
   return 0

   PLEASE WRITE 10 UNIT TESTS FOR THIS METHOD
    */

    public int gradeStudent(int score){
        if (score >= 90){
            return 5;
        }else if (score < 90 && score >= 70){
            return 4;
        } else if (score < 70 && score >= 50) {
            return  3;
        }else{
            return 0;
        }
    }

    @Test @Ignore
    public void test1(){
        System.out.println("test 1");
        Assert.assertEquals(5, gradeStudent(101));
    }

    @Test
    public void test2(){
        System.out.println("test 2");
        Assert.assertEquals(5, gradeStudent(90));
    }

    @Before
    public void beforeTest(){
        System.out.println("this is before test");
    }

    @After
    public void afterTest(){
        System.out.println("after test method");
    }

    @BeforeClass
    public static void beforeClassMEthod(){
        System.out.println("THIS IS BEFORE CLASS");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println( "THIS IS AFTER CLASS");


    }




}
