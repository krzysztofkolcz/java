package regexExamples;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for RegexSpf.
 */
public class RegexSpfTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RegexSpfTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( RegexSpfTest.class );
    }

    public void testSpfNoIfirma() {
        String spf = "v=spf1 mx a ip4:91.15.1.1 a:mail.google.pl ~all";
        boolean conf = RegexSpf.spfConfiguredForIfirma(spf);
        assertFalse( conf );
    }

    public void testSpfHasIfirma() {
        String spf = "v=spf1 mx a ip4:91.15.1.1 a:mail.google.pl include:spf.ifirma.pl ~all";
        boolean conf = RegexSpf.spfConfiguredForIfirma(spf);
        assertTrue( conf );
    }

    public void testEditSpf1() {
        String existingSpf = "v=spf1 mx a ip4:91.15.1.1 a:mail.google.pl ~all";
        String expectedSpf = "v=spf1 include:spf.ifirma.pl  mx a ip4:91.15.1.1 a:mail.google.pl ~all";
        String resultSpf = RegexSpf.editExistingSpf(existingSpf);
        /* System.out.println("resultSpf"); */
        /* System.out.println(resultSpf); */
        assertEquals(expectedSpf, resultSpf);
    }

    public void testEditSpf2() {
        String existingSpf = "v=spf1 mx a ptr ip4:127.0.0.1 a:127.0.0.2 include:spf.gmail.com ?all";
        String expectedSpf = "v=spf1 include:spf.ifirma.pl  mx a ptr ip4:127.0.0.1 a:127.0.0.2 include:spf.gmail.com ?all";
        String resultSpf = RegexSpf.editExistingSpf(existingSpf);
        assertEquals(expectedSpf, resultSpf);
    }

    public void testEditSpf3() {
        String existingSpf = "v=spf1 a ptr a:127.0.0.2 include:spf.gmail.com ?all";
        String expectedSpf = "v=spf1 include:spf.ifirma.pl  a ptr a:127.0.0.2 include:spf.gmail.com ?all";
        String resultSpf = RegexSpf.editExistingSpf(existingSpf);
        assertEquals(expectedSpf, resultSpf);
    }
}

