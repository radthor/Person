import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Person("Andrew", "Joslin", "100034", "Mr", 1985);
        p2 = new Person("Jacob", "Schmidt", "100035", "Mr", 1924);
        p3 = new Person("Frank", "Dodd", "100036", "Mr", 1956);
        p4 = new Person("Tina", "Elbow", "100037", "Mrs", 1986);
        p5 = new Person("Angela", "Mark", "100038", "Mrs", 2014);
        p6 = new Person("Helga", "Duffell", "100039", "Ms", 1996);

    }
    @org.junit.jupiter.api.Test
    void setFirstName() {
        p1.setFirstName("Bilbo");
        assertEquals("Bilbo", p1.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setLastName() {
        p1.setLastName("Jelly");
        assertEquals("Jelly", p1.getLastName());
    }

    @org.junit.jupiter.api.Test
    void setTitle() {
        p1.setTitle("Mz");
        assertEquals("Mz", p1.getTitle());
    }

    @org.junit.jupiter.api.Test
    void setYOB() {
        p1.setYOB(1944);
        assertEquals(1944, p1.getYOB());
    }

    @org.junit.jupiter.api.Test
    void fullName() {
        assertEquals("Andrew Joslin", p1.fullName());
    }

    @org.junit.jupiter.api.Test
    void formalName() {
        assertEquals("Mr" + " " + "Andrew" + " " + "Joslin", p1.formalName());
    }


    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals("40", p1.getAge());

    }

    @org.junit.jupiter.api.Test
    void testGetAge() {
        assertEquals("40", p1.getAge());
    }

    @org.junit.jupiter.api.Test
    void testToString() {

        String expected = "Person{" +
                "ID='100034'" +
                ", firstName='Andrew'" +
                ", lastName='Joslin'" +
                ", YOB=1985" +
                ", title='Mr'" +
                '}';
        assertEquals(expected, p1.toString());
    }

    @org.junit.jupiter.api.Test
    void toCSV() {
        String expected = "Person{" +
                "ID='100034'" +
                ", firstName='Andrew'" +
                ", lastName='Joslin'" +
                ", YOB=1985" +
                ", title='Mr'" +
                '}';
        assertEquals(expected, p1.toString());
    }

    @org.junit.jupiter.api.Test
    void toJSONRecord() {
        char DQ = '\u0022';
        String expected = "{" + DQ + "IDNum" + DQ + ":" + DQ + "100034" + DQ + "," +
                DQ + "firstName" + DQ + ":" + DQ + "Andrew" + DQ + "," +
                " " + DQ + "lastName" + DQ + ":" + DQ + "Joslin" + DQ + "," +
                " " + DQ + "title" + DQ + ":" + DQ + "Mr" + DQ + "," +
                " " + DQ + "YOB" + DQ + ":" + "1985" + "}";

        assertEquals(expected, p1.toJSONRecord());
    }

    @org.junit.jupiter.api.Test
    void toXMLRecord() {
        String expected = "<Person><IDNum>100034</IDNum>" +
                "<firstName>Andrew</firstName>" +
                "<lastName>Joslin</lastName>" +
                "<title>Mr</title>" +
                "<YOB>1985</YOB></Person>";

        assertEquals(expected, p1.toXMLRecord());
    }
}