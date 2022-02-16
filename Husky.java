// Yifan Dai
// 03/11/2020
//TA: Kendra Specht
//Assignment #8
//This program will running the simulator with just 30 Huskies in the world.
import java.awt.*;

public class Husky extends Critter {
	
	////Husky constrcutor, set initial value of each field
	public Husky() {
		
	}
	//infect if an enemy is in front or left; Otherwise trun right if same species
	//or wall is in front; Otherwise hop if possible.
	public Action getMove(CritterInfo info) {
		if(info.getFront() == Neighbor.OTHER ||
		info.getLeft() == Neighbor.OTHER) {
			return Action.INFECT;
		}else if(info.getFront() == Neighbor.WALL ||
		info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		}else {//otherwise hop if possible
			return Action.HOP;
		}
	}
	//Set color to Magenta
	public Color getColor() {
		return Color.MAGENTA;
	}
	//Huskies display as "UW"
	public String toString() {
		return "UW";
	}
}