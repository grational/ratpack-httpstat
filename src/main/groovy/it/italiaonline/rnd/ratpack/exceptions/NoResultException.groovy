package it.italiaonline.rnd.ratpack.exceptions

import groovy.json.JsonBuilder

final class NoResultException extends RuntimeException implements RestException {
	final private String source

	NoResultException(String src) {
		this.source = Objects.requireNonNull(src,'Source name is mandatory')
	}

	Integer code() { 422 }

	String json() {
		def builder = new JsonBuilder()
		builder {
			status 'error'
			message "No result found for '${this.source}'"
		}
		builder.toString()
	}
}
