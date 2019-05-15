package it.italiaonline.rnd.response.exceptions

import groovy.json.JsonBuilder
import it.italiaonline.rnd.response.Meta
import it.italiaonline.rnd.response.exceptions.Error

final class MetaException extends RuntimeException implements RestException {
	final private Error  error
	final private Meta   meta
	final private String detail

	MetaException (
		Error  err,
		Meta   meta,
		String det = ''
	) {
		this.error   = err
		this.meta    = meta
		this.detail  = det
	}

	Integer code() { 422 }

	String json() {

		def result = meta.map()

		result.meta.faults += [
			code:    this.error.code,
			type:    this.error.type,
			message: this.detail ?: this.error.message
		]

		new JsonBuilder(result).toString()
	}
}
