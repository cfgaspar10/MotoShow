package br.unitins.motoshow.model;

public enum Modelo {

	TITAN (1, "Titan"), 
	FAZER(2, "Fazer"),
	GSX(3, "GSX"),
	SLIDER(4, "Slider"),
	BIZ(5,"Biz");
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
