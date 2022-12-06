package com.computer;

public class Laptop extends Computer implements Graphic {
    // 당연히 추상method를 overriding해야 우리 class가 추상class가 되지 않아요. ; 추상class가 되면 객체 생성 불가능해짐
	public Laptop() {

	}
    // generate constructor from super class
	public Laptop(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);

	}

	@Override
	public double rendering(int size) {
		// () type을 강제 변환 (casting, 형변환)
		double render = (double) size / (getCpu() * getMemory()) * 20;
		render = Math.round(render * 100) / 100.0;

		return render;
	}

	@Override
	public void operate(int time) {
      // 입력으로 들어온 시간 10당 1씩 배터리가 감소.
	  // 프로그램에서 연산(+,-,/,*)은 동일 data type으로 맞춰야한다. (정수 / 정수 = 정수 ; 소수점 버림)
	    int result = time/10 ;
		setBattery(getBattery() - (result));
	}

}

