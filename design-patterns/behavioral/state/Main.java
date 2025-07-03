package behavioral.state;

public class Main {
    public static void main(String[] args) {
        Player musicPlayer = new Player();
        musicPlayer.play();
        musicPlayer.play();
        musicPlayer.pause();
        musicPlayer.pause();
        musicPlayer.stop();
        musicPlayer.stop();
        musicPlayer.play();
    }
}

interface State {
    void play();
    void pause();
    void stop();
}

class PlayingState implements State {
    private final Player player;

    public PlayingState(Player player) {
        this.player = player;
    }

    public void play() {
        System.out.println("[PlayingState] Already playing!");
    }

    public void pause() {
        player.changeState(new PausedState(player));
        System.out.println("[PlayingState] Pausing...");
    }

    public void stop() {
        player.changeState(new StoppedState(player));
        System.out.println("[PlayingState] Stopped.");
    }
}

class PausedState implements State {
    private final Player player;

    public PausedState(Player player) {
        this.player = player;
    }

    public void play() {
        player.changeState(new PlayingState(player));
        System.out.println("[PausedState] Playing...");
    }

    public void pause() {
        System.out.println("[PausedState] Already paused");
    }

    public void stop() {
        player.changeState(new StoppedState(player));
        System.out.println("[PausedState] Stopped.");
    }
}

class StoppedState implements State {
    private final Player player;

    public StoppedState(Player player) {
        this.player = player;
    }

    public void play() {
        player.changeState(new PlayingState(player));
        System.out.println("[StoppedState] Playing...");
    }

    public void pause() {
        System.out.println("[StoppedState] Already not playing");
    }

    public void stop() {
        System.out.println("[StoppedState] Already stopped.");
    }
}

class Player {
    private State state;

    public Player() {
        this.state = new StoppedState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void play() {
        state.play();
    }

    public void pause() {
        state.pause();
    }

    public void stop() {
        state.stop();
    }
}


