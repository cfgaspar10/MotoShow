package br.unitins.motoshow.model;

public enum Marca {

	HONDA (1, "Honda"), 
	YAMAHA(2, "Yamaha"),
	SUZUKI(3, "Suzuki"),
	DAFRA(4, "Dafra"),
	KASINSKI(5, "Kasinski"),
	KAWASAKI(6,"Kawasaki");
	
	private int value;
	private String label;
	
	Marca(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
	// retorna uma marca a partir de um valor inteiro
	public static Marca valueOf(int value) {
		for (Marca marca : Marca.values()) {
			if (marca.getValue() == value) {
				return marca;
			}
		}
		return null;
	}
}
