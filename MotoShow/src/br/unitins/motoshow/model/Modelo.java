package br.unitins.motoshow.model;

public enum Modelo {

	TITAN (1, "Titan"), 
	FAZER(2, "Fazer"),
	GSX(3, "GSX"),
	SLIDER(4, "Slider"),
	BIZ(5,"Biz"),
	POP(6,"POP"),
	CGFAN(7,"Fan"),
	CBTWISTER(8,"Twister"),
	CB1000R(9,"CB-1000R"),
	NEO(10,"Neo"),
	FACTOR(11,"Factor"),
	CROSSER(12,"Crosser"),
	MT03(13,"MT-03"),
	NINJA(14,"Ninja");
	
	private int value;
	
	private String label;
	
	Modelo(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
	// retorna uma modelo a partir de um valor inteiro
	public static Modelo valueOf(int value) {
		for (Modelo modelo : Modelo.values()) {
			if (modelo.getValue() == value) {
				return modelo;
			}
		}
		return null;
	}
}
