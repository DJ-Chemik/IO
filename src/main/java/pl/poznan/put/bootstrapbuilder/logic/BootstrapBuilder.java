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

    // basic bootstrap getter
    public String getBootstrap() {
        // formatting seoVersion
        if (seoVersion == null)
            seoVersion = "";
        else
            seoVersion += ":";

        // HEAD
        String metaTitle = String.format("\t\t<meta name=\"%stitle\" content=\"%s\">\n", seoVersion, title);
        String metaType = String.format("\t\t<meta name=\"%stype\" content=\"%s\">\n", seoVersion, type);
        String metaDesc = String.format("\t\t<meta name=\"%sdescription\" content=\"%s\">\n", seoVersion, description);
        String metaImage = String.format("\t\t<meta name=\"%simage\" content=\"%s\">\n", seoVersion, image);
        String head = String.format("\t<head>\n%s\t</head>\n", metaTitle + metaType + metaDesc + metaImage);

        // BODY
        String mHeader = "";
        if (header) {
            if (headerVersion.equals("static"))
                mHeader = "\t\t<nav class=\"navbar\">\n\t\t\t\n\t\t</nav>\n\n";
            else if (headerVersion.equals("fixed"))
                mHeader = "\t\t<nav class=\"navbar fixed-top\">\n\t\t\t\n\t\t</nav>\n\n";
            else; // TODO: handle incompatible header type
        }

        String mMain = "\t\t<main class=\"container\">\n\t\t\t\n\t\t</main>\n\n";

        String mFooter = "";
        if (footer)
            mFooter = "\t\t<footer class=\"footer\">\n\t\t\t\n\t\t</nav>\n\n";

        String body = String.format("\t<body>\n%s\t</body>\n", mHeader + mMain + mFooter);

        // HTML return
        return String.format("<html>\n%s</html>", head + body);
    }

}
