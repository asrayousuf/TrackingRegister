package trackingRegister;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrackingTableTest {

	@Test
	public void testUpdateTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubsetRecord() {
		TrackingRecord tr=new TrackingRecord(1,100,"A",9);
		TrackingTable tt= new TrackingTable();
		tt.updateTable(tr);
		TrackingRecord tr1=new TrackingRecord(50,70,"B",10);
	}
	@Test
	public void testSupersetRecord() {
		fail("Not yet implemented");
	}
	

	/*@Test
	public void testLessOverlappingRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoreOverlappingRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testLessDisjointRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoreDisjointRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testMergeRecords() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testSameRecord() {
		fail("Not yet implemented");
	}

}
