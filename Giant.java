// Yifan Dai
// 03/11/2020
//TA: Kendra Specht
//Assignment #8
//This program will running the simulator with just 30 giants in the world. They would switch
//displays as "fee", "fie", "foe", "fum" after every 6 moves
import java.awt.*;

public class Giant extends Critter {
	private int step;
	//Giant constrcutor, set initial value of each field
	public Giant() {
		step = 0;
	}
	//Infect if an enemy is in front; Otherwise hop if possible; Otherwise turn right.
	public Action getMove(CritterInfo info) {
		step++;
		if(info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}else {
			return Action.RIGHT;
		}
	}
	//set the color of gaints as gray
	public Color getColor() {
		return Color.GRAY;
	}
	//display "fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
	public String toString() {
		if((step / 6) % 4 == 0) {
			return "fee";
		}else if ((step / 6) % 4 == 1) {
			return "fie";
		}else if ((step / 6) % 4 == 2) {
			return "foe";
		}else {//(step / 6) % 4  == 3
			return "fum";
		}
	}
}