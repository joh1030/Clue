package clueGame;

public class Card {
	
	public enum CardType {
		ROOM, WEAPON, PERSON;
	}
	
	public String name;
	
	CardType cardType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	
}
