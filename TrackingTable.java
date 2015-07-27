package trackingRegister;

import java.util.ArrayList;

public class TrackingTable {
	ArrayList<TrackingRecord> table = new ArrayList<TrackingRecord>();
	public void updateTable(TrackingRecord tr){
		if(table.size()==0){
			table.add(tr);
		}
		
	}
	public void splitRecord(TrackingRecord tr){
		
	}
	public void overlappingRecord(TrackingRecord tr){
		
	}
	public void mergeRecords(TrackingRecord tr1,TrackingRecord tr2){
		
	}
	
}
