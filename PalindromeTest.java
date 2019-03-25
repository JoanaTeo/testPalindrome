import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;


class PalindromeTest {
    public Palindrome p;
    @BeforeEach
    public void setup()
    {
        p=new Palindrome();
    }
    @Test
    public void testTrue() throws EmptyStringException {

        Assertions.assertEquals(true,p.palindrome("pop"));
    }
    @Test
    public void testFalse() throws EmptyStringException {

        Assertions.assertEquals(false,p.palindrome("palindrome"));
    }
    @Test
    public void testSingleLetter() throws EmptyStringException {
        Assertions.assertEquals(true,p.palindrome("p"));
    }
    @Test
    public void testSpace() throws EmptyStringException {
        Assertions.assertEquals(true,p.palindrome(" "));
    }
    @Test
    public void punctuationTest() throws EmptyStringException {
        Assertions.assertFalse(p.palindrome("hiwj!"));
    }

    public static Collection<Object[]> numbers() {
        return Arrays.asList(new Object[][] {
                { "1", true },
                { "123", false }
        });
    }

       @ParameterizedTest
    @MethodSource("numbers")
    public void testP(String s,Boolean b) throws EmptyStringException {
        Assertions.assertEquals(p.palindrome(s),b);
       }
    @Test
    public void shouldThrowAnException(){
        Assertions.assertThrows(EmptyStringException.class, () ->
            p.palindrome(""));
    }

}
