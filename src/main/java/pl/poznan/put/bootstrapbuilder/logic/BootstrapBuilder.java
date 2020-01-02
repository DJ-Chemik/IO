package pl.poznan.put.bootstrapbuilder.logic;

/**
 * Basic BootstrapBuilder structure, that creates bootstrap code based on given parameters
 *
 * @author Jan Śmiełowski
 * @author Mikołaj Szymczak
 * @author Szymon Szczepański
 * @version 2.0
 */
public class BootstrapBuilder {

    // fields declaration
    private boolean header;
    private boolean footer;
    private String title, type, description, image;
    private String headerVersion;
    private String seoVersion;

    /**
     * Basic constructor, creates an object based on each given parameters
     *
     * @param header Specifier for header
     * @param footer Specifier for footer
     * @param title Specifier for title
     * @param type Specifier for type
     * @param description Specifier for description
     * @param image Specifier for image source
     * @param headerVersion Specifier for headerVersion
     * @param seoVersion Specifier for seoVersion
     */
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

    /**
     * Basic constructor, creates an object based on Builder parameters
     *
     * @param b Builder instance, used as a template for BootstrapBuilder
     */
    private BootstrapBuilder(Builder b) {
        this.header = b.header;
        this.footer = b.footer;
        this.title = b.title;
        this.type = b.type;
        this.description = b.description;
        this.image = b.image;
        this.headerVersion = b.headerVersion;
        this.seoVersion = b.seoVersion;
    }

    /* Basic getters and setters */
    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    public boolean isFooter() {
        return footer;
    }

    public void setFooter(boolean footer) {
        this.footer = footer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeaderVersion() {
        return headerVersion;
    }

    public void setHeaderVersion(String headerVersion) {
        this.headerVersion = headerVersion;
    }

    public String getSeoVersion() {
        return seoVersion;
    }

    public void setSeoVersion(String seoVersion) {
        this.seoVersion = seoVersion;
    }
    /* end of getters & setters */

    /**
     * Generates bootstrap, based on instance parameters
     *
     * @return Bootstrap code with formatted tags
     */
    public String getBootstrap() {
        // formatting seoVersion
        if (seoVersion == null)
            seoVersion = "";
        else
            seoVersion += ":";

        // HEAD
        String metaCharset = "\t\t<meta charset=\"utf-8\">\n";
        String metaViewport = "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n";
        String link = "\t\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n";
        String metaTitle = String.format("\t\t<meta name=\"%stitle\" content=\"%s\">\n", seoVersion, title);
        String metaType = String.format("\t\t<meta name=\"%stype\" content=\"%s\">\n", seoVersion, type);
        String metaDesc = String.format("\t\t<meta name=\"%sdescription\" content=\"%s\">\n", seoVersion, description);
        String metaImage = String.format("\t\t<meta name=\"%simage\" content=\"%s\">\n", seoVersion, image);
        String head = String.format("\t<head>\n%s\t</head>\n", metaCharset + metaViewport + link + metaTitle + metaType + metaDesc + metaImage);

        // BODY
        String mHeader = "";
        if (header) {
            if (headerVersion.equals("fixed"))
                mHeader = "\t\t<nav class=\"navbar fixed-top\">\n\t\t\t\n\t\t</nav>\n\n";
            else // static
                mHeader = "\t\t<nav class=\"navbar\">\n\t\t\t\n\t\t</nav>\n\n";
        }

        String mMain = "\t\t<main class=\"container\">\n\t\t\t\n\t\t</main>\n\n";

        String mFooter = "";
        if (footer)
            mFooter = "\t\t<footer class=\"footer\">\n\t\t\t\n\t\t</footer>\n\n";

        String body = String.format("\t<body>\n%s\t</body>\n", mHeader + mMain + mFooter);

        // HTML return
        return String.format("<html>\n%s</html>", head + body);
    }

    /**
     * Generates BootstrapBuilder instance with parameters
     *
     * @author Szymon Szczepański
     */
    public static class Builder{

        private boolean header;
        private boolean footer;
        private String title, type, description, image;
        private String headerVersion;
        private String seoVersion;

        /**
         * Basic empty contructor, for instantiating Builder
         *
         */
        public Builder() {
        }

        /**
         * Specifier for header
         *
         * @param h header presence
         * @return Builder instance
         */
        public Builder header(boolean h){
            this.header = h;
            return this;
        }

        /**
         * Specifier for footer
         *
         * @param f footer presence
         * @return Builder instance
         */
        public Builder footer(boolean f){
            this.footer=f;
            return this;
        }

        /**
         * Specifier for title
         *
         * @param s title content
         * @return Builder instance
         */
        public Builder title(String s){
            this.title=s;
            return this;
        }

        /**
         * Specifier for type
         *
         * @param s type content
         * @return Builder instance
         */
        public Builder type(String s){
            this.type=s;
            return this;
        }

        /**
         * Specifier for description
         *
         * @param s description content
         * @return Builder instance
         */
        public Builder description(String s){
            this.description=s;
            return this;
        }

        /**
         * Specifier for image source
         *
         * @param s image source
         * @return Builder instance
         */
        public Builder image(String s){
            this.image=s;
            return this;
        }

        /**
         * Specifier for header version
         *
         * @param s header version content
         * @return Builder instance
         */
        public Builder headerVersion(String s){
            this.headerVersion=s;
            return this;
        }

        /**
         * Specifier for SEO version
         *
         * @param s SEO version content
         * @return Builder instance
         */
        public Builder seoVersion(String s){
            this.seoVersion=s;
            return this;
        }

        /**
         * Creates BootstrapBuilder instance of a given Builder parameters
         *
         * @return BootstrapBuilder instance of a desired specification
         */
        public BootstrapBuilder build(){
            return new BootstrapBuilder(this);
        }
    }

    @Override
    public String toString(){
        return String.format("{}\n {}\n {}\n {}\n {}\n {}\n {}\n {}", this.header, this.footer, this.title, this.type, this.description, this.image, this.headerVersion, this.seoVersion);
    }
}
