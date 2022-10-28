import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class urinalsTest {
    urinals ur=new urinals();

    @Test
    void testgoodString() {
        System.out.println("====== Rishitha Malempati == TEST ONE EXECUTED =======");
        assertEquals(false,ur.goodString("1100"));
    }

    @Test
    void testcountUrinals() {
        System.out.println("====== Rishitha Malempati == TEST ONE EXECUTED =======");
        assertEquals(1,ur.countUrinals("100"));
    }
}
