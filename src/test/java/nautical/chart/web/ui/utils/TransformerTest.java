package nautical.chart.web.ui.utils;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Cheng Feng 2013-11-20 16:16:16
 */
public class TransformerTest {

	@Test
	public void testStringDate2Long() {
		assertEquals(1384872615000L, Transformer.stringDate2Long("20131119225015"));
	}
}
