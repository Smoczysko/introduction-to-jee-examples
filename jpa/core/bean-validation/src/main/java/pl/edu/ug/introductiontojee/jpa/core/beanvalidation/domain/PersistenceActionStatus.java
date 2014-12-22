package pl.edu.ug.introductiontojee.jpa.core.beanvalidation.domain;

import java.util.ArrayList;
import java.util.List;

public class PersistenceActionStatus {
    private boolean success = true;
    private List<String> errors = new ArrayList<String>();

    public PersistenceActionStatus() {
        super();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
