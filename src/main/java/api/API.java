package api;

import api.models.Config.Config;
import api.services.PublicDocuments;
import lombok.Getter;

@Getter
public class API {
    private PublicDocuments publicDocuments;

    public API(Config conf) {
        publicDocuments = new PublicDocuments(conf);
    }
}
