package states;

import character.CharacterState;
import character.GameCharacter;

public class MasterState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("🏆 You are a Master. Training no longer needed!");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("🏆 You are a Master. Meditation is optional!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("🏆 You are a Master. No fights needed!");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }
}