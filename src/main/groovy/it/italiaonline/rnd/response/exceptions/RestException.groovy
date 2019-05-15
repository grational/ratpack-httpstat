package it.italiaonline.rnd.response.exceptions

interface RestException {
	Integer code()
	String  json()
}
