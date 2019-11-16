package br.unitins.motoshow.model;

public enum Categoria {
	
	SCOOTER(1, "Scooter"), 
	CUB(2, "CUB"), 
	ESPORTIVA(3, "Esportiva-Street"), 
	NAKED(4, "Naked");
	
	private int value;
	private String label;
	
	Categoria(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
	// retorna uma categoria a partir de um valor inteiro
	public static Categoria valueOf(int value) {
		for (Categoria cat : Categoria.values()) {
			if (cat.getValue() == value) {
				return cat;
			}
		}
		return null;
	}

}
