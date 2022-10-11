package api.rest;

public class Endpoints {
    public static final String API = "services/i/";

    public static class PublicDocs {
        public static final String PUBLIC_DOCS = API + "public-document-data/";
        public static final String DOCUMENT = PUBLIC_DOCS + "document/{documentId}";
    }
}
