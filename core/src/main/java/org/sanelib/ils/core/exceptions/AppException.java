package org.sanelib.ils.core.exceptions;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Class to map application related exceptions
 * 
 * @author amacoder
 *
 */
public class AppException extends Exception {

	private static final long serialVersionUID = -8999932578270387947L;
	
	ProcessError processError;
	
	/**
	 * 
	 * @param processError ProcessError
	 */
	public AppException(ProcessError processError) {
		super("Total errors:" + processError.getErrors().size());
        this.processError = processError;
	}

    public ProcessError getProcessError() {
        return processError;
    }

    public void setProcessError(ProcessError processError) {
        this.processError = processError;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
