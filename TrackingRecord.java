package trackingRegister;

import java.io.IOException;
import java.util.Scanner;

public class TrackingRecord {
	int trackingNumLow;
	int trackingNumHigh;
	String statusCode;
	int transferCode;
	boolean delete;
	
	public TrackingRecord(int low, int high, String status, int transferCd){
		this.trackingNumLow=low;
		this.trackingNumHigh=high;
		this.statusCode=status;
		this.transferCode=transferCd;
		this.delete=false;
	}
	public TrackingRecord(){
		this.trackingNumLow=0;
		this.trackingNumHigh=0;
		this.statusCode= "";
		this.transferCode=0;
		this.delete=false;
	}
	
	public String getRecord(){
		return this.trackingNumLow+" "+this.trackingNumHigh+" "+this.statusCode+" "+this.transferCode;
	}

}
