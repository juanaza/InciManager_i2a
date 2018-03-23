package manager_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import manager.incidents.Incident;
import manager.incidents.IncidentDTO;

public class IncidentDTOTests {

	private IncidentDTO i1;
	private IncidentDTO i2;

	@Before
	public void setUp() {
		i1 = new IncidentDTO("i1", "System failure", "failure,proof", 20.2, 17.2, "");
		i2 = new IncidentDTO("i2", "Overheated system", "failure,heat,temperature", 20.2, 17.2, "heat.jpg");
	}

	@Test
	public void testNameAndDescr() {
		assertEquals(i1.getName(), "i1");
		assertEquals(i2.getName(), "i2");
		assertEquals(i1.getDescription(), "System failure");
		assertEquals(i2.getDescription(), "Overheated system");
		i1.setName("i4");
		assertEquals(i1.getName(), "i4");
		i2.setDescription("Sample");
		assertEquals(i2.getDescription(), "Sample");
	}

	@Test
	public void testLocation() {
		assertTrue(i1.getLat() == 20.2);
		assertTrue(i2.getLon() == 17.2);
		i1.setLat(0.5);
		i1.setLon(9.2);
		assertTrue(i1.getLat() == 0.5);
		assertTrue(i1.getLon() == 9.2);
	}

	@Test
	public void testIncident() {
		Incident inci = i2.getIncident();
		List<String> tags = new ArrayList<String>();
		tags.add("failure");
		tags.add("heat");
		tags.add("temperature");
		assertEquals(inci.getTags(), tags);
		assertEquals(inci.getName(), "i2");
		assertTrue(inci.getLocation().getLng() == 17.2);
	}

	@Test
	public void testTagsAndMultimedia() {
		assertEquals(i1.getTags(), "failure,proof");
		i2.setTags("fail");
		assertEquals(i2.getTags(), "fail");
		assertEquals(i2.getMultimedia(), "heat.jpg");
		i2.setMultimedia("");
		assertEquals(i2.getMultimedia(), "");
		System.out.println(i1.toString());
	}

	@Test
	public void testToString() {
		String result = "IncidentDTO [name=i1, description=System failure, tags=failure,proof, lat=20.2, lon=17.2, multimedia=]";
		assertEquals(i1.toString(), result);
	}

}