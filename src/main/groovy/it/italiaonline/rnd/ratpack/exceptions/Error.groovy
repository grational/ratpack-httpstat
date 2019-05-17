package it.italiaonline.rnd.ratpack.exceptions

enum Error {
	INVALID_CODE {
		@Override Integer getCode()    { 1 }
		@Override String  getType()    { 'ERROR' }
		@Override String  getMessage() { "The http status code path parameter is invalid" }
	},
	MISSING_TIME {
		@Override Integer getCode()    { 2 }
		@Override String  getType()    { 'ERROR' }
		@Override String  getMessage() { "The time parameter is missing in the path" }
	},
	abstract Integer getCode()
	abstract String  getType()
	abstract String  getMessage()
}
