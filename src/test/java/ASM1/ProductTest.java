/**
 * @author <Dinh Le Hong Tin - s3932134>
 *     Sources: https://github.com/TriDang/cosc2440-2023-s1
 *     https://www.jetbrains.com/help/idea/class-diagram.html
 *
 */
package ASM1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void getType() {
        Product iphone = new PhysicalProduct("Iphone", "14 Pro", 5, 20, 1);
        assertEquals("physical", iphone.getType());

        Product NFT = new DigitalProduct("NFT-Magazine", "token", 3, 10);
        assertEquals("digital", NFT.getType());
    }

    @Test
    public void testToString() {
        Product prd1 = new PhysicalProduct("Bag", "Muji", 4, 5,0.5);
        String result = "PHYSICAL - Bag";
        assertEquals(result, prd1.toString());
        Product prd2 = new DigitalProduct("Ebook", "ABC", 8, 10);
        String results = "DIGITAL - Ebook";
        assertEquals(results, prd2.toString());
    }
}