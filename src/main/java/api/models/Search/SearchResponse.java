package api.models.Search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {

    @SerializedName("topics")
    @Expose
    public List<Object> topics = null;
    @SerializedName("searchResults")
    @Expose
    public SearchResults searchResults;

}
