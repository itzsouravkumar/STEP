public class ArtGallery {
    public static void main(String[] args) {
        Artwork[] gallery = new Artwork[4];
        gallery[0] = new Painting("Starry Night", "Impasto", "Blue & Yellow", "Wooden Frame");
        gallery[1] = new Sculpture("David", "Marble", "6.17 m", "Spotlight");
        gallery[2] = new DigitalArt("Virtual Landscape", "4K", "PNG", true);
        gallery[3] = new Photography("Sunset Bliss", "ISO100, f/11", "Lightroom Edit", "24x36 Print");

        for (Artwork art : gallery) {
            art.display();

            if (art instanceof Painting) {
                ((Painting) art).showDetails();
            } else if (art instanceof Sculpture) {
                ((Sculpture) art).showDetails();
            } else if (art instanceof DigitalArt) {
                ((DigitalArt) art).showDetails();
            } else if (art instanceof Photography) {
                ((Photography) art).showDetails();
            }

            System.out.println();
        }
    }
}

class Artwork {
    protected String title;

    public Artwork(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println("Displaying artwork: " + title);
    }
}

class Painting extends Artwork {
    private String brushTechnique;
    private String colorPalette;
    private String frame;

    public Painting(String title, String brushTechnique, String colorPalette, String frame) {
        super(title);
        this.brushTechnique = brushTechnique;
        this.colorPalette = colorPalette;
        this.frame = frame;
    }

    public void showDetails() {
        System.out.println("Painting: " + title);
        System.out.println("Brush Technique: " + brushTechnique);
        System.out.println("Color Palette: " + colorPalette);
        System.out.println("Frame: " + frame);
    }
}

class Sculpture extends Artwork {
    private String material;
    private String dimensions;
    private String lighting;

    public Sculpture(String title, String material, String dimensions, String lighting) {
        super(title);
        this.material = material;
        this.dimensions = dimensions;
        this.lighting = lighting;
    }

    public void showDetails() {
        System.out.println("Sculpture: " + title);
        System.out.println("Material: " + material);
        System.out.println("Dimensions: " + dimensions);
        System.out.println("Lighting: " + lighting);
    }
}

class DigitalArt extends Artwork {
    private String resolution;
    private String fileFormat;
    private boolean interactive;

    public DigitalArt(String title, String resolution, String fileFormat, boolean interactive) {
        super(title);
        this.resolution = resolution;
        this.fileFormat = fileFormat;
        this.interactive = interactive;
    }

    public void showDetails() {
        System.out.println("Digital Art: " + title);
        System.out.println("Resolution: " + resolution);
        System.out.println("File Format: " + fileFormat);
        System.out.println("Interactive Elements: " + (interactive ? "Yes" : "No"));
    }
}

class Photography extends Artwork {
    private String cameraSettings;
    private String editing;
    private String printSpecs;

    public Photography(String title, String cameraSettings, String editing, String printSpecs) {
        super(title);
        this.cameraSettings = cameraSettings;
        this.editing = editing;
        this.printSpecs = printSpecs;
    }

    public void showDetails() {
        System.out.println("Photography: " + title);
        System.out.println("Camera Settings: " + cameraSettings);
        System.out.println("Editing: " + editing);
        System.out.println("Print Specs: " + printSpecs);
    }
}