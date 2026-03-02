public class SocialMediaFeed {
    public static void main(String[] args) {
        Post insta = new InstagramPost("Alice", "Enjoying the sunset!", "2:00 PM", 150, "#sunset #nature");
        Post twitter = new TwitterPost("Bob", "Just had coffee!", "3:15 PM", 25);
        Post linkedin = new LinkedInPost("Charlie", "Excited to start my new job!", "9:00 AM", 500);

        insta.display();
        System.out.println();
        twitter.display();
        System.out.println();
        linkedin.display();
    }
}

class Post {
    protected String author;
    protected String content;
    protected String time;

    public Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Time: " + time);
    }
}

class InstagramPost extends Post {
    private int likes;
    private String hashtags;

    public InstagramPost(String author, String content, String time, int likes, String hashtags) {
        super(author, content, time);
        this.likes = likes;
        this.hashtags = hashtags;
    }

    @Override
    public void display() {
        System.out.println("Instagram Post:");
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Time: " + time);
        System.out.println("Likes: " + likes);
        System.out.println("Hashtags: " + hashtags);
    }
}

class TwitterPost extends Post {
    private int retweets;

    public TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    @Override
    public void display() {
        System.out.println("Twitter Post:");
        System.out.println("Author: " + author);
        System.out.println("Content: " + content + " (Characters: " + content.length() + ")");
        System.out.println("Time: " + time);
        System.out.println("Retweets: " + retweets);
    }
}

class LinkedInPost extends Post {
    private int connections;

    public LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    @Override
    public void display() {
        System.out.println("LinkedIn Post:");
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Time: " + time);
        System.out.println("Connections: " + connections);
        System.out.println("Professional Formatting Applied");
    }
}