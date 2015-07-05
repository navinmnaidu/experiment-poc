package com.experiment.poc.dto;

/**
 * @author Vikram Purohit
 *
 */
public class BaseResponse<TYPE> {
    
    private STATUS status;
    
    private TYPE data;
    
    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public TYPE getData() {
        return data;
    }

    public void setData(TYPE data) {
        this.data = data;
    }

    public enum STATUS {
        OK,
        ERROR
    }
}

