import java.util.Random;


public class WheelOfFortuneBot extends WheelOfFortuneObject{

    private String choice;
    @Override
    public String getGuess() {
        // generate alphabet String
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = new Random().nextInt(alphabet.length());
        choice = String.valueOf(alphabet.charAt(index));
        return choice;
    }

    public static void main(String[] args) {
        WheelOfFortuneBot game = new WheelOfFortuneBot();
        game.startGame();
    }
}
