package nautical.chart.web.ui.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * Issue类的单元测试
 * 
 * @author Cheng Feng 2013-11-20 16:20:20
 */
public class IssueTest {

	@Test
	public void testString2Status() {
		List<State> result = Issue.string2Status("20131119225015-TODO:20131120154110-DOING");

		assertEquals(2, result.size());
		State s0 = result.get(0);
		assertEquals(State.TODO.name(), s0.name());
//		assertEquals(1384872615000L, s0.getTime());
		State s1 = result.get(1);
		assertEquals(State.DOING.name(), s1.name());
//		assertEquals(1384933270000L, s1.getTime());
	}
}
