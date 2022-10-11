package api.models.Config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class Config {
    @SerializedName("URI")
    @Expose
    public String uri = "localhost";

}
