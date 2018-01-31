import junit.framework.Assert;
import org.home.mazi.csroulette.model.RouletteResult;
import org.junit.Test;

public class RouletteResultTest {

    @Test
    public void testDataName() {
        RouletteResult item = new RouletteResult("test","","");

        Assert.assertEquals("test", item.getName());
    }

    @Test
    public void testDataDescription() {
        RouletteResult item = new RouletteResult("","testDescription","");

        Assert.assertEquals("testDescription", item.getDescription());
    }

    @Test
    public void testDataImagePath() {
        RouletteResult item = new RouletteResult("","","testPath");

        Assert.assertEquals("testPath", item.getImagePath());
    }

    @Test
    public void testDataImage() {
        RouletteResult item = new RouletteResult("","","");

        Assert.assertNotNull(item.getImage());
    }
}
