package it.italiaonline.rnd.ratpack.exceptions

interface RestException {
	Integer code()
	String  json()
}
