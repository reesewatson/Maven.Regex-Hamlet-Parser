import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void replaceTest(){
        // Given
        String data = "You can't do it. It's electric! Boogey-oogey-oogey!";
        String original = "can't";
        String replacement = "can";
        String expected = "You can do it. It's electric! Boogey-oogey-oogey!";

        // When
        String actual = hamletParser.replace(original, replacement, data);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void ChangeHamletToLeon() {
        // Given
        Assert.assertTrue(hamletParser.findHamlet(hamletText));

        // When
        hamletParser.changeHamletToLeon();

        // Then
        Assert.assertFalse(hamletParser.findHamlet(hamletParser.getHamletData()));
    }

    @Test
    public void ChangeHoratioToTariq() {
        // Given
        Assert.assertTrue(hamletParser.findHoratio(hamletText));

        // When
        hamletParser.changeHoratioToTariq();

        // Then
        Assert.assertFalse(hamletParser.findHoratio(hamletParser.getHamletData()));

    }

    @Test
    public void FindHoratio() {
        // When
        boolean actualTrue = hamletParser.findHoratio(hamletParser.getHamletData());

        // Then
        Assert.assertTrue(actualTrue);

        // When
        hamletParser.changeHoratioToTariq();
        boolean actualFalse = hamletParser.findHoratio(hamletParser.getHamletData());

        // Then
        Assert.assertFalse(actualFalse);
    }

    @Test
    public void FindHamlet() {
        // When
        boolean actualTrue = hamletParser.findHamlet(hamletParser.getHamletData());

        // Then
        Assert.assertTrue(actualTrue);

        // When
        hamletParser.changeHamletToLeon();
        boolean actualFalse = hamletParser.findHamlet(hamletParser.getHamletData());

        // Then
        Assert.assertFalse(actualFalse);
    }
}