// Yifan Dai
// 03/11/2020
//TA: Kendra Specht
//Assignment #8
//This program will running the simulator with just 30 bears in the world that
//about half of them being white and about half being black and Initially they
//should all be displayed with slash characters.
import java.awt.*;

public class Bear extends Critter {
	private boolean polar;
	private int step;
	//bear constrcutor, set initial value of each field
	//parameter used:
	//polar = determine whether is white polar bear or not
	public Bear(boolean polar) {
		step = 0;
		this.polar = polar;
	}
	//Infect if an enemy is in front; Otherwise hop if possible; Otherwise turn left
	//parameter used:
	// info = provides you information about the current status of the critter.
	public Action getMove(CritterInfo info) {
		step++;
		if(info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}else{//otherwise trun left if possible
			return Action.LEFT;
		}
	}
	//Define colors of whethering black or white bear
	//if is white polar, then return color white; if not, return color black.
	public Color getColor() {
		if(this.polar) {
			return Color.WHITE;
		}else {//!this.polar
			return Color.BLACK;
		}
	}
	//Alternate on each move between a forward slash ("/") and a backslash ("\") starting with a forward slash ("/").
	public String toString() {
		if(step % 2 == 0) {
			return "/";
		}else {//step % 2 != 0
			return "\\";
		}
	}
}