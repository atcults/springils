package org.sanelib.ils.api.errorhandling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorResponse {

    private final Map<String, ErrorLine> errors = new HashMap<>();

    public void addError(List<String> fieldNames, String message){

        String key = String.join(",", fieldNames);

        if(this.errors.containsKey(key)){
            ErrorLine line = this.errors.get(key);
            line.addMessage(message);
        } else{
            this.errors.put(key, new ErrorLine(fieldNames, message));
        }
    }

    public void addError(String fieldName, String message){

        if(this.errors.containsKey(fieldName)){
            ErrorLine line = this.errors.get(fieldName);
            line.addMessage(message);
        } else{
            this.errors.put(fieldName, new ErrorLine(Collections.singletonList(fieldName), message));
        }
    }

    public Collection<ErrorLine> getErrors() {
        return errors.values();
    }

    public boolean isValid() {
        return this.errors.isEmpty();
    }

    public static class ErrorLine {

        private final List<String> fieldNames = new ArrayList<>();
        private final List<String> messages = new ArrayList<>();

        /**
         *
         * @param fieldNames	Filed names of submitted form
         * @param message		Error message
         */
        public ErrorLine(List<String> fieldNames, String message) {
            this.fieldNames.addAll(fieldNames);
            this.messages.add(message);
        }

        private void addMessage(String message){
            this.messages.add(message);
        }

        public List<String> getFiledNames(){
            return this.fieldNames;
        }

        public List<String> getMessages(){
            return this.messages;
        }

    }
}