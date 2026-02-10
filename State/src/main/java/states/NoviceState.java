package states;

import character.CharacterState;
import character.GameCharacter;

public class NoviceState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You trained hard and gained 20 XP!");
        character.gainExperience(20);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("No no, you cannot meditate at novice level!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("No no, you cannot fight at novice level!");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}