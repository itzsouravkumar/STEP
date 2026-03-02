public class PlayerTest {
    public static void main(String[] args) {
        Playable player = new MusicPlayer();
        player.play();
        player.pause();

        System.out.println();

        player = new VideoPlayer();
        player.play();
        player.pause();
    }
}