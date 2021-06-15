package com.maul.tugas10;

import java.util.ArrayList;
import java.util.List;

public class Antenna {
	private int positionX;
	private int positionY;
	
	public Antenna(int positionX, int positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public Antenna() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + positionX;
		result = prime * result + positionY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Antenna other = (Antenna) obj;
		if (positionX != other.positionX)
			return false;
		if (positionY != other.positionY)
			return false;
		return true;
	}
	
	public List<Antenna> getAreas() {
		List<Antenna> areas=new ArrayList<Antenna>();
		for (int i = this.positionX-1; i <=this.positionX+1; i++) {
			for (int j = this.positionY-1; j <= positionY+1; j++) {
				areas.add(new Antenna(i, j));
			}
		}
		return areas;
	}
	
	@Override
	public String toString() {
		return "(" + positionX + "," + positionY + ")";
	}

	
}
