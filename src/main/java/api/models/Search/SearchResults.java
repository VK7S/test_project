package api.models.Search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class SearchResults {

    @SerializedName("cursorToken")
    @Expose
    public Object cursorToken;
    @SerializedName("originalStatementCount")
    @Expose
    public Integer originalStatementCount;
    @SerializedName("statements")
    @Expose
    public List<Statement> statements = null;

}
