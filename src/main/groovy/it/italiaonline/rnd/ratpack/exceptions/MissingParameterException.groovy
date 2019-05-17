package it.italiaonline.rnd.ratpack.exceptions

import groovy.json.JsonBuilder

final class MissingParameterException extends RuntimeException implements RestException {
	final private List requiredParams

	MissingParameterException(List lst) {
		this.requiredParams = Objects.requireNonNull(lst,'List of required params is mandatory')
	}

	Integer code() { 422 }

	String json() {
		def builder = new JsonBuilder()
		builder {
			status 'error'
			message "At least one of the required parameter is missing: ${this.requiredParams.join(', ')}"
		}
		builder.toString()
	}
}
