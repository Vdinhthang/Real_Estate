package com.javaweb.Model;

import java.util.List;

public class ErrorResponse {
    private String error;
    private List<String> details;

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getDetails() {
        return details;
    }

    public String getError() {
        return error;
    }
}
