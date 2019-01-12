package ir.vasl.globalEnums;

public enum EnumNotificationAction {

    undefined("undefine"),
    OPEN_APP("open_app"),
    OPEN_URL("open_url"),;

    private String value;

    EnumNotificationAction(String value) {
        this.value = value;
    }

    public String getCode() {
        return value;
    }

    public static EnumNotificationAction Parse(String value) {
        if (value == null) {
            return undefined;
        }
        EnumNotificationAction[] arr$ = values();
        for (EnumNotificationAction val : arr$) {
            if (val.value.equals(value)) {
                return val;
            }
        }
        return undefined;
    }


}
