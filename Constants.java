public class Constants {
    public static final String FROM_CONSTRUCTOR = "MyStringBuilder(String)";
    public static final String FROM_DEEPCOPY_CONSTRUCTOR =
                                            "MyStringBuilder(MyStringBuilder)";
    public static final String FROM_APPEND_STR = "append(String)";
    public static final String FROM_INSERT_CHAR = "insert(char, int)";
    public static final String FROM_INSERT_STR = "insert(String, int)";
    public static final String FROM_FIND_INDEX = "findIndex(int)";
    public static final String FROM_REMOVE = "remove(int)";
    public static final String FROM_DELETE_STARTINDEX = "delete(int)";
    public static final String FROM_DELETE_STARTINDEX_ENDINDEX =
                                                            "delete(int, int)";
    public static final String FROM_SUBSTRING_STARTINDEX = "substring(int)";
    public static final String FROM_SUBSTRING_STARTINDEX_ENDINDEX =
                                                          "substring(int, int)";
    public static final String FROM_CONCAT = "concat(MyStringBuilder)";
    public static final String MESSAGE_CONSTRUCTOR = "string passed in is null";
    public static final String MESSAGE_DEEPCOPY_CONSTRUCTOR =
                                                    "object passed in is null";
    public static final String MESSAGE_APPREND_STR = "string passed in is null";
    public static final String MESSAGE_INSERT_CHAR = "index is out of bounds";
    public static final String MESSAGE_INSERT_STR1 = "string passed in is null";
    public static final String MESSAGE_INSERT_STR2 = "index is out of bounds";
    public static final String MESSAGE_FIND_INDEX = "index is out of bounds";
    public static final String MESSAGE_REMOVE = "index is out of bounds";
    public static final String MESSAGE_DELETE_STARTINDEX =
                                                  "startIndex is out of bounds";
    public static final String MESSAGE_DELETE_STARTINDEX_ENDINDEX1 =
    "endIndex is smaller than startIndex";
    public static final String MESSAGE_DELETE_STARTINDEX_ENDINDEX2 =
    "startIndex/endIndex is out of bounds";
    public static final String MESSAGE_SUBSTRING_STARTINDEX =
    "startIndex is out of bounds";
    public static final String MESSAGE_SUBSTRING_STARTINDEX_ENDINDEX1 =
    "startIndex/endIndex is out of bounds";
    public static final String MESSAGE_SUBSTRING_STARTINDEX_ENDINDEX2 =
    "endIndex is smaller than startIndex";
    public static final String MESSAGE_CONCAT =
                                     "object passed in is not the correct type";

}
