package com.baizhi.common.entity;

public class Result {
    private Boolean success;
    private String massage;

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", massage='" + massage + '\'' +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Result(Boolean success, String massage) {

        this.success = success;
        this.massage = massage;
    }

    public Result() {

    }
}
