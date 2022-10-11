package api.models.Search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Statement {

    @SerializedName("accessionNumber")
    @Expose
    public String accessionNumber;
    @SerializedName("collapsedStatements")
    @Expose
    public List<String> collapsedStatements = null;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("context")
    @Expose
    public Boolean context;
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("recurring")
    @Expose
    public Boolean recurring;
    @SerializedName("snippetCount")
    @Expose
    public Integer snippetCount;
    @SerializedName("snippetOffset")
    @Expose
    public Integer snippetOffset;
    @SerializedName("statementId")
    @Expose
    public String statementId;
    @SerializedName("statementIndex")
    @Expose
    public Integer statementIndex;
    @SerializedName("statementIndexOffset")
    @Expose
    public Integer statementIndexOffset;

}
