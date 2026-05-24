package cucumber;

import org.gameshop.Game;

import java.util.ArrayList;
import java.util.List;

public class CartSteps {

    public void addGameToCart(Game game) {}

    public void removeGameFromCart(Game game) {}

    public String checkPresenceOfGameInCart(Game game) {
        String checkResult = null;

        return checkResult;
    }

    public List<Game> getGameListInCart(Game game) {
        List<Game> gameList = new ArrayList<>();
        return gameList;
    }

    public String checkPriceOfGamesInCart(Game game) {
        String checkResult = null;
        return checkResult;
    }


    public void emptyCart(Game game) {}

    public void buyGamesInCart(Game game) {
        //For now, it will do the same as emptyCart , but will be different message
        // Later with developing payment and account system will need to change it
    }

    public void checkOwningGameByAccount(Game game) {
        //For now, it will do nothing
        //With developing account system
    }
}
