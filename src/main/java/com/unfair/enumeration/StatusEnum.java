package com.unfair.enumeration;

/*
 * @author Ferao
 * @date
 * @discription
 */
public enum StatusEnum {

    /**
     * 成功
     */
    SUCCESS("S", "处理成功"),

    /**
     * 处理中
     */
    HANDLING("U", "处理中"),

    /**
     * 失败
     */
    FAIL("F", "处理失败");

    private String state;
    private String message;

    StatusEnum(String state, String message) {
        this.state = state;
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessage(String state) {
        String message = "";
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getState().equals(state)) {
                message = statusEnum.getState();
            }
        }
        return message;
    }
}
