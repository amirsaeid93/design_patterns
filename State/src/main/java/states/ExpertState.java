package states;

import character.CharacterState;
import character.GameCharacter;

public class ExpertState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You trained and gained 30 XP!");
        character.gainExperience(30);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You meditated and restored 15 HP!");
        character.gainHealth(15);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You fought bravely, lost 20 HP but gained 50 XP!");
        character.loseHealth(20);
        character.gainExperience(50);
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}