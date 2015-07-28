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
				if (range.classify(existingRange).equals(Relation.SUBSET)) {
					System.out.println("Calling subset function");
					subsetRecord(tr,i);
				} else if (range.classify(existingRange).equals(
						Relation.SUPERSET)) {
					System.out.println("Calling superSet function");
					supersetRecord(tr, i);
				} else if (range.classify(existingRange).equals(
						Relation.LESSOVERLAP)) {
					System.out.println("Calling lessOverlap function");
					lessOverlappingRecord(tr,i);
				} else if (range.classify(existingRange).equals(
						Relation.MOREOVERLAP)) {
					System.out.println("Calling moreOverlap function");
					moreOverlappingRecord(tr,i);
				} else if (range.classify(existingRange).equals(
						Relation.LESSDISJOINT)) {
					System.out.println("Calling lessDisjointFunction function");
					lessDisjointRecord(tr,i);
				} else if (range.classify(existingRange)
						.equals(Relation.MOREDISJOINT)) {
					System.out.println("Calling moreDisjointFunction function");
					moreDisjointRecord(tr,i);
				} else if (existingRange.classify(range)
						.equals(Relation.SAME)) {
					System.out.println("Calling sameRecord function");
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
		table.add(new TrackingRecord(existingTR.trackingNumLow, existingTR.trackingNumHigh,existingTR.statusCode,existingTR.transferCode));
		table.add(tr);
		existingTR.trackingNumLow=tr.trackingNumHigh+1;
		existingTR.trackingNumHigh=high;
		table.add(existingTR);
	}
	public void supersetRecord(TrackingRecord tr, int i) {
		table.remove(i);
		table.add(tr);
	}

	public void lessOverlappingRecord(TrackingRecord tr, int i) {
		TrackingRecord existingTR = table.get(i);
		table.remove(i);
		existingTR.trackingNumLow=tr.trackingNumHigh+1;
		table.add(tr);
		table.add(existingTR);
	}
	public void moreOverlappingRecord(TrackingRecord tr,int i) {
		TrackingRecord existingTR = table.get(i);
		table.remove(i);
		existingTR.trackingNumHigh=tr.trackingNumLow-1;
		table.add(existingTR);
		table.add(tr);
	}
	public void lessDisjointRecord(TrackingRecord tr, int i) {
		TrackingRecord existingTR = table.get(i);
		if((tr.trackingNumHigh+1)==existingTR.trackingNumLow){
			if((existingTR.statusCode.equals(tr.statusCode))&&(existingTR.transferCode==tr.transferCode)){
				table.remove(i);
				tr.trackingNumHigh=existingTR.trackingNumHigh;
				table.add(tr);
			}
		}else{
		table.add(tr);
		}
	}
	public void moreDisjointRecord(TrackingRecord tr, int i) {
		TrackingRecord existingTR = table.get(i);
		if((existingTR.trackingNumHigh+1)==tr.trackingNumLow){
			if((existingTR.statusCode.equals(tr.statusCode))&&(existingTR.transferCode==tr.transferCode)){
				table.remove(i);
				tr.trackingNumLow=existingTR.trackingNumLow;
				table.add(tr);
			}
		}else{
		table.add(tr);
		}
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
		System.out.println("Enter Input");
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
