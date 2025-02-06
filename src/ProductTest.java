import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Product("123456", "hotdog", "food", 65);
        p2 = new Product("123457", "pizza", "food", 43.3);
        p3 = new Product("123458", "basketball", "ball", 14);
        p4 = new Product("123459", "skateboard", "radical", 100);
        p5 = new Product("123460", "fries", "food", 14);
        p6 = new Product("123461", "boombox", "MUSIC", 100.99);
    }

    @Test
    void setName() {
        p1.setName("Bilbo");
        assertEquals("Bilbo", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("hotdog");
        assertEquals("hotdog", p1.getDescription());
    }

    @Test
    void setID() {
        p1.setID("123445");
        assertEquals("123445", p1.getID());
    }

    @Test
    void setCost() {
        p1.setCost(14);
        assertEquals(14, p1.getCost());
    }

    @Test
    void testToString() {
        String expected = "Product{ID='123456', name='hotdog', description='food', cost='65.0'}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void toCSV() {
        String expected = "Product{ID='123456', name='hotdog', description='food', cost='65.0'}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void toJSONRecord() {
        String expected = "{\"IDNum\":\"123456\",\"name\":\"hotdog\", \"description\":\"food\", \"cost\":\"65.0\",";
        assertEquals(expected, p1.toJSONRecord());
    }

    @Test
    void toXMLRecord() {
        String expected = "<Product><IDNum>123456</IDNum><name>hotdog</name><description>food</description><cost>65.0</cost></Product>";
        assertEquals(expected, p1.toXMLRecord());
    }
}