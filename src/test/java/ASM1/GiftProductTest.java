/**
 * @author <Dinh Le Hong Tin - s3932134>
 *     Sources: https://github.com/TriDang/cosc2440-2023-s1
 *     https://www.jetbrains.com/help/idea/class-diagram.html
 *
 */
package ASM1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GiftProductTest {
    @Test
    public void canSetMessageForProduct() {
        //Testing set message for digital product
        Product prd1 = new DigitalProduct("E-Book", "Alice in Wonderland", 2, 5);
        assertEquals("", prd1.getMessage());
        prd1.setMessage("This is a gift for you");
        assertEquals("This is a gift for you", prd1.getMessage());

        //Testing set message for physical product
        Product prd2 = new PhysicalProduct("Book", "Good to Great", 2, 5, 0.5);
        assertEquals("", prd2.getMessage());
        prd2.setMessage("This is my present for you");
        assertEquals("This is my present for you", prd2.getMessage());
    }
}