package org.sanelib.ils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.OutputCapture;

import static org.junit.Assert.assertTrue;

public class CommonMainTest {

    private static final Logger LOG = LoggerFactory.getLogger(CommonMainTest.class);

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private String activeProfile;

	@Before
	public void init() {
		this.activeProfile = System.getProperty("spring.profiles.active");
		LOG.info("Profile init:" + this.activeProfile);
	}

	@After
	public void after() {
		if (this.activeProfile != null) {
			System.setProperty("spring.profiles.active", this.activeProfile);
		} else {
			System.clearProperty("spring.profiles.active");
		}
	}

	@Test
	public void testDefaultSettings() throws Exception {
		CommonMain.main(new String[0]);
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("name='Test'"));
	}

	@Test
	public void testExplicitVariable() throws Exception {
		CommonMain.main(new String[] {"--name=Gordon"});
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("name='Gordon'"));
	}

	@Test
	public void testDevProfile() throws Exception {
		System.setProperty("spring.profiles.active", "dev");
		CommonMain.main(new String[0]);
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("name='Development'"));
	}

	@Test
	public void testProfileCommand() throws Exception {
		CommonMain.main(new String[] {"--spring.profiles.active=dev"});
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("name='Development'"));
	}
}
