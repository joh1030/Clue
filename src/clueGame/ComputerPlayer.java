package clueGame;

import java.util.*;

public class ComputerPlayer extends Player {
	private ArrayList<Card> seenCards;
	private ArrayList<Card> allCards;
	private char lastRoomVisited;

	public ComputerPlayer() {
		super();
	}

	public ComputerPlayer(String name, String color, int row, int col) {
		super(name,color,row,col);
		seenCards= new ArrayList<Card>();
	}
	@Override
	public void addCard(Card card){
		super.addCard(card);
		seenCards.add(card);
	}


	public BoardCell pickLocation(Set<BoardCell> targets) {
		int loc = new Random().nextInt(targets.size()); 
		int i = 0;
		for(BoardCell cell : targets) {
			if(cell.isDoorway()){
				return cell;
			}
		}
		for(BoardCell cell : targets) {
			if (i == loc)
				return cell;
			i++;
		}
		return null;
	}

	public Suggestion createSuggestion(String room){
		ArrayList<Card> people=new ArrayList<Card>();
		ArrayList<Card> weapons=new ArrayList<Card>();
		String person;
		String weapon;
		for(Card c: allCards){
			if(!seenCards.contains(c)){
				if(c.cardType == Card.CardType.PERSON){
					people.add(c);
				}
				if(c.cardType == Card.CardType.WEAPON){
					weapons.add(c);
				}
			}
		}
		person=people.get(new Random().nextInt(people.size())).getName();
		weapon=weapons.get(new Random().nextInt(weapons.size())).getName();
		return new Suggestion(person,weapon,room);
	}
	public void setAllCards(ArrayList<Card> cardsIn){
		allCards=cardsIn;
	}

	public void updateSeen(Card seen) {
		seenCards.add(seen);
	}

}
