package com.tech1.personelmanagementsystem.Core.Utilities.Results;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true,message);
    }

}
