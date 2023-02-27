package HBDONF.util;

public interface JsonSerializable {
    //
    default String toJsonString() {
        //
        return JsonUtil.toJson(this);
    }
}
