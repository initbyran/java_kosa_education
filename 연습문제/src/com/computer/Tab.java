package com.computer;

public class Tab extends Computer implements Graphic {

	public Tab() {

	}

	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);

	}

	@Override
	public double rendering(int size) {
		double render = ((double) size / (double) (getCpu() * getMemory()) * 30);
		render = Math.round(render * 100) / 100.0;

		return render;
	}

	@Override
	public void operate(int time) {
		int result = time / 5 ;
		setBattery(getBattery() - (result));
	}

}

