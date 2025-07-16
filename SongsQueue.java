package core;
import java.util.*;

public class SongsQueue {
	private class Node{
		String song;
		Node next;
		
		Node(String song){
			this.song = song;
		}
	}
	
	Node head;
	Node tail;
	int c;
	
	public SongsQueue() {
		c = 0;
		head = null;
		tail = null;
	}
	
	void addToQueue(String song) {
		Node n = new Node(song);
		if(head == null) {
			head = n;
			tail = n;
		}
		else {
			tail.next = n;
			tail = n;
		}
		
		if(c != 0) System.out.println("Added !, The song will be played after " + c + " songs");
		c++;
		
	}
	
	String playSong() {
		String song = head.song;
		head = head.next;
		c--;
		
		System.out.println("Currently playing : " + song);
		return song;
	}
	
	int noOfSongs() {
		System.out.println("No of songs in queue are : " + c);
		return c;
	}
	
	public static void main(String args[]) {
		SongsQueue sq = new SongsQueue();
		
		sq.addToQueue("A");
		sq.addToQueue("B");
		
		sq.playSong();
		
		sq.addToQueue("C");
		
		sq.noOfSongs();
	}
}
