package com.maul.tugas10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommandLine {
	private List<Antenna> amountAntenna;
	private Set<Antenna> coverageArea;

	CommandLine() {
		amountAntenna = new ArrayList<Antenna>();
		coverageArea = new HashSet<Antenna>();
	}

	public void start() throws IOException,NumberFormatException {
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many antenna you want? ");
		String amount = bufferReader.readLine();
		for (int i = 0; i < Integer.parseInt(amount); i++) {
			System.out.println("Antenna " + (i + 1));
			String position = bufferReader.readLine();
			String[] positions = position.split(",");
			this.amountAntenna.add(new Antenna(Integer.parseInt(positions[0]), Integer.parseInt(positions[1])));
		}
		cekArea();
		for (Antenna antenna : this.coverageArea) {
			System.out.println(antenna.toString() + " : " + cekInfoAntenna(antenna));
		}

	}

	private String cekInfoAntenna(Antenna antenna) {
		String output = "";
		for (int i = 0; i < this.amountAntenna.size(); i++) {
				for (Antenna antenna2 : amountAntenna.get(i).getAreas()) {
					if(antenna2.equals(antenna)) {
						output=output+" Antenna"+(i+1);
					}
				}
		}
		return output;
	}

	private void cekArea() {
		List<Antenna> temp=new ArrayList<Antenna>();
		for (int i = 0; i < amountAntenna.size(); i++) {
			if ((i + 1) == amountAntenna.size()) {
				temp=amountAntenna.get(i).getAreas();
				temp.retainAll(amountAntenna.get(0).getAreas());
				this.coverageArea.addAll(temp);
			} else {
				temp=amountAntenna.get(i).getAreas();
				temp.retainAll(amountAntenna.get(i+1).getAreas());
				this.coverageArea.addAll(temp);
			}
		}
	}


}
