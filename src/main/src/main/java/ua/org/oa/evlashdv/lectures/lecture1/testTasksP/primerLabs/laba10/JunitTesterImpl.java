package ua.org.oa.evlashdv.lectures.lecture1.testTasksP.primerLabs.laba10;


import interfaces.junit.JunitTester;
import junit.framework.TestSuite;
import ua.org.oa.evlashdv.lectures.lecture1.testTasksP.primerLabs.test.ArrayCollectionImplTest;

public class JunitTesterImpl implements JunitTester {

	@Override
	public TestSuite suite() {
		TestSuite suite = new TestSuite(ArrayCollectionImplTest.class);
		return suite;
	}

}
