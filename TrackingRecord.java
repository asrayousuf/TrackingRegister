package trackingRegister;

import java.io.IOException;
import java.util.Scanner;

public class TrackingRecord {
	int trackingNumLow;
	int trackingNumHigh;
	String statusCode;
	int transferCode;
	boolean delete;
	public TrackingRecord(int low, int high, String status, int transferCd, boolean deleteStatus){
		int trackingNumLow=low;
		int trackingNumHigh=high;
		String statusCode=status;
		int transferCode=transferCd;
		boolean delete=deleteStatus;
	}
	public TrackingRecord(){
		int trackingNumLow=0;
		int trackingNumHigh=0;
		String statusCode= "";
		int transferCode=0;
		boolean delete=false;
	}
	
	public static void main(String args[]) throws IOException{
		String input;
		Scanner scanner = new Scanner(System.in);
		TrackingRecord trackingRecord = new TrackingRecord();
		input = scanner.next();
		String record[];
		TrackingTable tt=new TrackingTable();
		while (!input.equals("0")) {
			input = scanner.next();
			record=input.split(" ");
			TrackingRecord tr=new TrackingRecord(Integer.parseInt(record[0]),Integer.parseInt(record[1]),record[2],Integer.parseInt(record[3]),false);
			tt.updateTable(tr);
		}	
	}

}
