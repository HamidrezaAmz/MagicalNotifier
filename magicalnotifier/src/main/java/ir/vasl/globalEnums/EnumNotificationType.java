package ir.vasl.globalEnums;

public enum EnumNotificationType {

    undefined("undefine"),
    SIMPLE("simple"),
    SIMPLE_WITH_AVATAR("simple_with_avatar"),
    SIMPLE_WITH_AVATAR_AND_BUTTON("simple_with_avatar_and_button"),
    BIG_PICTURE("big_picture"),
    BIG_TEXT("big_text"),
    BIG_VIDEO("big_video"),
    SMART("smart"),
    CUSTOM("custom"),;

    private String value;

    EnumNotificationType(String value) {
        this.value = value;
    }

    public String getCode() {
        return value;
    }

    public static EnumNotificationType Parse(String value) {
        if (value == null) {
            return undefined;
        }
        EnumNotificationType[] arr$ = values();
        for (EnumNotificationType val : arr$) {
            if (val.value.equals(value)) {
                return val;
            }
        }
        return undefined;
    }


}
