package pl.poznan.put.bootstrapbuilder.logic;

public class BootstrapBuilder {

    // fields declaration
    private boolean header;
    private boolean footer;
    private String title, type, description, image;
    private String headerVersion;
    private String seoVersion;

    // constructor declaration
    public BootstrapBuilder(boolean header, boolean footer, String title, String type,
                            String description, String image, String headerVersion, String seoVersion) {
        this.header = header;
        this.footer = footer;
        this.title = title;
        this.type = type;
        this.description = description;
        this.image = image;
        this.headerVersion = headerVersion;
        this.seoVersion = seoVersion;
    }

}
