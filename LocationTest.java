

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste LocationTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class LocationTest
{
    /**
     * Construtor default para a classe de teste LocationTest
     */
    public LocationTest()
    {
    }

    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testIsLocationValid()
    {
        Location location1 = new Location(90, 180);
        assertEquals(true, location1.isLocationValid(location1));
        assertEquals(90, location1.getLatitude());
        assertEquals(180, location1.getLongitude());
    }
}





