package trackingRegister;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import trackingRegister.Range.Relation;

public class TrackingTable {

	ArrayList<TrackingRecord> table = new ArrayList<TrackingRecord>();
	Range range = new Range();

	public void updateTable(TrackingRecord tr) {
		if (table.size() == 0) {
			table.add(tr);
		} else {
			range.hi = tr.trackingNumHigh;
			range.lo = tr.trackingNumLow;
			for (int i = table.size()-1; i >= 0; i--) {
				Range existingRange = new Range();
				existingRange.hi = table.get(i).trackingNumHigh;
				existingRange.lo = table.get(i).trackingNumLow;
				if (existingRange.classify(range).equals(Relation.SUBSET)) {
					subsetRecord(tr,i);
				} else if (existingRange.classify(range).equals(
						Relation.SUPERSET)) {
					supersetRecord(tr, i);
				} else if (existingRange.classify(range).equals(
						Relation.LESSOVERLAP)) {
					lessOverlappingRecord(tr);
				} else if (existingRange.classify(range).equals(
						Relation.MOREOVERLAP)) {
					moreOverlappingRecord(tr);
				} else if (existingRange.classify(range).equals(
						Relation.LESSDISJOINT)) {
					lessDisjointRecord(tr);
				} else if (existingRange.classify(range)
						.equals(Relation.MOREDISJOINT)) {
					moreDisjointRecord(tr);
				} else if (existingRange.classify(range)
						.equals(Relation.SAME)) {
					sameRecord(tr,i);
				}

			}

		}
	}

	public void subsetRecord(TrackingRecord tr, int i) {
		TrackingRecord existingTR = table.get(i);
		table.remove(i);
		int high=existingTR.trackingNumHigh;
		existingTR.trackingNumHigh=tr.trackingNumLow-1;
		table.add(existingTR);
		table.add(tr);
		existingTR.trackingNumLow=tr.trackingNumHigh+1;
		existingTR.trackingNumHigh=high;
		table.add(existingTR);
	}
	public void supersetRecord(TrackingRecord tr, int i) {
		table.remove(i);
		table.add(tr);
	}

	public void lessOverlappingRecord(TrackingRecord tr) {

	}
	public void moreOverlappingRecord(TrackingRecord tr) {

	}
	public void lessDisjointRecord(TrackingRecord tr) {

	}
	public void moreDisjointRecord(TrackingRecord tr) {

	}
	public void mergeRecords(TrackingRecord tr1, TrackingRecord tr2) {

	}
	public void sameRecord(TrackingRecord tr, int i) {
		table.remove(i);
		table.add(tr);
	}
	public void display(){
		System.out.print("Tracking Table\n"+"-----------------\n");
		for(int i=0;i < table.size(); i++)
		{
			System.out.println(table.get(i).getRecord());
		}
	}
	
	public static void main(String args[]) throws IOException{
		String input;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Input\n");
		input = scanner.nextLine();
		String record[];
		TrackingTable trackingMatrix=new TrackingTable();
		while (!input.equals("0")) {
			record=input.split(" ");
			TrackingRecord tr=new TrackingRecord(Integer.parseInt(record[0]),Integer.parseInt(record[1]),record[2],Integer.parseInt(record[3]));
			trackingMatrix.updateTable(tr);
			input = scanner.nextLine();
		}	
		trackingMatrix.display();
	}

}
