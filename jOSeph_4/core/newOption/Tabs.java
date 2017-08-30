package jOSeph_4.core.newOption;

import jOSeph_4.Version;

import java.util.ArrayList;

public class Tabs {
	private ArrayList<Tab> list = new ArrayList<Tab>();

	ArrayList<Tab> generateTabs(){
		createTab(new Version(new int[]{4, 1, 2, 7}, "Alpha"),
				"Added Achievements selection in the Core"
		);
		createTab(new Version(new int[]{4, 1, 2, 6}, "Alpha"),
				"Added Settings to the Core"
		);
		createTab(new Version(new int[]{4, 1, 2, 5}, "Alpha"),
				"Added 'New' feature in the Core"
		);
		createTab(new Version(new int[]{4, 1, 2, 4}, "Alpha"),
				"Fixed Core sizing problems and allowed for bigger calculator numbers"
		);
		createTab(new Version(new int[]{4, 1, 2, 3}, "Alpha"),
				"Simplified window creation with a new method"
		);
		createTab(new Version(new int[]{4, 1, 2, 2}, "Alpha"),
				"Cleaned up some old files"
		);
		createTab(new Version(new int[]{4, 1, 2, 1}, "Alpha"),
				"Added calculator and inclusive features\nCalculator available in Quiz"
		);
		createTab(new Version(new int[]{4, 1, 2, 0}, "Alpha"),
				"Added further core implementation, specifically exit and quiz."
		);
		createTab(new Version(new int[]{4, 1, 1, 0}, "Alpha"),
				"Completed Load, Generator and added Achievements"
		);
		createTab(new Version(new int[]{4, 0, 0, 0}, "Alpha"),
				"Starting Code, far from production.\nContains up to login sequence, including unfinished Load mechanics and Core UI"
		);
		return list;
	}

	private void createTab(Version version, String info){
		list.add(new Tab(version, info));
	}
}
