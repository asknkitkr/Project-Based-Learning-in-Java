package project2;

import java.util.Scanner;
import java.util.ArrayList;

class Video {
	public String title = "";
	private boolean checkedOut = false;
	private ArrayList<Double> rating = new ArrayList<Double>();
	private double avgRating = 0;
	
	public Video(String title) {
		this.title = title;
	}
	
	public String checkOut() {
		if(!this.checkedOut) {
			this.checkedOut = true;
			return (this.title + " checked out successfully.");
		} else {
			return (this.title + " already checked out!");
		}
	}
	
	public String retVid() {
		if(this.checkedOut) {
			this.checkedOut = false;
			return (this.title + " returned successfully.");
		} else {
			return (this.title + " already returned!");
		}
	}
	
	public String recRating(double star) {
		rating.add(star);
		double avg = 0;
		for(double rate:rating) {
			avg = avg + rate;
		}
		this.avgRating = avg / rating.size();
		return ("You have rated " + star + " for " + title + " video. The average rating is " + this.avgRating + "/10");
	}
	
	public boolean getCheckedOut() {
		return this.checkedOut;
	}
	
	public double getRating() {
		return this.avgRating;
	}
}

class VideoStore {
	public Video videos[] = new Video[10];
	private int count = 0;
	int i;
	
	public void addVideo(String title) {
		if(this.count < 10) {
			videos[this.count] = new Video(title);
			this.count++;
			System.out.println("Video titled " + title + " added successfully to the inventory!");
		} else {
			System.out.println("Adding video to inventory failed. Inventory full!");
		}
	}
	
	public void checkOut(String title) {
		for(i=0; i<this.count; i++) {
			if(videos[i].title.equals(title)) {
				System.out.println(videos[i].checkOut());
				break;
			} 
		}
		if(i == this.count)
			System.out.println("Uh Oh! " + title + " not found in the inventory!");

	}
	
	public void returnVideo(String title) {
		for(i=0; i<this.count; i++) {
			if(videos[i].title.equals(title)) {
				System.out.println(videos[i].retVid());
				break;
			}
		}
		if(i == this.count)
			System.out.println("Uh Oh! " + title + " not found in the inventory!");
	}
	
	public void receiveRating(String title, double star) {
		if(star > 10 || star < 0) {
			System.out.println("Rating out of limits");
		}
		for(i=0; i<this.count; i++) {
			if(videos[i].title.equals(title)) {
				System.out.println(videos[i].recRating(star));
				break;
			}
		}
		if(i == this.count)
			System.out.println("Uh Oh! " + title + " not found in the inventory!");
	}
	
	public void listInventory() {
		System.out.println("S.No.\tTitle\tChecked Out\tReturned\tRating\n");
		for(int i=0; i<this.count; i++) {
			System.out.println(i+1 + ".\t" + videos[i].title + "\t\t" + (videos[i].getCheckedOut() ? "Yes\t" : "No\t") + (videos[i].getCheckedOut() ? "No\t\t" : "Yes\t\t") + videos[i].getRating());
		}
	}
	
}

public class VideoLauncher {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		VideoStore store = new VideoStore();
		boolean proceed = true;
		String title;
		
		while(proceed) {
			int opt;
			System.out.println("\n*****************");
			System.out.println("1. Add a video\n2. Check out a video\n3. Return a video\n4. Receive rating\n5. List Inventory\n6. Exit");
			System.out.println("Select an option: ");
			
			
			opt = s.nextInt();
			
				switch(opt) {
					case 1: 
						System.out.println("Enter video title to a new video: ");
						title = s.next();
						store.addVideo(title);
						break;
					
					case 2: 
						System.out.println("\nEnter video title to check out video: ");
						title = s.next();
						store.checkOut(title);
						break;
					
					case 3: 
						System.out.println("\nEnter video title to return video: ");
						title = s.next();
						store.returnVideo(title);
						break;
					
					case 4: 
						System.out.println("\nEnter video title to receive rating: ");
						title = s.next();
						System.out.println("\nGive rating out of 10: ");
						double rating = s.nextDouble();
						store.receiveRating(title, rating);
						break;
					
					case 5: 
						store.listInventory();
						break;
					
					case 6: 
						proceed = false;
						break;
					
					default: 
						System.out.println("Enter a valid option!");
					
				}
				
		}
		s.close();
	}

}