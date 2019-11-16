package br.unitins.motoshow.model;

public enum Cilindrada {

	C50(1,"50 Cilindradas"),
	C100(2,"100 Cilindradas"),
	C110(3,"110 Cilindradas"),
	C125(4,"125 Cilindradas"),
	C3OO(5,"300 Cilindradas"),
	C600(6,"600 Cilindradas"),
	C1000(7,"1000 Cilindradas");

	
	private int value;
	private String label;
	
	Cilindrada(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
	// retorna um tamanhoAro a partir de um valor inteiro
	public static Cilindrada valueOf(int value) {
		for (Cilindrada cilindrada : Cilindrada.values()) {
			if (cilindrada.getValue() == value) {
				return cilindrada;
			}
		}
		return null;
	}
}
