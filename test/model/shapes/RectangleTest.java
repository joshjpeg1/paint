package model.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by josh_jpeg on 10/14/17.
 */
public class RectangleTest {
  @Test
  public void testEqualsWorks() {
    Rectangle r = new Rectangle(5, 8, 12, 31);
    assertEquals(r, new Rectangle(5, 8, 12, 31));
  }

  @Test
  public void testEqualsDifferent() {
    Rectangle r = new Rectangle(5, 8, 12, 31);
    assertNotEquals(r, new Rectangle(4, 7, 11, 30));
  }
}
