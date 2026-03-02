public class StreamingPlatform {
    public static void main(String[] args) {
        Content[] library = new Content[3];
        library[0] = new Movie("Inception", 8.8, 148, true);
        library[1] = new TVSeries("Stranger Things", 4, 34, "Chapter Five");
        library[2] = new Documentary("Planet Earth", "Nature, Wildlife", "Blue Planet");

        for (Content c : library) {
            c.play();
            if (c instanceof Movie) {
                ((Movie) c).showDetails();
            } else if (c instanceof TVSeries) {
                ((TVSeries) c).showDetails();
            } else if (c instanceof Documentary) {
                ((Documentary) c).showDetails();
            }
            System.out.println();
        }
    }
}

class Content {
    protected String title;

    public Content(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Playing content: " + title);
    }
}

class Movie extends Content {
    private double rating;
    private int duration;
    private boolean subtitles;

    public Movie(String title, double rating, int duration, boolean subtitles) {
        super(title);
        this.rating = rating;
        this.duration = duration;
        this.subtitles = subtitles;
    }

    public void showDetails() {
        System.out.println("Movie: " + title);
        System.out.println("Rating: " + rating);
        System.out.println("Duration: " + duration + " mins");
        System.out.println("Subtitles Available: " + subtitles);
    }
}

class TVSeries extends Content {
    private int seasons;
    private int episodes;
    private String nextEpisode;

    public TVSeries(String title, int seasons, int episodes, String nextEpisode) {
        super(title);
        this.seasons = seasons;
        this.episodes = episodes;
        this.nextEpisode = nextEpisode;
    }

    public void showDetails() {
        System.out.println("TV Series: " + title);
        System.out.println("Seasons: " + seasons + ", Episodes: " + episodes);
        System.out.println("Next Episode Suggestion: " + nextEpisode);
    }
}

class Documentary extends Content {
    private String tags;
    private String relatedContent;

    public Documentary(String title, String tags, String relatedContent) {
        super(title);
        this.tags = tags;
        this.relatedContent = relatedContent;
    }

    public void showDetails() {
        System.out.println("Documentary: " + title);
        System.out.println("Educational Tags: " + tags);
        System.out.println("Related Content: " + relatedContent);
    }
}