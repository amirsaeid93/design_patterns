package states;

import character.CharacterState;
import character.GameCharacter;

public class IntermediateState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You trained and gained 25 XP!");
        character.gainExperience(25);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You meditated and restored 10 HP!");
        character.gainHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("No no, you cannot fight at intermediate level!");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}
