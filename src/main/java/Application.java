import com.aor.BomberMan;
import com.aor.Leaderboard.LeaderboardFactory;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        BomberMan game = BomberMan.getInstance();
        game.start();
    }
}
