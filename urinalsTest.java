import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class urinalsTest {
    urinals ur=new urinals();

    @Test
    void testgoodString() {
        System.out.println("====== Rishitha Malempati == TEST TWO EXECUTED =======");
        assertEquals(false,ur.goodString("1100"));
    }
}
